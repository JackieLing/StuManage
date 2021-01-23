package servlet;

import db.DbConnect;
import entity.Student;

import javax.servlet.ServletException;
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
 * @Date: 2019/3/28 20:24
 */
public class addServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String specialty = request.getParameter("specialty");
        String grade = request.getParameter("grade");
        Student student = new Student(name, sex, specialty, grade);
        Connection connection = DbConnect.getConnection();
        String sql = "INSERT INTO student(name,sex,specialty,grade) values(?,?,?,?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setString(3, student.getSpecialty());
            preparedStatement.setString(4, student.getGrade());
            int i = preparedStatement.executeUpdate();
            HttpSession httpSession = request.getSession();
            if (i == 1) {
                String selectSql = "SELECT * FROM STUDENT";
                preparedStatement = connection.prepareStatement(selectSql);
                resultSet = preparedStatement.executeQuery();
                httpSession.setMaxInactiveInterval(7200);
                httpSession.setAttribute("resultSet", resultSet);
                response.sendRedirect("loginAction.jsp");
            } else {
                httpSession.setAttribute("message", "添加失败！");
                response.sendRedirect("error.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
