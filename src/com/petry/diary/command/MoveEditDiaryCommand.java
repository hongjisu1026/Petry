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

public class MoveEditDiaryCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();
        int dId = Integer.parseInt(request.getParameter("dId"));

        DiaryDTO dto = DiaryDAO.getDiaryDAO().selectDiary(dId, uId);
        System.out.println(dto.getdTitle());
        System.out.println(dto.getdContent());

        request.setAttribute("dId", dId);
        request.setAttribute("dTitle", dto.getdTitle());
        request.setAttribute("dContent", dto.getdContent());
    }
}
