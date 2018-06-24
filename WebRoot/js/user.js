/**
 * Name 删除记录
 */
function remove() {
    var row = $('#datagrid').datagrid('getSelected');
    if (row) {
        $.messager.confirm('信息提示', '确定要删除该记录？', function (result) {
            if (result) {
                var items = $('#wu-datagrid').datagrid('getSelections');
                var ids = [];
                $(items).each(function () {
                    ids.push(this.productid);
                });
                //alert(ids);return;
                $.ajax({
                    url: '',
                    data: '',
                    success: function (data) {
                        if (data) {
                            $.messager.alert('信息提示', '删除成功！', 'info');
                        }
                        else {
                            $.messager.alert('信息提示', '删除失败！', 'info');
                        }
                    }
                });
            }
        });
    } else {
        $.messager.alert('提示', '请选择要删除的记录！', 'error');
    }
}

/**
 * Name 打开添加窗口
 */
function openAdd(){
    $('#addfrom').form('clear');
    $('#adddlg').dialog({
        closed: false,
        modal:true,
        title: "新建用户",
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: function () {

            }
        }, {
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
                $('#adddlg').dialog('close');
            }
        }]
    });
}

function reload() {
    window.location.reload();
}