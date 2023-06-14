package com.petry.frontController;

import com.petry.command.*;
import com.petry.profile.command.DeleteProfileCommand;
import com.petry.profile.command.LoadProfileCommand;
import com.petry.profile.command.ProfileCommand;
import com.petry.profile.command.UpdateProfileCommand;
import com.petry.user.command.FindIdCommand;
import com.petry.user.command.FindPwdCommand;
import com.petry.user.command.LoginOKCommand;
import com.petry.user.command.RegisterOKCommand;
import com.petry.user.dto.UserDTO;

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
        String viewPage = null;
        Command command = null;
        LoginCommand loginCommand = null;
        FindCommand findCommand = null;

        switch (commandName) {
            case "/register.do":
                viewPage = "register.jsp";
            case "/registerOK.do":
                command = new RegisterOKCommand();
                command.excute(request, response);
                viewPage = "index.jsp";
                break;
            case "/index.do":
                viewPage = "index.jsp";
            case "/login.do":
                loginCommand = new LoginOKCommand();
                boolean check = loginCommand.excute(request, response);
                if (check) {
                    viewPage = "main.jsp";
                    command = new LoadProfileCommand();
                    command.excute(request, response);
                } else {
                    viewPage = "loginError.jsp";
                }
                break;
            case "/findId.do":
                findCommand = new FindIdCommand();
                String id = findCommand.excute(request, response);
                if (id != null) {
                    request.setAttribute("info", id);
                    viewPage = "findId.jsp";
                } else {
                    viewPage = "findError.jsp";
                }
                break;
            case "/findPwd.do":
                findCommand = new FindPwdCommand();
                String pwd = findCommand.excute(request, response);
                if (pwd != null) {
                    request.setAttribute("info", pwd);
                    viewPage = "findPwd.jsp";
                } else {
                    viewPage = "findError.jsp";
                }
                break;
            case "/profile.do":
                command = new ProfileCommand();
                command.excute(request, response);
                viewPage = "profileList.jsp";
                break;
            case "/profileList.do":
                command = new LoadProfileCommand();
                command.excute(request, response);
                viewPage = "profileList.jsp";
                break;
            case "/updateProfile.do":
                command = new UpdateProfileCommand();
                command.excute(request, response);
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
            case "/loadProfile.do":
                command = new LoadProfileCommand();
                command.excute(request, response);
                viewPage = "profileUpdate.jsp";
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
    }
}
