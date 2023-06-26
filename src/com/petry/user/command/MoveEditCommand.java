package com.petry.user.command;

import com.petry.commonInterface.command.BooleanCommand;
import com.petry.commonInterface.command.Command;
import com.petry.user.dao.UserDAO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MoveEditCommand implements BooleanCommand {
    @Override
    public boolean excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag = false;
        UserDAO dao = UserDAO.getUserDAO();
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();
        String cPwd = request.getParameter("check_pwd");
        String pwd = dao.checkPwd(uId);

        if (pwd.equals(cPwd)) {
            UserDTO dto = dao.selectUser(uId);
            request.setAttribute("id", dto.getId());
            request.setAttribute("pwd", dto.getPwd());
            request.setAttribute("email", dto.getEmail());
            request.setAttribute("name", dto.getName());
            request.setAttribute("birth", dto.getBirth());
            request.setAttribute("nickname", dto.getNickname());
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }
}
