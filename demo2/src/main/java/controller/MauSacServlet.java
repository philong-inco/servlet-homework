package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "mauSacServlet", value = "/mau-sac/create")
public class MauSacServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/mau-sac/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Vào doPostMauSac");
        System.out.println("Mã: " + req.getParameter("colorCode"));
        System.out.println("Tên: " + req.getParameter("colorName"));
        boolean trangThai = Objects.equals(req.getParameter("colorStatus"), "enable");
        System.out.println("Trạng thái: " + ((trangThai)?"Hoạt động":"Không hoạt động"));
    }
}
