/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package khai.dev.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import khai.dev.admin.BaseAdminServlet;
import khai.dev.data.dao.DatabaseDao;
import khai.dev.data.dao.UserDao;

/**
 *
 * @author Admin
 */
public class DeleteUserServlet extends BaseAdminServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        userDao.delete(userId);
        
        response.sendRedirect("IndexUserServlet");
    }
}