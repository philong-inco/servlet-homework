package com.longph31848.assignment;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.repository.KichThuocService;
import com.longph31848.assignment.repository.impl.KichThuocServiceImpl;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private KichThuocService kichThuocService;

    public void init() {
        message = "Hello World!";
        try {
             kichThuocService = new KichThuocServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

//        testInsert();

//        testUpdate();

//        try {
//            testDelete();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        try {
//            testGetByName();
            testGetByMa();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void testGetByMa() throws SQLException {
        KichThuoc result = kichThuocService.findByMa("redcode (update)");
        System.out.println(result.toString());
    }

    private void testGetByName() throws SQLException {
        List<KichThuoc> result = kichThuocService.findByName("Red Color (update)");
        System.out.println("Size: "+result.size());
        for (KichThuoc kt: result) {
            System.out.println(kt.toString());
        }
    }

    private void testGetAll() throws SQLException {
        List<KichThuoc> result = kichThuocService.getAll();
        for (KichThuoc kt:
             result) {
            System.out.println(kt.toString());
        }
    }

    private void testDelete() throws SQLException {
        KichThuoc result = kichThuocService.delete(1L);
        System.out.println(result.toString());
    }

    private void testUpdate() {
        try {
            KichThuocService kichThuocService = new KichThuocServiceImpl();
            KichThuoc kichThuoc = KichThuoc.getBuilder()
                    .withTen("Red Color (update)")
                    .withMa("redcode (update)")
                    .withTrangThai(0)
                    .withId(3L)
                    .build();
            KichThuoc result = kichThuocService.update(kichThuoc);
            System.out.println(result.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void testInsert(){
        try {
            KichThuocService kichThuocService = new KichThuocServiceImpl();
            KichThuoc kichThuoc = KichThuoc.getBuilder()
                    .withTen("Red Color")
                    .withMa("redcode")
                    .withTrangThai(1)
                    .build();
            KichThuoc result = kichThuocService.insert(kichThuoc);
            System.out.println(result.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}