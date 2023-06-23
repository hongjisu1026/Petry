package com.petry.diary.command;

import com.petry.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditDiaryCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DiaryDAO dao = DiaryDAO.getDiaryDAO();
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();
        String oldTitle = request.getParameter("dTitle");
        String newTitle = request.getParameter("diaryTitle");
        String oldContent = request.getParameter("dContent");
        String newContent = request.getParameter("diaryContent");

        dao.updateDiary(oldTitle, oldContent, newTitle, newContent, uId);
    }
}
