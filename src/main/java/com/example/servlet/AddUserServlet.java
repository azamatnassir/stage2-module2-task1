package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");

        User user = new User(firstName, secondName);
        Warehouse.getInstance().addUser(user);

        req.setAttribute("user", user);
        resp.sendRedirect("/add");
    }
}
