package com.petry.diary.command;

import com.petry.commonInterface.command.Command;
import com.petry.diary.dao.DiaryDAO;
import com.petry.diary.dto.AlbumDTO;
import com.petry.user.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoadAlbumCommand implements Command {
    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiaryDAO dao = DiaryDAO.getDiaryDAO();
        HttpSession session = request.getSession();
        int uId = ((UserDTO) session.getAttribute("userInfo")).getuId();

        ArrayList<AlbumDTO> album = dao.selectAllDiaryImg(uId);
        request.setAttribute("album", album);
    }
}
