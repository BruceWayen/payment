/**
 * Name 分页过滤器
 */
function pagerFilter(data) {
    if (typeof data.length == 'number' && typeof data.splice == 'function') {// is array
        data = {
            total: data.length,
            rows: data
        }
    }
    var dg = $(this);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    pager.pagination({
        onSelectPage: function (pageNum, pageSize) {
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh', {pageNumber: pageNum, pageSize: pageSize});
            dg.datagrid('loadData', data);
        }
    });
    if (!data.originalRows) {
        data.originalRows = (data.rows);
    }
    var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = (data.originalRows.slice(start, end));
    return data;
}

/**
 *
 * 格式化日期时间
 */
function DateTimeFormatter(value) {

    if (value == undefined) {
        return "";
    }
    var now = new Date(value);
    var year = now.getFullYear(),
        month = now.getMonth() + 1,
        date = now.getDate(),
        hour = now.getHours(),
        minute = now.getMinutes(),
        second = now.getSeconds();
    var reuslt = year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
    // alert(reuslt);
    return reuslt;
}

function formatDate(now) {
    var year = now.getFullYear(),
        month = now.getMonth() + 1,
        date = now.getDate(),
        hour = now.getHours(),
        minute = now.getMinutes(),
        second = now.getSeconds();

    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}


/**
 * 格式化性别
 */
function sexFormater(value) {
    if (value == 0) {
        return "男"
    } else {
        return "女"
    }
}