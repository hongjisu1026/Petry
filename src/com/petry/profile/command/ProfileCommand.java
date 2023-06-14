package com.petry.profile.command;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
import java.util.Enumeration;

public class ProfileCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfileDAO dao = ProfileDAO.getProfileDAO();
        ProfileDTO dto = new ProfileDTO();
        ProfileImgDTO imgDTO = new ProfileImgDTO();

        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userInfo");
        int uId = userDTO.getuId();
        int piId = 0;

        String element = "";
        String piName = "";
        String piType = "";
        String piPath = "E:\\JavaStudy\\Project\\petry\\web\\assets\\images\\profile";
        long piSize = 0;

        MultipartRequest mr = new MultipartRequest(request, piPath, 1024*1024*1024, "utf-8", new DefaultFileRenamePolicy());
        System.out.println("경로 : " + piPath);

        Enumeration<?> files = mr.getFileNames();

        if (files.hasMoreElements()) {
            element = (String) files.nextElement();

            piName = mr.getFilesystemName(element);
            piType = mr.getContentType(element);
            piSize = mr.getFile(element).length();
        }

        System.out.println(piName + " " + piType + " " + piSize);

        imgDTO.setPiName(piName);
        imgDTO.setPiPath(piPath);
        imgDTO.setPiType(piType);
        imgDTO.setPiSize(piSize);

        int imgResult = dao.uploadProfileImg(imgDTO);
        piId = dao.selectPiId(imgDTO).getPiId();

        String pName = mr.getParameter("pName");
        String pBirth = mr.getParameter("pBirth");
        String pSex = mr.getParameter("pSex");

        dto.setpName(pName);
        dto.setpBirth(pBirth);
        dto.setpSex(pSex);
        dto.setuId(uId);
        dto.setPiId(piId);

        dao.inputProfile(dto);
    }
}
