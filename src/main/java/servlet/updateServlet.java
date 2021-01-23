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
 * @Date: 2019/3/29 15:44
 */
@WebServlet(name = "updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        for (int i = 0; i < 10; i++) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String specialty = request.getParameter("specialty");
        String grade = request.getParameter("grade");
        Connection connection = DbConnect.getConnection();
        String sql = "UPDATE STUDENT SET name=? , sex=? , specialty=? , grade=? where id=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(5, Integer.parseInt(id));
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, sex);
            preparedStatement.setString(3, specialty);
            preparedStatement.setString(4, grade);
            int i = preparedStatement.executeUpdate();
            HttpSession httpSession = request.getSession();
            if (i == 1) {
                String selectAll = "SELECT * FROM STUDENT";
                preparedStatement = connection.prepareStatement(selectAll);
                resultSet = preparedStatement.executeQuery();
                httpSession.setMaxInactiveInterval(7200);
                httpSession.setAttribute("resultSet", resultSet);
                response.sendRedirect("loginAction.jsp");
            } else {
                httpSession.setAttribute("message", "修改失败！");
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
