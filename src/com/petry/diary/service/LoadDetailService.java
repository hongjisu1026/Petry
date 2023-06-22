package com.petry.diary.service;

import com.petry.command.Command;
import com.petry.diary.command.LoadDetailCommand;
import com.petry.diary.dao.DiaryDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoadDetailService", value = "/diaryDetail.do")
public class LoadDetailService extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Command command = new LoadDetailCommand();
        command.excute(request, response);
    }
}
