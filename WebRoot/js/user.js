/**
 * 载入数据
 */
function loadData(path) {
    $('#datagrid').datagrid({
        url: path,
        loadFilter: pagerFilter,
        rownumbers: true,
        singleSelect: false,
        pageSize: 10,
        pagination: true,
        multiSort: true,
        fitColumns: true,
        fit: true,
        columns: [[
            {checkbox: true},
            {field: 'id', title: '用户标识', width: 100, sortable: true},
            {field: 'contractNo', title: '支付账号', width: 100, sortable: true},
            {field: 'userName', title: '用户名', width: 100},
            {field: 'loginNo', title: '登录工号', width: 100},
            {
                field: 'sex', title: '性别', width: 100, formatter: function (value, row, index) {
                    return sexFormater(value);
                }
            },
            {field: 'deptName', title: '部门', width: 100},
            {
                field: 'totalFee', title: '账户余额', width: 100, formatter: function (value, row, index) {
                    if (value != null) {
                        return value + ".00元";
                    } else {
                        return "0.00元"
                    }

                }
            },
            {field: 'roleName', title: '职称', width: 100},
            {field: 'phoneNo', title: '手机号', width: 110},
            {
                field: 'registerTime', title: '注册时间', width: 100, formatter: function (value, row, index) {
                    //格式化时间戳
                    return DateTimeFormatter(value);
                }
            }
        ]]
    });
}

/**
 *  删除记录
 */
function remove() {
    var row = $('#datagrid').datagrid('getSelected');
    var mesTitle = "删除用户成功";
    if (row) {
        $.messager.confirm('信息提示', '确定要删除该记录？', function (result) {
            if (result) {
                var items = $('#datagrid').datagrid('getSelections');
                var ids = [];//记录要删除的用户标识
                $(items).each(function () {
                    ids.push(this.id);
                });
                $.ajax({
                    url: 'user_del.do',
                    data: {"ids": ids},
                    success: function (data) {
                        var result = eval('(' + data + ')');
                        if (result.success) {
                            $('#adddlg').dialog('close');
                            $('#datagrid').datagrid('reload');
                        }
                        else {
                            mesTitle = "删除用户失败";
                        }
                        $.messager.show({
                            title: mesTitle,
                            msg: result.msg
                        });
                    }
                });
            }
        });
    } else {
        $.messager.alert('提示', '请选择要删除的记录！', 'error');
    }
}

/**
 *  打开添加窗口
 */
function openAdd() {
    $('#addfrom').form('clear');
    $('#adddlg').dialog({
        closed: false,
        modal: true,
        title: "新建用户",
        buttons: [{
            text: '保存',
            iconCls: 'icon-ok',
            handler: function () {
                addUser();
            }
        }, {
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
                $('#adddlg').dialog('close');
            }
        }],
        onload: allDept()
    });
}

/**
 *  添加记录
 */
function addUser() {
    var mesTitle = "新增用户成功";
    $('#registerType').val("1");
    $('#userSatus').val("0");
    $('#addfrom').form('submit', {
        url: 'user_add.do',
        success: function (result) {
            /* console.info(result); */
            var result = eval('(' + result + ')');
            if (result.success) {
                $('#adddlg').dialog('close');
                $('#datagrid').datagrid('reload');
            } else {
                mesTitle = '新增用户失败';
            }
            $.messager.show({
                title: mesTitle,
                msg: result.msg
            });
        }
    });
}

/**
 * 获取部门列表
 */
function allDept() {
    $.ajax({
        type: "POST",
        url: "all_dept.do",
        success: function (data) {
            //必须通过eval函数才能解析成json数据，否则会报错
            var result = eval('(' + data + ')');
            data = result.rows;
            $('#depts').combobox('loadData', data);
            $('#depts').combobox('setValue', data[0].id);
            $('#sex').combobox('setValue', 0);
            allRole("role");
        },
        error: function () {
            console.log("查询部门信息失败.....")
        }
    });
}

/**
 * 获取角色列表
 */
function allRole(id) {
    $.ajax({
        type: "POST",
        url: "all_role.do",
        success: function (data) {
            //必须通过eval函数才能解析成json数据，否则会报错
            var result = eval('(' + data + ')');
            data = result.rows;
            $('#' + id).combobox('loadData', data);
            if (id == "sRoleId") {
                $('#sRoleId').combobox('setValue', "请选择职称");
            } else {
                $('#' + id).combobox('setValue', data[0].id);
            }
        },
        error: function () {
            console.log("查询部门信息失败.....")
        }
    });
}

/**
 * 刷新页面
 */
function reload() {
    $('#sPhoneNo').val("");
    $('#sRegisterTime').datetimebox("setValue", "");
    $('#sRoleId').combobox('setValue', "选择职称");
    window.location.reload();
}

/**
 * 条件查询
 */
function searchUser() {
    var path = "search_user.do?";
    var phone_no = $('#sPhoneNo').val();
    if (phone_no != "") {
        path += "phoneNo=" + phone_no;
    }
    var register_time = $('#sRegisterTime').datetimebox("getValue");
    if (register_time != "") {
        path += "registerTime=" + register_time;
    }
    var role_id = $('#sRoleId').combobox('getValue');
    if (role_id > 0) {
        path += "&roleId=" + role_id;
    }
    loadData(path);
}