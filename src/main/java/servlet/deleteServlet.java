package servlet;

import db.DbConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: ${NAME}
 * @Author: Leo
 * @Description:
 * @Date: 2019/3/29 16:05
 */
@WebServlet(name = "deleteServlet")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String sql = "DELETE FROM STUDENT WHERE ID=?";
        Connection connection = DbConnect.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HttpSession httpSession = request.getSession();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                String select = "SELECT * FROM STUDENT";
                preparedStatement = connection.prepareStatement(select);
                resultSet = preparedStatement.executeQuery();
                httpSession.setMaxInactiveInterval(7200);
                httpSession.setAttribute("resultSet", resultSet);
                response.sendRedirect("loginAction.jsp");
            } else {
                httpSession.setAttribute("message", "删除失败！");
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
