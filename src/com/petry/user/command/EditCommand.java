package com.petry.user.command;

import com.petry.commonInterface.command.Command;
import com.petry.user.dao.UserDAO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = UserDAO.getUserDAO();
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();
        UserDTO dto = new UserDTO();
        dto.setPwd(request.getParameter("pwd"));
        dto.setEmail(request.getParameter("email"));
        dto.setName(request.getParameter("name"));
        dto.setNickname(request.getParameter("nickname"));
        dto.setuId(uId);

        dao.updateUser(dto);
    }
}
