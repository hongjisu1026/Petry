package com.petry.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FindCommand {
    String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
