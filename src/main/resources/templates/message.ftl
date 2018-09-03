<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>短信群发</title>
</head>
<body>
    <script src="../jquery-1.7.2.min.js"></script>
    <script>

        function sendajax(){
            if(check()){
                $("#form").submit();
            }
        }
        function check(){
            var manlist = $("#manlist").val();
            if(manlist==null||manlist==""){
                alert("收件人不能为空！");
            }else{
                if(manlist.indexOf(",")!=-1){
                    var array = manlist.split(",");
                    for(var i=0;i<array.length;i++){
                        var phonenumber = array[i];
                        if(isNaN(phonenumber)){
                            alert("收件人手机号码不是数字，请改正！");
                            return;
                        }else{
                            if(phonenumber.length!=11){
                                alert("收件人中有长度不为11的号码，请改正！");
                            }
                        }
                    }
                }else{
                    if(isNaN(manlist)){
                        alert("收件人手机号码不是数字，请改正！");
                    }else{
                        if(manlist.length!=11){
                            alert("收件人的号码长度不为11，请改正！");
                        }
                    }
                }
            }
            var message = $("#message").val();
            if(message==null||message==""){
                alert("信息内容不能为空！");
            }
            return true;
        }
    </script>
     <form id="form" action="http://localhost:8080/sendMessage">
         输入收件人手机号，多个收件人手机号之间使用逗号分隔:
         <br>
         <textarea id="manlist" name="manlist" value="15201144824,18904306090"></textarea>
         <br><br>
         输入短信内容:
         <br>
         <textarea id="message" name="message" value="1212"></textarea>
         <br><br>
         <input id="btn_sub" type="button" value="点击发送" onclick="sendajax()">
     </form>
</body>
</html>