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
import java.io.File;
import java.io.IOException;

public class DeleteProfileCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfileDAO dao = ProfileDAO.getProfileDAO();
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userInfo");
        int uId = userDTO.getuId();
        int pId = Integer.parseInt(request.getParameter("pId"));

        ProfileDTO dto = new ProfileDTO();
        dto.setuId(uId);
        dto.setpId(pId);

        String piName = dao.selectPiName(dto);
        String piPath = "E:\\JavaStudy\\Project\\petry\\web\\assets\\images\\profile";
        File file = new File(piPath + "\\" + piName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
        } else {
            System.out.println("파일이 존재하지 않음");
        }

        dao.deleteProfile(dto);

    }
}
