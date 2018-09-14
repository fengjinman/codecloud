<!DOCTYPE html>
<html lang="en">
<head>
    <#assign ctx = request.contextPath />
    <meta charset="utf-8">
    <title>First page</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<script src="../jquery-1.7.2.min.js"></script>
<link href="../js/bootstrap.min.js">
<script>
//    $('.carousel').carousel();

</script>

    <#--固定在最上方-->
    <#--<nav class="navbar navbar-default navbar-fixed-top">-->
        <#--&lt;#&ndash;<div class="container">&ndash;&gt;-->
            <#--&lt;#&ndash;<h3>顶部</h3>&ndash;&gt;-->
            <#--&lt;#&ndash;<a href="${ctx}/loginPage"><h1>登录</h1></a>&ndash;&gt;-->
        <#--&lt;#&ndash;</div><!-- /.container-fluid &ndash;&gt;&ndash;&gt;-->
        <#--<div id="navbar" class="collapse navbar-collapse">-->
            <#--<ul class="nav navbar-nav">-->
                <#--<li class="active"><a href="#">Home</a></li>-->
                <#--<li><a href="#about">About</a></li>-->
                <#--<li><a href="#contact">Contact</a></li>-->
            <#--</ul>-->
        <#--</div>-->
    <#--</nav>-->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">White star</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

    <#--固定在底部-->
    <nav class="navbar navbar-inverse navbar-fixed-bottom">

    </nav>


</body>
</html>