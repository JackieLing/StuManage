<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>添加学生信息</title>
    <link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
<form action="/addServlet" method="post">
    <center>
        <table class="gridtable">
            <tr>
                <td align="center" colspan="2">添加学生信息</td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="sex" value="男" checked="checked">男
                    <input type="radio" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td>专业</td>
                <td><input type="text" name="specialty"></td>
            </tr>
            <tr>
                <td>年级</td>
                <td><select name="grade">
                    <option value="大一">大一</option>
                    <option value="大二">大二</option>
                    <option value="大三">大三</option>
                    <option value="大四">大四</option>
                </select></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="添加"></td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
