package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/kich-thuoc")
public class KichThuocController extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            connection = DataBaseConnection.getConnection();
            System.out.println(connection);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
