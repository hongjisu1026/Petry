package com.petry.profile.command;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.petry.command.Command;
import com.petry.profile.dao.ProfileDAO;
import com.petry.profile.dto.ProfileDTO;
import com.petry.profile.dto.ProfileImgDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ProfileCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfileDAO dao = ProfileDAO.getProfileDAO();
        ProfileDTO dto = new ProfileDTO();
        ProfileImgDTO imgDTO = new ProfileImgDTO();

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

        String pName = mr.getParameter("pName");
        String pBirth = mr.getParameter("pBirth");
        String pSex = mr.getParameter("pSex");

        imgDTO.setPiName(piName);
        imgDTO.setPiPath(piPath);
        imgDTO.setPiType(piType);
        imgDTO.setPiSize(piSize);

        dao.uploadProfileImg(imgDTO);

        int result = dao.inputProfile(pName, pBirth, pSex);

    }
}
