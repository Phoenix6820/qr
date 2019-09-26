
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>添加</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>

</head>
<body>


<div style="width:500px;margin: 20px auto">


    <form class="form-horizontal" action="dep" method="post">

        <input type="hidden" name="type" value="add"/>
        <div class="form-group">
            <label  class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="name"  placeholder="请输入名称>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>
            </div>
        </div>
    </form>


</div>





</body>
</html>
