package com.petry.profile.command;

import com.oreilly.servlet.MultipartRequest;
import com.petry.commonInterface.command.Command;
import com.petry.profile.Service.MyFileRenamePolicy;
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

        String element = "";
        String piName = "";
        String piOriName = "";
        String piType = "";
        String realPath = "F:\\JavaStudy\\Project\\petry\\web\\assets\\images\\profile";
        String piPath = "";
        long piSize = 0;
        File file = null;

        MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*1024, "utf-8", new MyFileRenamePolicy());
        System.out.println("경로 : " + realPath);

        Enumeration<?> files = mr.getFileNames();
        if (files.hasMoreElements()) {
            element = (String) files.nextElement();
            piName = mr.getFilesystemName(element);
            piOriName = mr.getOriginalFileName(element);
            piType = mr.getContentType(element).split("/")[1];
            piSize = mr.getFile(element).length();
            piPath = realPath + File.separator + piName;
            file = mr.getFile("pImg");
        }

        System.out.println(piName + " " + piType + " " + piSize);

        imgDTO.setPiName(piName);
        imgDTO.setPiOriName(piOriName);
        imgDTO.setPiPath(piPath);
        imgDTO.setPiType(piType);
        imgDTO.setPiSize(piSize);
        imgDTO.setPiImg(file);

        int piId = dao.insertProfileImg(imgDTO);

        String pName = mr.getParameter("pName");
        String pBirth = mr.getParameter("pBirth");
        String pSex = mr.getParameter("pSex");

        dto.setpName(pName);
        dto.setpBirth(pBirth);
        dto.setpSex(pSex);
        dto.setuId(uId);
        dto.setPiId(piId);

        dao.insertProfile(dto);
    }

}
