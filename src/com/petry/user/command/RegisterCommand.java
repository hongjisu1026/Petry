package com.petry.user.command;

import com.petry.commonInterface.command.Command;
import com.petry.user.dao.UserDAO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        UserDAO dao = UserDAO.getUserDAO();
        UserDTO dto = new UserDTO();

        dto.setId(request.getParameter("id"));
        dto.setPwd(request.getParameter("pwd"));
        dto.setEmail(request.getParameter("email"));
        dto.setName(request.getParameter("name"));
        dto.setBirth(request.getParameter("birth"));
        dto.setNickname(request.getParameter("nickname"));

        int result = dao.registerOK(dto);
    }
}
