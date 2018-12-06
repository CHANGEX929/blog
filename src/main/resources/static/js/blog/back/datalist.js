function doAjax(url, type, data, callback) {
    $.ajax({
        url: url,
        type: type,
        data: data,
        dataType: "json",
        beforeSend: function () {
            $("#programBar").modal("show");
        },
        success: function (result) {
            callback(result);
        },
        error: function () {
            alert("系统繁忙");
        },
        complete: function () {
            $("#programBar").modal("hide");
        }
    });
}

function getCategoryList(data, callback) {

    doAjax("/tags/byAuthorId", "GET", data, function (result) {
        callback(result);
    });
}
