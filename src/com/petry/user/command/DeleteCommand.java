package com.petry.user.command;

import com.petry.command.Command;
import com.petry.profile.command.DeleteProfileCommand;
import com.petry.profile.dao.ProfileDAO;
import com.petry.profile.dto.ProfileDTO;
import com.petry.profile.dto.ProfileImgDTO;
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
        ProfileDAO pDao = ProfileDAO.getProfileDAO();
        UserDTO dto = (UserDTO) session.getAttribute("userInfo");
        ProfileDTO pDto = new ProfileDTO();

        int uId = dto.getuId();
        /*int pId = pDao.selectPId(uId);
        pDto.setpId(pId);
        int piId = pDao.selectPiId(pDto);*/

        /*pDao.deleteProfileForUser(uId);
        pDao.deleteProfileImg(piId);*/
        dao.deleteUser(uId);
    }
}
