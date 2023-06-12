package com.petry.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmailCheckService", value = "/EmailCheckService")
public class EmailCheckService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("EUC-KR");

        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        int check = UserDAO.getUserDAO().checkEmail(email);

        out.write(check + "");
    }
}
