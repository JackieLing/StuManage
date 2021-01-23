<%--
  Created by IntelliJ IDEA.
  User: 24234
  Date: 2019/3/27
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>学生管理系统</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<center>
    <form action="/loginServer" method="post">
        <table>
            <tr>
                <td>
                    用户名
                </td>
                <td>
                    <input type="text" name="admin">
                </td>
            </tr>
            <tr>
                <td>
                    密&nbsp&nbsp码
                </td>
                <td>
                    <input type="password" name="pwd">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登录">
                </td>
            </tr>

        </table>
    </form>
</center>
</body>
</html>
