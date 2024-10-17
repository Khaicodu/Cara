/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package khai.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import khai.dev.data.dao.DatabaseDao;
import khai.dev.data.dao.ProductDao;
import khai.dev.data.model.Product;
import khai.dev.util.Constants;

/**
 *
 * @author Admin
 */
public class SearchServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        String keyword = request.getParameter("keyword");
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.findByName(keyword);
        List<Product> newsProductList = productDao.news(Constants.NUMBER_LIMIT);
        
        request.setAttribute("keyword", keyword);
        request.setAttribute("productList", productList);
        request.setAttribute("newsProductList", newsProductList);
        request.getRequestDispatcher("search.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}