<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="<%=path%>/resource/bs/js/jquery-1.11.1.js"></script>    <!-- 引入jquery -->
    <link rel="stylesheet" href="<%=path%>/resource/bs/css/bootstrap.css"> <!-- 引入bootstrap.css -->
    <script src="<%=path%>/resource/bs/js/bootstrap.min.js"></script><!-- 引入bootstrap.min.js -->
    <title>教工列表</title>
</head>

<body>
<br>
<br>
<br>
<section class="container">
    <div class="row">
        <div class="col-md-3">
            <button class="btn btn-danger" data-toggle="modal"
                    data-target="#addModal">新增
            </button>
        </div>
    </div>
    <table class="table table-striped table-bordered table-hover">
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>院系</th>
        <th>操作</th>
        <c:forEach items="${ employeeList }" var="list">
            <tr>
                <td>${list.empId }</td>
                <td>${list.empName }</td>
                <td>${list.empGender }</td>
                <td>${list.empEmail }</td>
                <td>${list.dept }</td>
                <td colspan="2">
                    <button class="btn btn-primary edBtn" data-toggle="modal" data-target="#edModal"
                            value="${list.empId}" empName="${ list.empName}" empGender="${list.empGender}"
                            empEmail="${ list.empEmail}" dept="${ list.dept}">编辑
                    </button>
                    <button class="btn btn-danger delBtn" data-toggle="modal" data-target=".delModal"
                            value="${list.empId }">删除
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>

<div class="modal fade delModal" tabindex="-1" role="dialog"
     aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                <h4>确定删除吗?</h4>
            </div>
            <div class="modal-footer">
                <form action="DelServlet">
                    <input id="delid" name="empId" value="" hidden>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-danger">删除</button>
                </form>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- 编辑模态框 -->
<div class="modal fade" id="edModal" tabindex="-1" role="dialog" aria-labelledby="edModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">用户信息</h4>
            </div>
            <form action="UpdateServlet" method="post">
                <div class="modal-body">
                    <input id="edId" name="empId" value="" hidden>

                    <div class="form-group">
                        <label for="empName" class="control-label">姓名:</label> <input
                            type="text" name="empName" class="form-control" id="empName"
                            value="${employee.empName }" required>
                    </div>

                    <div class="form-group">
                        <label for="empGender" class="control-label">性别:</label> <input
                            type="text" name="empGender" class="form-control" id="empGender"
                            value="${employee.empGender }" required>
                    </div>

                    <div class="form-group">
                        <label for="empEmail" class="control-label">邮箱:</label> <input
                            type="text" name="empEmail" class="form-control" id="empEmail"
                            value="${employee.empEmail }" required>
                    </div>

                    <div class="form-group">
                        <label for="dept" class="control-label">院系:</label> <input
                            type="text" name="dept" class="form-control" id="dept"
                            value="${employee.dept }" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">更新</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 添加模态框 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
     aria-labelledby="edModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">用户信息</h4>
            </div>
            <form action="addServlet" method="post">
                <div class="modal-body">
                    <input id="edId" name="empId" value="" hidden>
                    <div class="form-group">
                        <label for="empName" class="control-label">姓名:</label> <input
                            type="text" name="empName" class="form-control" value="" required>
                    </div>
                    <div class="form-group">
                        <label for="empGender" class="control-label">性别:</label> <input
                            type="text" name="empGender" class="form-control" value="" required>
                    </div>
                    <div class="form-group">
                        <label for="empEmail" class="control-label">邮箱:</label> <input
                            type="text" name="empEmail" class="form-control" value="" required>
                    </div>
                    <div class="form-group">
                        <label for="dept" class="control-label">院系:</label> <input
                            type="text" name="dept" class="form-control" value="" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">添加</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script type="text/javascript">
    // 删除按钮
    $(".delBtn").on("click", function () {
        $("#delid").val($(this).val());
    });
    // 编辑按钮
    $(".edBtn").on("click", function () {
        $("#edId").val($(this).val());
        $("#empName").val($(this).attr("empName"));
        $("#empGender").val($(this).attr("empGender"));
        $("#empEmail").val($(this).attr("empEmail"));
        $("#dept").val($(this).attr("dept"));
    });
</script>


</html>
