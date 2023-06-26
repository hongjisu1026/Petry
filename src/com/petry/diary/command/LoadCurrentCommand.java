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

@WebServlet(name = "LoadCurrentCommand", value = "/LoadCurrentCommand")
public class LoadCurrentCommand extends HttpServlet {
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
        String aName = request.getParameter("aName");
        String SQL = "SELECT * FROM album WHERE uId = ? AND aName = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);
            pstmt.setString(2, aName);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                aType = rs.getString("aType");
                is = rs.getBinaryStream("aImg");
                System.out.println(rs.getString("aName"));
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
