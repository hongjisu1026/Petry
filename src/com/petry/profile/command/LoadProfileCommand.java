package com.petry.profile.command;

import com.petry.command.Command;
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

        ArrayList<ProfileImgDTO> profileImg = dao.loadProfileImg();
        ArrayList<ProfileDTO> profile = new ArrayList<>();
        for (ProfileImgDTO images : profileImg) {
            int piId = images.getPiId();
            profile.add(dao.loadProfile(uId, piId));
            System.out.println(dao.loadProfile(uId, piId).getpId());
        }

        request.setAttribute("profile", profile);
        request.setAttribute("profileImg", profileImg);
    }
}