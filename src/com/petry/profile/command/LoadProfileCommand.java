package com.petry.profile.command;

import com.petry.commonInterface.command.Command;
import com.petry.profile.dao.ProfileDAO;
import com.petry.profile.dto.ProfileDTO;
import com.petry.profile.dto.ProfileImgDTO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoadProfileCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfileDAO dao = ProfileDAO.getProfileDAO();

        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userInfo");
        int uId = userDTO.getuId();

        ArrayList<ProfileImgDTO> profileImg = new ArrayList<>();
        ArrayList<ProfileDTO> profile = dao.selectProfile(uId);

        for (ProfileDTO profiles : profile) {
            int piId = profiles.getPiId();
            profileImg.add(dao.selectProfileImg(piId));
        }

        request.setAttribute("profile", profile);
        request.setAttribute("profileImg", profileImg);
    }
}
