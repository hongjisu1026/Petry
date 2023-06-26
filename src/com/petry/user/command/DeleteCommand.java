package com.petry.user.command;

import com.petry.commonInterface.command.Command;
import com.petry.user.dao.UserDAO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO dao = UserDAO.getUserDAO();
        UserDTO dto = (UserDTO) session.getAttribute("userInfo");

        int uId = dto.getuId();
        dao.deleteUser(uId);
    }
}
