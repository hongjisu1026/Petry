package com.petry.diary.command;

import com.petry.commonInterface.command.Command;
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
        int dId = Integer.parseInt(request.getParameter("dId"));
        String newTitle = request.getParameter("diaryTitle");
        String newContent = request.getParameter("diaryContent");
        System.out.println(dId);

        dao.updateDiary(dId, uId, newTitle, newContent);
    }
}
