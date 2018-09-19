<!DOCTYPE html>
<html lang="en">
<head>
    <#assign ctx = request.contextPath />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>First page</title>
</head>
<body>
    <script src="../jquery-3.0.0.min.js"></script>

    <div style="margin-top: 100px;margin-left: 50px">
    <button type="button"  class="btn btn-lg btn-default"><a href="${ctx}/loginPage">登陆</a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button"  class="btn btn-lg btn-default"><a href="${ctx}/toRegist">注册</a></button>


</body>
</html>