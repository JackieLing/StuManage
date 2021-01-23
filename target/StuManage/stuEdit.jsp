<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 24234
  Date: 2019/3/29
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改学生信息</title>
    <link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
<%Student student = (Student) session.getAttribute("student");%>
<form action="/updateServlet" method="post">
    <center>
        <table class="gridtable">
            <tr>
                <td align="center" colspan="2">
                    修改学生信息
                    <input type="hidden" name="id" value="<%=student.getId()%>">
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="<%=student.getName()%>"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><%if (student.getSex().equals("男")) {%>
                    <input type="radio" name="sex" value="男" checked="checked">男
                    <input type="radio" name="sex" value="女">女
                </td>
                <%
                } else {
                %>
                <td>
                    <input type="radio" name="sex" value="男">男
                    <input type="radio" name="sex" value="女" checked="checked">女
                </td>
                <%}%>
            </tr>
            <tr>
                <td>专业</td>
                <td><input type="text" name="specialty" value="<%=student.getSpecialty()%>"></td>
            </tr>
            <tr>
                <td>年级</td>
                <td>
                    <%
                        if (student.getGrade().equals("大一")) {
                    %>
                    <select name="grade">
                        <option value="大一" selected="selected">大一</option>
                        <option value="大二">大二</option>
                        <option value="大三">大三</option>
                        <option value="大四">大四</option>
                    </select>
                    <%} else if (student.getGrade().equals("大二")) {%>
                    <select name="grade">
                        <option value="大一">大一</option>
                        <option value="大二" selected="selected">大二</option>
                        <option value="大三">大三</option>
                        <option value="大四">大四</option>
                    </select>
                    <%} else if (student.getGrade().equals("大三")) {%>
                    <select name="grade">
                        <option value="大一">大一</option>
                        <option value="大二">大二</option>
                        <option value="大三" selected="selected">大三</option>
                        <option value="大四">大四</option>
                    </select>
                    <%} else if (student.getGrade().equals("大四")) {%>
                    <select name="grade">
                        <option value="大一">大一</option>
                        <option value="大二">大二</option>
                        <option value="大三">大三</option>
                        <option value="大四" selected="selected">大四</option>
                    </select>
                    <%}%>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="修改">
                </td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
