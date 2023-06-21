package com.petry.diary.command;

import com.petry.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.diary.dto.DiaryDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoadDiaryCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiaryDAO diaryDAO = DiaryDAO.getDiaryDAO();
        ArrayList<DiaryDTO> diary = new ArrayList<>();
    }
}
