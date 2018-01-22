
function c_o_li_data() {
    var user = document.getElementById('username');
    var password = document.getElementById('password');
    var data = {};
    data["username"] = user.value;
    data["password"] = password.value;
    return data;
}
function c_o_li_submit() {
        var data = c_o_li_data();

        $.ajax({
            url: "login",
            type: "POST",
            //contex: ,
            data: data,
            dataType:"JSON",
            async: false,
            success: function(response) {
                if (response === true) {
                    alert("登录成功");
                    setTimeout('window.location.href="admin.html"');

                } else {
                    alert("账号或密码错误");
                }
                // setTimeout('window.location.href="index.html"', 1000);
            },
            error: function(xhr, msg, e) {
               alert(msg);
            }
        });
}

function  register_data() {
    var username = document.getElementById("register_username");
    var pass=document.getElementById("register_password");
    var passconfirm=document.getElementById("pass_confirm");
    if(pass.value!=passconfirm.value) {alert("两次密码不一样！"); return ;}
    var cre = document.getElementById("Adress");

    var data = {};
    data["username"] = username.value;
    data["password"] = pass.value;
    data["adr"] = cre.value;
   return data;
}

function register_submit() {
    var data = register_data();
    $.ajax({
        url: "register",
        type: "POST",
        //contex: ,
        data: data,
        dataType: "JSON",
        async: false,
        success: function(response) {
            if (response === true) {
                alert("注册成功！")
            } else {
                alert("账号已存在");
            }
            // setTimeout('window.location.href="index.html"', 3000);
        },
        error: function(xhr, msg, e) {
            alert("error!");
        }
    });
}

function logout() {
    $.ajax({
        url: "logout",
        type: "GET",
        dataType: "JSON",
        success: function(response) {
            if (response === true) {
                setTimeout('window.location.href="index.html"', 1000);
            } else {
                alert("登出失败!");
            }
            // setTimeout('window.location.href="index.html"', 3000);
        },
        error: function(xhr, msg, e) {
            alert("error!");
        }
    });
}

function online() {
    $.ajax({
        url: "online",
        type: "GET",
        success: function(response) {
                if(response!=null) {
                    $("#UserID").innerHTML(response.toString()
                                             + '<b class="caret"></b>');
                }
        },
        error: function(xhr, msg, e) {
            alert("error!");
        }
    });
}
function updatePass() {
    var pass1 = document.getElementById("pass1");
    var pass2 = document.getElementById("pass2");
    if (pass1.value !== pass2.value) {
        alert("两次密码输入不一致!")
        pass1.text("");
        pass2.text("");
    }
    else {
        var data = {};
        data["password"] = pass2.value;
        $.ajax({
            url: "updatepass",
            type: "POST",
            data: data,
            dataType: "JSON",
            success: function (response) {
                if (response === true) {
                    alert("密码修改成功!");
                    setTimeout('window.location.href="index.html"');
                }
            }
        });
    }
}
