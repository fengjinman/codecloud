<!DOCTYPE html>
<html lang="en">
<head>
    <#assign ctx = request.contextPath />
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#--freemarker当中不能有空值得存在，否则报错-->
    登陆成功！
    welcome! ${username}
    <br>
    <a href="${ctx}/message">群发短信</a><br>
    <a href="${ctx}/makeSkuPage">商品发布</a><br>
    <a href="${ctx}/spulook">商品展示</a><br>

</body>
</html>