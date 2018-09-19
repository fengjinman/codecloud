<!DOCTYPE html>
<html lang="en">
<head>
    <#assign ctx = request.contextPath />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Sign in</title>



<#--<!-- IE10 viewport hack for Surface/desktop Windows 8 bug &ndash;&gt;-->
<#--<link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">-->

<#--<!-- Custom styles for this template &ndash;&gt;-->
<#--<link href="signin.css" rel="stylesheet">-->

    <!-- Bootstrap -->
</head>
<body>
<script src="../jquery-3.0.0.min.js"></script>
<script>
    /**
     * js大坑记录：
     * 1: onclick不可以绑定method方法（有可能是对于js有特殊含义的，还一个其他的名称即可）
     *
     * bootstrap中文网：http://www.bootcss.com/
     *
     * 尺码：xs  sm  md  lg
     */
    function sendajax() {

        console.log("${ctx}")
        var username = $("#username").val();
        var password = $("#password").val();
        if(check(username,password)){
            $.ajax({
                url:"${ctx}/login",
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
                        window.location.href="${ctx}/welcome";
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
</script>
<div align="center" style="margin-top: 300px">
<form id="formId" action="http://${ctx}:8888/login">
账号：<input  id="username" name="username" value="fengjinman" /><br><br>
密码：<input  id="password" name="password" value="dashuaige" /><br><br>
<button type="button" class="btn btn-lg btn-success" onclick="sendajax()">点击登录</button>
</form>

</div>



</body>
</html>