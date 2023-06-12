package com.petry.frontController;

import com.petry.command.*;

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
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
    }
}
