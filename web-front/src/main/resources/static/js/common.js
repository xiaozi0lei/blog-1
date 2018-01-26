// 所有页面加载时，先执行获取用户信息的操作，填写头部的用户信息
$(function () {
    $.ajax({
        type: "GET",
        url: "/getUserIdentity",
        success: function (response) {
            if (response) {
                // 获取用户
                var jsonStr = JSON.stringify(response);
                var jsonObj = JSON.parse(jsonStr);

                if (jsonObj.isLogin === "true") {
                    $("#username").text(jsonObj.username);
                    $("#login").hide();
                    $("#userDomain").show();
                } else {
                    $("#userDomain").hide();
                    $("#login").show();
                }
            }
        }
    });
})