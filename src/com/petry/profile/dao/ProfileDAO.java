package com.petry.profile.dao;

import com.petry.profile.dto.ProfileDTO;
import com.petry.profile.dto.ProfileImgDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDAO {
    private static ProfileDAO profileDAO = new ProfileDAO();
    private final String PROFILE = "profile";
    private final String PROFILE_IMG = "profileImg";
    private DataSource dataSource;


    private ProfileDAO() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/petry");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static ProfileDAO getProfileDAO() {
        return profileDAO;
    }

    public int inputProfile(String pName, String pBirth, String pSex) {
        String SQL = "INSERT INTO " + PROFILE + " (pName, pBirth, pSex) VALUES (?, ?, ?)";
        int result = 0;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, pName);
            pstmt.setString(2, pBirth);
            pstmt.setString(3, pSex);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ProfileImgDTO uploadProfileImg(ProfileImgDTO dto) {
        String SQL = "INSERT INTO " + PROFILE_IMG + " (piName, piPath, piType, piSize) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getPiName());
            pstmt.setString(2, dto.getPiPath());
            pstmt.setString(3, dto.getPiType());
            pstmt.setLong(4, dto.getPiSize());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setPiName(rs.getString("piName"));
                dto.setPiPath(rs.getString("piPath"));
                dto.setPiType(rs.getString("piType"));
                dto.setPiSize(rs.getLong("piSize"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

}
