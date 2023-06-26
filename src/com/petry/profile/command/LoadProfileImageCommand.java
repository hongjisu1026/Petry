package com.petry.profile.command;

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

@WebServlet(name = "LoadProfileImageCommand", value = "/LoadProfileImageCommand")
public class LoadProfileImageCommand extends HttpServlet {
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
        String piType = null;
        int piId = Integer.parseInt(request.getParameter("piId"));
        String SQL = "SELECT * FROM profileImg WHERE piId = ?";

        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, piId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                piType = rs.getString("piType");
                is = rs.getBinaryStream("piImg");
                response.setContentType("image/" + piType);
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
