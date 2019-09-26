<%@ page import="com.qr.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.qr.entity.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <style>
        #deps .selected {
            background-color: #337ab7;


        }


    </style>
    <script src="jquery-3.1.0.js"></script>
    <script>
        $(document).ready(function () {


            $("#add").click(function () {
                location.href = "dep?type=showAdd"

            })

            $("[name='modify']").click(function () {
                var id = $(this).data("id");
                location.href = "dep?type=showUpdate&id=" + id
            })
            var id = 0;
            $("#deps tr").click(function () {

                $("#deps tr").removeClass("selected");
                // if($(this).hasClass("selected")){
                //   $(this).removeClass("selected");
                //   }else{
                $(this).addClass("selected");
                // }
                id = $(this).data("id");

            })
            $("#update").click(function () {
                if (id != 0) {
                    location.href = "dep?type=showUpdate&id=" + id
                } else {
                    alert("请选择一条数据")
                }
            })
            $("#delete").click(function () {
                if (id != 0) {
                    location.href = "dep?type=delete&id=" + id
                } else {
                    alert("请选择一条数据")
                }
            })
        })


    </script>

</head>
<body>
<%List<Department> list = (List<Department>) request.getAttribute("list");%>
<div style="width:500px;margin: 20px auto">
    <table class="table table-bordered" id="deps">
        <tr>
            <th>id</th>
            <th>名称</th>

        </tr>
        <%for (int i = 0; i < list.size(); i++) {%>

        <tr data-id="<%=list.get(i).getId()%>">
            <td><%=list.get(i).getId()%>
            </td> <td><%=list.get(i).getName()%>
        </td>

        </tr>
        <%}%>
    </table>
    <button type="button" class="btn btn-primary" id="add">新增</button>
    <button type="button" class="btn btn-primary" id="update">修改</button>
    <button type="button" class="btn btn-primary" id="delete">删除</button>

</div>
</body>
</html>
