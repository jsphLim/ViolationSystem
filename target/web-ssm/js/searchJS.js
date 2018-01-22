
function search(){
    var name = document.getElementById("name");
    var ID = document.getElementById("ID");
    data={};
    data["name"]=name.value;
    data["ID"]=ID.value;
    $.ajax({
        url: "search",
        type: "POST",
        //contex: ,
        data: data,
        dataType: "JSON",
        async:false,
        success: function(response) {
            console.log(response);
            // setTimeout()

            $("#postTable").html("<tr style=\"font-weight: bold\"><td>姓名</td><td>身份证</td><td>违规内容</td><td>扣分数</td><td>登记人员</td></tr>");
            $.each(response, function(i, item) {

                    $("#postTable").append(
                        '<tr><td>'+name.value+'</td><td>'+item.ID+'</td><td>'+item.vio+'</td><td>'+item.lowpoint+'</td><td>'+item.admin+'</td></tr>');
            });
            $("#searchPanel").hide();
            $("#mainPanel").show();

        },
        error: function(xhr, msg, e) {
            alert("error!");
        }

    });
}


function addMsg_submit() {
    var username = document.getElementById("username");
    var ID = document.getElementById("ID");
    var vio = document.getElementById("violate");
    var lowpoint = document.getElementById("lowpoint");
    var data={};
    data["username"]=username.value;
    data["ID"]=ID.value;
    data["vio"]=vio.value;
    data["lowpoint"]=lowpoint.value;
    if(confirm("一经写入不可篡改！请慎重！")) {
        $.ajax({
            url: "add",
            type: "POST",
            data: data,
            async: false,
            dataType: "JSON",
            success: function (response) {
                alert("写入成功")

            },
            error: function (xhr, msg, e) {
                alert("error!");
            }

        });
    }
}

function tomain() {
    setTimeout('window.location.href="main.html"');
}