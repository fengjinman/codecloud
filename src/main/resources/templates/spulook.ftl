<!DOCTYPE html>
<html lang="en">
<head>
<#assign ctx = request.contextPath />
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
<script src="../jquery-1.7.2.min.js"></script>
<script>
    window.onload = function () {
        $.ajax({
            url:"${ctx}/spu/look",
            dataType:"json",
            type:"get",
            success:function(data){
                console.log(data);
            }
        });
    }
</script>


</body>
</html>