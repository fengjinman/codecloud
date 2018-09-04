<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#--freemarker当中不能有空值得存在，否则报错-->
    登陆成功！
    welcome! ${username}
    <br>
    <a href="http://localhost:8080/message">群发短信</a>
</body>
</html>