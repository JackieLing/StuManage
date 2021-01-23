<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<% ResultSet resultSet = (ResultSet) session.getAttribute("resultSet");%>
<html>
<head>
    <title>学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
<center>
    <table class="gridtable">
        <tr>
            <td align="center" colspan="6">学生信息</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>专业</td>
            <td>年级</td>
            <td align="center" colspan="2">操作</td>
        </tr>
        <%
            while (resultSet.next()) {
        %>

        <tr>
            <td><%=resultSet.getString("name")%>
            </td>
            <td><%=resultSet.getString("sex")%>
            </td>
            <td><%=resultSet.getString("specialty")%>
            </td>
            <td><%=resultSet.getString("grade")%>
            </td>
            <td><a href="selectServlet?id=<%=resultSet.getInt("id")%>">修改</a></td>
            <td><a href="deleteServlet?id=<%=resultSet.getInt("id")%>" onclick="return confirm('确定删除？')">删除</a></td>
        </tr>
        <%}%>
        <tr>
            <td align="center" colspan="6">
                <a href="stuAdd.jsp">添加</a>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
