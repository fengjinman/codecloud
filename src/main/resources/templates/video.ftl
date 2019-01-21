<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>解析视频</title>
</head>
<body>

    <form id="upload-form"   method="post" enctype="multipart/form-data" >
          <div class="modal-body">
              <input type="file" name="myFile"/>
          </div>
          <div class="modal-footer">
               <button type="button" class="btn btn-default" data-dismiss="modal"> 取消</button>
               <button type="button" onclick="upload()" class="btn btn-primary" >上传</button>
          </div>
    </form>


<script src="../jquery-3.0.0.min.js"></script>
<script>
    function upload(){
        var formData = new FormData(document.getElementById("upload-form"));
        $.ajax({
            url: "/updownload/upload",
            method: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            success: function (resp) {
                if(resp){
                    alert("上传成功");
                }else{
                    alert("上传失败");
                }
            }
        });
    }

</script>
</body>
</html>