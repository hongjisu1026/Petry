package com.petry.diary.command;

import com.petry.commonInterface.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.diary.dto.DiaryDTO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoadDiaryCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DiaryDAO dao = DiaryDAO.getDiaryDAO();
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();

        ArrayList<DiaryDTO> diary = dao.selectAllDiary(uId);
        ArrayList<String> album = new ArrayList<>();

        for (DiaryDTO dto : diary) {
            int dId = dao.selectdId(dto);
            dto.setdId(dId);
            album.add(dao.selectDiaryImg(dId));
            System.out.println(dao.selectDiaryImg(dId));
        }

        request.setAttribute("diary", diary);
        request.setAttribute("album", album);
    }
}
