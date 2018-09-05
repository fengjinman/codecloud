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
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <h3>顶部</h3>
            <a href="${ctx}/loginPage"><h1>登录</h1></a>
            <!-- Brand and toggle get grouped for better mobile display -->
            <#--<div class="navbar-header">-->
                <#--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">-->
                    <#--<span class="sr-only">Toggle navigation</span>-->
                    <#--<span class="icon-bar"></span>-->
                    <#--<span class="icon-bar"></span>-->
                    <#--<span class="icon-bar"></span>-->
                <#--</button>-->
                <#--<a class="navbar-brand" href="#">Brand</a>-->
            <#--</div>-->

            <#--<!-- Collect the nav links, forms, and other content for toggling &ndash;&gt;-->
            <#--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">-->
                <#--<ul class="nav navbar-nav">-->
                    <#--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>-->
                    <#--<li><a href="#">Link</a></li>-->
                    <#--<li class="dropdown">-->
                        <#--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>-->
                        <#--<ul class="dropdown-menu">-->
                            <#--<li><a href="#">Action</a></li>-->
                            <#--<li><a href="#">Another action</a></li>-->
                            <#--<li><a href="#">Something else here</a></li>-->
                            <#--<li role="separator" class="divider"></li>-->
                            <#--<li><a href="#">Separated link</a></li>-->
                            <#--<li role="separator" class="divider"></li>-->
                            <#--<li><a href="#">One more separated link</a></li>-->
                        <#--</ul>-->
                    <#--</li>-->
                <#--</ul>-->
                <#--<form class="navbar-form navbar-left">-->
                    <#--<div class="form-group">-->
                        <#--<input type="text" class="form-control" placeholder="Search">-->
                    <#--</div>-->
                    <#--<button type="submit" class="btn btn-default">Submit</button>-->
                <#--</form>-->
                <#--<ul class="nav navbar-nav navbar-right">-->
                    <#--<li><a href="#">Link</a></li>-->
                    <#--<li class="dropdown">-->
                        <#--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>-->
                        <#--<ul class="dropdown-menu">-->
                            <#--<li><a href="#">Action</a></li>-->
                            <#--<li><a href="#">Another action</a></li>-->
                            <#--<li><a href="#">Something else here</a></li>-->
                            <#--<li role="separator" class="divider"></li>-->
                            <#--<li><a href="#">Separated link</a></li>-->
                        <#--</ul>-->
                    <#--</li>-->
                <#--</ul>-->
            <#--</div><!-- /.navbar-collapse &ndash;&gt;-->
        </div><!-- /.container-fluid -->
    </nav>











    <#--滚屏-->
    <#--<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">-->
        <#--<!-- Indicators &ndash;&gt;-->
        <#--<ol class="carousel-indicators">-->
            <#--<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>-->
            <#--<li data-target="#carousel-example-generic" data-slide-to="1"></li>-->
            <#--<li data-target="#carousel-example-generic" data-slide-to="2"></li>-->
        <#--</ol>-->

        <#--<!-- Wrapper for slides &ndash;&gt;-->
        <#--<div class="carousel-inner" role="listbox">-->
            <#--<div class="item active">-->
                <#--<img src="../img/3.jpg" alt="...">-->
                <#--<div class="carousel-caption">-->
                    <#--<h1>1</h1>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="item">-->
                <#--<img src="../img/2.jpg" alt="...">-->
                <#--<div class="carousel-caption">-->
                    <#--<h1>2</h1>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="item">-->
                <#--<img src="../img/1.jpg" alt="...">-->
                <#--<div class="carousel-caption">-->
                    <#--<h1>3</h1>-->
                <#--</div>-->
            <#--</div>-->

        <#--</div>-->

        <#--<!-- Controls &ndash;&gt;-->
        <#--<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">-->
            <#--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>-->
            <#--<span class="sr-only">Previous</span>-->
        <#--</a>-->
        <#--<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">-->
            <#--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>-->
            <#--<span class="sr-only">Next</span>-->
        <#--</a>-->
    <#--</div>-->







    <#--固定在底部-->
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
            <h3>底部</h3>
        </div>
    </nav>


</body>
</html>