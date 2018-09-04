<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script src="../jquery-1.7.2.min.js"></script>
<script>
    /**
     * js大坑记录：
     * 1: onclick不可以绑定method方法（有可能是对于js有特殊含义的，还一个其他的名称即可）
     */
    function sendajax() {
        var username = $("#username").val();
        var password = $("#password").val();
        if(check(username,password)){
            $.ajax({
                url:"http://localhost:8080/login",
                data:{
                  username:username,
                  password:password
                },
                dataType:"json",
                type:"post",
                success:function (data){
                    console.log(data);
                    if(data.result==true){
                        alert("登录成功！");
                        window.location.href="http://localhost:8080/welcome";
                    }else{
                        alert(data.reason);
                        return;
                    }
                }
            });
        }
    }

    function check(username,password){
        console.log(username);
        console.log(password);
        if(username==""||password==""){
            alert("账号密码不能为空！");
            return;
        }else{
            return true;
        }
    }
    //        window.onload=function () {
    //            alert("你好，我是js");
    //        }
    //改成ajax
</script>
    <div align="center" style="margin-top: 300px">
        <form id="formId" action="http://localhost:8080/login">
            账号：<input  id="username" name="username" value="fengjinman"/><br><br>
            密码：<input  id="password" name="password" value="dashuaige"/><br><br>
            <input type="button" value="点击登录" onclick="sendajax()"/>
        </form>
    </div>

</body>
</html>