/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package khai.dev.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import khai.dev.admin.BaseAdminServlet;
import khai.dev.data.dao.DatabaseDao;
import khai.dev.data.dao.UserDao;
import khai.dev.data.model.User;

/**
 *
 * @author Admin
 */
public class EditUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);

        request.setAttribute("user", user);
        request.getRequestDispatcher("admin/user/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        userDao.update(user);
        response.sendRedirect("IndexUserServlet");

    }
}
