package com.petry.command;

import com.petry.user.UserDAO;
import com.petry.user.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginOKCommand implements LoginCommand {
    @Override
    public boolean excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO dao = UserDAO.getUserDAO();
        UserDTO dto = new UserDTO();
        dto.setId(request.getParameter("userId"));

        String pwd = request.getParameter("userPwd");
        String cPwd = dao.checkPwd(dto);

        if (pwd.equals(cPwd)) {
            dto.setPwd(pwd);
            session.setAttribute("userInfo", dao.loginOK(dto));
            return true;
        } else {
            return false;
        }
    }
}


