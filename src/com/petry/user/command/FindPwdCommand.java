package com.petry.user.command;

import com.petry.command.FindCommand;
import com.petry.user.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindPwdCommand implements FindCommand {

    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserDAO dao = UserDAO.getUserDAO();
        String id = request.getParameter("pId");
        String email = request.getParameter("pEmail");

        return dao.findPwd(id, email);
    }
}
