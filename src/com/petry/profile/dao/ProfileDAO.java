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
import java.util.ArrayList;
import java.util.HashMap;

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

    public int inputProfile(ProfileDTO dto) {
        String SQL = "INSERT INTO " + PROFILE + " (pName, pBirth, pSex, uId, piId) VALUES (?, ?, ?, ?, ?)";
        int result = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getpName());
            pstmt.setString(2, dto.getpBirth());
            pstmt.setString(3, dto.getpSex());
            pstmt.setInt(4, dto.getuId());
            pstmt.setInt(5, dto.getPiId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int uploadProfileImg(ProfileImgDTO dto) {
        String SQL = "INSERT INTO " + PROFILE_IMG + " (piName, piPath, piType, piSize) VALUES (?, ?, ?, ?)";
        int result = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getPiName());
            pstmt.setString(2, dto.getPiPath());
            pstmt.setString(3, dto.getPiType());
            pstmt.setLong(4, dto.getPiSize());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ProfileImgDTO selectPiId(ProfileImgDTO dto) {
        String SQL = "SELECT piId FROM " + PROFILE_IMG + " WHERE piName = ? AND piPath = ? AND piType = ? AND piSize = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getPiName());
            pstmt.setString(2, dto.getPiPath());
            pstmt.setString(3, dto.getPiType());
            pstmt.setLong(4, dto.getPiSize());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setPiId(rs.getInt("piId"));
            } else {
                dto = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    public ProfileDTO loadProfile(int uId, int piId) {
        String SQL = "SELECT * FROM " + PROFILE + " WHERE uId = ? AND piId = ?";
        ProfileDTO dto = new ProfileDTO();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);
            pstmt.setInt(2, piId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setpId(rs.getInt("pId"));
                dto.setpName(rs.getString("pName"));
                dto.setpBirth(rs.getString("pBirth"));
                dto.setpSex(rs.getString("pSex"));;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    public ArrayList<ProfileImgDTO> loadProfileImg() {
        String SQL = "SELECT * FROM " + PROFILE_IMG;
        ArrayList<ProfileImgDTO> list = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ProfileImgDTO dto = new ProfileImgDTO();
                dto.setPiId(rs.getInt("piId"));
                dto.setPiName(rs.getString("piName"));
                dto.setPiPath(rs.getString("piPath"));
                dto.setPiType(rs.getString("piType"));
                dto.setPiSize(rs.getLong("piSize"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }



}
