<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.qr.entity.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>修改</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>

</head>
<body>
<%Department dep= (Department) request.getAttribute("dep");%>

<div style="width:500px;margin: 20px auto">


    <form class="form-horizontal" action="dep" method="post">

        <input type="hidden" name="type" value="update"/>
        <input type="hidden" name="id" value="<%=dep.getId()%>"/>

        <div class="form-group">
            <label  class="col-sm-2 control-label">名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="name"  placeholder="请输入名字" value="<%=dep.getName()%>">
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
