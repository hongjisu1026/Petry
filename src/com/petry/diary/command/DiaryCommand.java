package com.petry.diary.command;

import com.oreilly.servlet.MultipartRequest;
import com.petry.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.diary.dto.AlbumDTO;
import com.petry.diary.dto.DiaryDTO;
import com.petry.profile.Service.MyFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

public class DiaryCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiaryDAO dao = DiaryDAO.getDiaryDAO();
        DiaryDTO dto = new DiaryDTO();
        AlbumDTO albumDTO = new AlbumDTO();
        String realPath = "E:\\JavaStudy\\Project\\petry\\web\\assets\\images\\album";

        MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*1024, "utf-8", new MyFileRenamePolicy());

        dto.setdTitle(mr.getParameter("diaryTitle"));
        dto.setdContent(mr.getParameter("diaryContent"));

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

            albumDTO.setaName(aName);
            albumDTO.setaOriName(aOriName);
            albumDTO.setaPath(aPath);
            albumDTO.setaType(aType);
            albumDTO.setaSize(aSize);
            albumDTO.setdId(dId);

            dao.insertDiaryImg(albumDTO);
        }
    }
}