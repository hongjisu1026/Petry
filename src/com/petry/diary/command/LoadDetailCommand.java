package com.petry.diary.command;

import com.petry.command.Command;
import com.petry.diary.dao.DiaryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoadDetailCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiaryDAO dao = DiaryDAO.getDiaryDAO();
        int dId = Integer.parseInt(request.getParameter("dId"));
        System.out.println(dId);

        request.setAttribute("album", dao.selectDiaryImg(dId));
        request.setAttribute("dTitle", dao.selectDiary(dId).getdTitle());
        request.setAttribute("dContent", dao.selectDiary(dId).getdContent());

        System.out.println(dao.selectDiaryImg(dId));
        System.out.println(dao.selectDiary(dId).getdTitle());
        System.out.println(dao.selectDiary(dId).getdContent());
    }
}
