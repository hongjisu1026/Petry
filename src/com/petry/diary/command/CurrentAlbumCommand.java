package com.petry.diary.command;

import com.petry.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CurrentAlbumCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();
        DiaryDAO dao = DiaryDAO.getDiaryDAO();

        ArrayList<String> list = dao.selectDiaryImgLimit5(uId);
        System.out.println(list);
        request.setAttribute("current", list);
    }
}
