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

function getPassWord(passWord) {
    return $.md5(passWord + "qcsaidksjau/./;'dakjhdaurfh");
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = decodeURI(window.location.search).substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}

//目录相关
var tagsUrl = "/tags/";

function getCategoryList(data, callback) {

    doAjax(tagsUrl + "byAuthorId", "GET", data, function (result) {
        callback(result);
    });
}

function deleteCategory(data, callback) {
    doAjax(tagsUrl + "/delete/tag", "POST", data, function (result) {
        callback(result);
    });
}

function addCategory(data, callback) {
    doAjax(tagsUrl + "tag", "POST", data, function (result) {
        callback(result);
    });
}

function updateCategory(data, callback) {
    doAjax(tagsUrl + "/put/tag", "POST", data, function (result) {
        callback(result);
    });
}

//文章相关
var articlesUrl = "/articles/";

function getArticleList(data, callback) {
    doAjax(articlesUrl + "byAuthorId", "GET", data, function (result) {
        callback(result);
    });
}

function getArticleListByTagId(data, callback) {
    doAjax(articlesUrl + "byCategoryId", "GET", data, function (result) {
        callback(result);
    });
}

function getArticleListByKeyWord(data, callback) {
    doAjax(articlesUrl + "byKeyWord", "GET", data, function (result) {
        callback(result);
    });
}

function getArticleById(data, callback) {
    doAjax(articlesUrl + "article/byId", "GET", data, function (result) {
        callback(result);
    });
}

function addArticle(data, callback) {
    doAjax(articlesUrl + "article", "POST", data, function (result) {
        callback(result);
    });
}

function updateArticle(data, callback) {
    doAjax(articlesUrl + "/put/article", "POST", data, function (result) {
        callback(result);
    });
}

function deleteArticle(data, callback) {
    doAjax(articlesUrl + "/delete/article", "POST", data, function (result) {
        callback(result);
    });
}

//登陆相关
var loginUrl = "/back/login";

function doLogin(data, callback) {
    doAjax(loginUrl, "POST", data, function (result) {
        callback(result);
    })
}

function doLogout(data, callback) {
    doAjax(loginUrl+"/logout", "POST", data, function (result) {
        callback(result);
    })
}
