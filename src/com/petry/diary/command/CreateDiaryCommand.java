package com.petry.diary.command;

import com.oreilly.servlet.MultipartRequest;
import com.petry.commonInterface.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.diary.dto.AlbumDTO;
import com.petry.diary.dto.DiaryDTO;
import com.petry.profile.Service.MyFileRenamePolicy;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

public class CreateDiaryCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DiaryDAO dao = DiaryDAO.getDiaryDAO();
        DiaryDTO dto = new DiaryDTO();
        AlbumDTO albumDTO = new AlbumDTO();
        String realPath = "F:\\JavaStudy\\Project\\petry\\web\\assets\\images\\album";
        File file = null;
        int count = 1;

        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();

        MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*1024, "utf-8", new MyFileRenamePolicy());

        dto.setdTitle(mr.getParameter("diaryTitle"));
        dto.setdContent(mr.getParameter("diaryContent"));
        dto.setuId(uId);

        dao.insertDiary(dto);

        int dId = dao.selectdId(dto);
        System.out.println(dId);

        Enumeration<?> files = mr.getFileNames();
        while (files.hasMoreElements()) {
            String element = (String) files.nextElement();
            String aName = mr.getFilesystemName(element);
            String aOriName = mr.getOriginalFileName(element);
            String aType = mr.getContentType(element).split("/")[1];
            long aSize = mr.getFile(element).length();
            String aPath = realPath + File.separator + aName;
            file = new File(aPath);

            albumDTO.setaName(aName);
            albumDTO.setaOriName(aOriName);
            albumDTO.setaPath(aPath);
            albumDTO.setaType(aType);
            albumDTO.setaSize(aSize);
            albumDTO.setaImg(file);
            albumDTO.setdId(dId);
            albumDTO.setaThumbnail(count);
            albumDTO.setuId(uId);

            count++;
            dao.insertDiaryImg(albumDTO);

        }
    }
}
