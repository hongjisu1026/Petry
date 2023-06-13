package com.petry.user.service;

import com.petry.user.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IdCheckService", value = "/IdCheckService")
public class IdCheckService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("EUC-KR");

        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        int check = UserDAO.getUserDAO().checkId(id);

        out.write(check + "");
    }
}
