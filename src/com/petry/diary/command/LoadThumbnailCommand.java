package com.petry.diary.command;

import com.petry.user.dto.UserDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "LoadThumbnailCommand", value = "/LoadThumbnailCommand")
public class LoadThumbnailCommand extends HttpServlet {
    private DataSource dataSource;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/petry");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        InputStream is = null;
        String aType = null;
        HttpSession session = request.getSession();
        int uId = ((UserDTO)session.getAttribute("userInfo")).getuId();
        int dId = Integer.parseInt(request.getParameter("dId"));
        String SQL = "SELECT * FROM album WHERE dId = ? AND uId = ? AND aThumbnail = 1";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dId);
            pstmt.setInt(2, uId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                aType = rs.getString("aType");
                is = rs.getBinaryStream("aImg");
                response.setContentType("image/" + aType);
                ServletOutputStream os = response.getOutputStream();
                int binaryRead;
                while ((binaryRead = is.read()) != -1) {
                    os.write(binaryRead);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
