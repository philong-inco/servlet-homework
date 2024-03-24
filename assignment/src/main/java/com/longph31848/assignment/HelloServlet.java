package com.longph31848.assignment;

import java.io.*;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.repository.KichThuocService;
import com.longph31848.assignment.repository.NhanVienService;
import com.longph31848.assignment.repository.impl.KichThuocServiceImpl;
import com.longph31848.assignment.repository.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({
        "/",
        "/login",
        "/success"
})
public class HelloServlet extends HttpServlet {


    private String message;
    private NhanVienService nhanVienService;

    public void init() {
        message = "Hello World!";
        try {
            nhanVienService = new NhanVienServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String uri = req.getRequestURI();
            if (uri.contains("login")) {
                this.login(req, resp);
            } else {
                this.index(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String uri = req.getRequestURI();
            if (uri.contains("success")){
                this.success(req,resp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String check = req.getParameter("check");
        if (check != null){
            req.setAttribute("check", check);
        }
        req.getRequestDispatcher("/views/nhanvien/login.jsp").forward(req,resp);
    }

    public void success(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        NhanVien nv = nhanVienService.findByUserNameAndMatKhau(username, password);
        if (nv != null){
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(1800);
            session.setAttribute("account", nv);
            resp.sendRedirect("/assignment_war_exploded/san-pham/list");
        } else {
            resp.sendRedirect("/assignment_war_exploded/login?check=0");
        }
    }

    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}