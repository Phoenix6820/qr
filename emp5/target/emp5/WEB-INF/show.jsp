<%@ page import="com.qr.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <style>
        #emps .selected {
            background-color: #337ab7;


        }


    </style>
    <script src="../js/jquery-3.1.0.js"></script>
    <script>
        $(document).ready(function () {


            $("#add").click(function () {
                location.href = "showAdd"

            })

            $("[name='modify']").click(function () {
                var id = $(this).data("id");
                location.href = "showUpdate&id=" + id
            })
            var id = 0;
            $("#emps tr").click(function () {

                $("#emps tr").removeClass("selected");
                // if($(this).hasClass("selected")){
                //   $(this).removeClass("selected");
                //   }else{
                $(this).addClass("selected");
                // }
                id = $(this).data("id");

            })
            $("#update").click(function () {
                if(id!=0){
                location.href = "showUpdate&id="+id
                }else{
                    alert("请选择一条数据")
                }
            })
            $("#delete").click(function () {
                if(id!=0){
                    location.href = "delete&id="+id
                }else{
                    alert("请选择一条数据")
                }
            })
        })


    </script>

</head>
<body>
<%List<Employee> list = (List<Employee>) request.getAttribute("list");%>
<div style="width:500px;margin: 20px auto">
    <table class="table table-bordered" id="emps">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        <%for (int i = 0; i < list.size(); i++) {%>

        <tr data-id="<%=list.get(i).getId()%>">
            <td><%=list.get(i).getId()%>
            </td>
            <td><%=list.get(i).getName()%>
            </td>
            <td><%=list.get(i).getSex()%>
            </td>
            <td><%=list.get(i).getAge()%>
            </td>
            <td>
                <button type="button" class="btn btn-primary" data-id="<%=list.get(i).getId()%>" name="modify">修改
                </button>
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
