/**
 * 获取导航栏的参数
 * @param name 参数的key
 * @returns {*} 参数值
 */
function getUrlParameter(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]);
    return null;
}