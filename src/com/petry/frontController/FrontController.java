package com.petry.frontController;

import com.petry.commonInterface.command.*;
import com.petry.diary.command.*;
import com.petry.profile.command.DeleteProfileCommand;
import com.petry.profile.command.LoadProfileCommand;
import com.petry.profile.command.ProfileCommand;
import com.petry.user.command.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doAction(request, response);
    }

    public void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String commandName = request.getServletPath();
        HttpSession session = request.getSession();
        String viewPage = null;
        Command command = null;
        BooleanCommand booleanCommand = null;
        StringCommand stringCommand = null;
        DetailCommand detailCommand = null;

        switch (commandName) {
            case "/register.do":
                viewPage = "register.jsp";
            case "/registerOK.do":
                command = new RegisterCommand();
                command.excute(request, response);
                viewPage = "index.jsp";
                break;
            case "/index.do":
                viewPage = "index.jsp";
            case "/login.do":
                booleanCommand = new LoginCommand();
                boolean check = booleanCommand.excute(request, response);
                if (check) {
                    viewPage = "main.jsp";
                    command = new LoadProfileCommand();
                    command.excute(request, response);
                    command = new CurrentAlbumCommand();
                    command.excute(request, response);
                } else {
                    viewPage = "loginError.jsp";
                }
                break;
            case "/findId.do":
                stringCommand = new FindIdCommand();
                String id = stringCommand.excute(request, response);
                if (id != null) {
                    request.setAttribute("info", id);
                    viewPage = "findId.jsp";
                } else {
                    viewPage = "findError.jsp";
                }
                break;
            case "/findPwd.do":
                stringCommand = new FindPwdCommand();
                String pwd = stringCommand.excute(request, response);
                if (pwd != null) {
                    request.setAttribute("info", pwd);
                    viewPage = "findPwd.jsp";
                } else {
                    viewPage = "findError.jsp";
                }
                break;
            case "/logout.do":
                command = new LogoutCommand();
                command.excute(request, response);
                viewPage = "index.jsp";
                break;
            case "/delete.do":
                command = new DeleteCommand();
                command.excute(request, response);
                viewPage = "index.jsp";
                break;
            case "/moveEdit.do":
                booleanCommand = new MoveEditCommand();
                boolean result = booleanCommand.excute(request, response);
                System.out.println(result);
                if (result) {
                    viewPage = "edit.jsp";
                } else {
                    viewPage = "editError.jsp";
                }
                break;
            case "/edit.do":
                command = new EditCommand();
                command.excute(request, response);
                command = new LoadProfileCommand();
                command.excute(request, response);
                command = new CurrentAlbumCommand();
                command.excute(request, response);
                viewPage = "main.jsp";
                break;
            case "/main.do":
                command = new LoadProfileCommand();
                command.excute(request, response);
                command = new CurrentAlbumCommand();
                command.excute(request, response);
                viewPage = "main.jsp";
                break;
            case "/profile.do":
                command = new ProfileCommand();
                command.excute(request, response);
                command = new LoadProfileCommand();
                command.excute(request, response);
                viewPage = "profileList.jsp";
                break;
            case "/profileList.do":
                command = new LoadProfileCommand();
                command.excute(request, response);
                viewPage = "profileList.jsp";
                break;
            case "/deleteProfile.do":
                command = new DeleteProfileCommand();
                command.excute(request, response);
                command = new LoadProfileCommand();
                command.excute(request, response);
                viewPage = "profileList.jsp";
                break;
            case "/diary.do":
                command = new CreateDiaryCommand();
                command.excute(request, response);
                command = new LoadDiaryCommand();
                command.excute(request, response);
                viewPage = "diaryList.jsp";
                break;
            case "/diaryList.do":
                command = new LoadDiaryCommand();
                command.excute(request, response);
                viewPage = "diaryList.jsp";
                break;
            case "/deleteDiary.do":
                command = new DeleteDiaryCommand();
                command.excute(request, response);
                command = new LoadDiaryCommand();
                command.excute(request, response);
                viewPage = "diaryList.jsp";
                break;
            case "/moveEditDiary.do":
                command = new MoveEditDiaryCommand();
                command.excute(request, response);
                viewPage = "editDiary.jsp";
                break;
            case "/editDiary.do":
                command = new EditDiaryCommand();
                command.excute(request, response);
                command = new LoadDiaryCommand();
                command.excute(request, response);
                viewPage = "diaryList.jsp";
                break;
            case "/album.do":
                command = new LoadAlbumCommand();
                command.excute(request, response);
                viewPage = "album.jsp";
                break;
            case "/diaryDetail.do":
                command = new DiaryDetailCommand();
                command.excute(request, response);
                viewPage = "diaryDetail.jsp";
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
    }
}
