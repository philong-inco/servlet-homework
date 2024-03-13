package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.entity.MauSac;
import com.longph31848.assignment.repository.KichThuocService;
import com.longph31848.assignment.repository.MauSacService;
import com.longph31848.assignment.repository.impl.KichThuocServiceImpl;
import com.longph31848.assignment.repository.impl.MauSacServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/mau-sac")
public class MauSacController extends HttpServlet {

    private Connection connection;
    private MauSacService service;
    private List<MauSac> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new MauSacServiceImpl();
            list = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mausaclist", list);
        req.getRequestDispatcher("/views/mausac/mausac.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
