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
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;

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
        String piPath = "E:\\JavaStudy\\Project\\petry\\web\\assets\\images\\profile";
        long piSize = 0;

        MultipartRequest mr = new MultipartRequest(request, piPath, 1024*1024*1024, "utf-8", new DefaultFileRenamePolicy());
        System.out.println("경로 : " + piPath);

        Enumeration<?> files = mr.getFileNames();
        if (files.hasMoreElements()) {
            element = (String) files.nextElement();
            piOriName = mr.getOriginalFileName(element);
            piType = mr.getContentType(element).split("/")[1];
            piSize = mr.getFile(element).length();
        }

        piName = random() + "." + piType;

        if (piOriName != null) {
            File oldFile = new File(piPath + "\\" + piOriName);
            File newFile = new File(piPath + "\\" + piName);
            oldFile.renameTo(newFile);
        }

        System.out.println(piName + " " + piType + " " + piSize);

        imgDTO.setPiName(piName);
        imgDTO.setPiOriName(piOriName);
        imgDTO.setPiPath(piPath);
        imgDTO.setPiType(piType);
        imgDTO.setPiSize(piSize);

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

    public String random() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        for (int i = 0; i < 16; i++) {
            builder.append(chs[random.nextInt(chs.length)]);
        }

        return builder.toString();
    }
}
