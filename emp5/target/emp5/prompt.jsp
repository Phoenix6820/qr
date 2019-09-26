<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 9/17
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #txt {

        width: 400px;
        height: 50px;
        font-size: 40px;
    }

    #mes {
        width: 400px;
        display: none;
        border: 1px solid #ccc;

    }
</style>
<script src="js/jquery-3.1.0.js"></script>
<script>
    $().ready(function () {

        $("#txt").keyup(function () {
            if($(this).val().length>0){
            $.ajax({
                type: "get",
                url: "prompt",
                data: {"type": "p", "key": $(this).val()},
                dataType: "text",
                success: function (data) {
                    $("#mes").show();

                    $("#mes").html(data)
                }
            })
            }else{

                $("#mes").hide();

            }

        })


    })


</script>
<body>

<input type="text" id="txt"/>
<div id="mes"></div>
</body>
</html>
