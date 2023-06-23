package com.petry.diary.command;

import com.petry.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class DeleteDiaryCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DiaryDAO dao = DiaryDAO.getDiaryDAO();
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();
        int dId = Integer.parseInt(request.getParameter("dId"));

        String imgList = dao.selectDiaryImg(dId);
        String[] list = imgList.split(" ");
        String aPath = "E:\\JavaStudy\\Project\\petry\\web\\assets\\images\\album";
        File file = null;
        for (String s : list) {
            file = new File(aPath + "\\" + s);
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("삭제 성공");
                } else {
                    System.out.println("삭제 실패");
                }
            } else {
                System.out.println("파일이 존재하지 않음");
            }
        }

        dao.deleteDiaryImg(uId, dId);
        dao.deleteDiary(uId, dId);
    }
}
