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

    public void insertProfile(ProfileDTO dto) {
        String SQL = "INSERT INTO " + PROFILE + " (pName, pBirth, pSex, uId, piId) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getpName());
            pstmt.setString(2, dto.getpBirth());
            pstmt.setString(3, dto.getpSex());
            pstmt.setInt(4, dto.getuId());
            pstmt.setInt(5, dto.getPiId());
            System.out.println(dto.getPiId());

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertProfileImg(ProfileImgDTO dto) {
        String SQL = "INSERT INTO " + PROFILE_IMG + " (piName, piOriName, piPath, piType, piSize) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getPiName());
            pstmt.setString(2, dto.getPiOriName());
            pstmt.setString(3, dto.getPiPath());
            pstmt.setString(4, dto.getPiType());
            pstmt.setLong(5, dto.getPiSize());

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectPiIdToPiName(dto);
    }

    public int selectPiIdToPiName(ProfileImgDTO dto) {
        int piId = 0;
        String SQL = "SELECT piId FROM " + PROFILE_IMG + " WHERE piName = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getPiName());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                piId = rs.getInt("piId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return piId;
    }

    public ArrayList<ProfileDTO> selectProfile(int uId) {
        ArrayList<ProfileDTO> list = new ArrayList<>();
        String SQL = "SELECT * FROM " + PROFILE + " WHERE uId = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);;
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ProfileDTO dto = new ProfileDTO();
                dto.setpId(rs.getInt("pId"));
                dto.setpName(rs.getString("pName"));
                dto.setpBirth(rs.getString("pBirth"));
                dto.setpSex(rs.getString("pSex"));
                dto.setPiId(rs.getInt("piId"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ProfileImgDTO selectProfileImg(int piId) {
        String SQL = "SELECT * FROM " + PROFILE_IMG + " WHERE piId = ?";
        ProfileImgDTO dto = new ProfileImgDTO();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, piId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setPiId(rs.getInt("piId"));
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

    public void deleteProfile(ProfileDTO dto) {
        String SQL = "DELETE FROM " + PROFILE + " WHERE pId = ? AND uId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dto.getpId());
            pstmt.setInt(2, dto.getuId());

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(selectPiId(dto));
        deleteProfileImg(selectPiId(dto));
    }

    public int selectPiId(ProfileDTO dto) {
        int piId = 0;
        String SQL = "SELECT piId FROM " + PROFILE + " WHERE pId = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dto.getpId());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                piId = rs.getInt("piId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return piId;
    }

    public void deleteProfileImg(int piId) {
        String SQL = "DELETE FROM " + PROFILE_IMG + " WHERE piId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, piId);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectPiName(ProfileDTO dto) {
        String piName = null;
        int piId = selectPiId(dto);
        String SQL = "SELECT piName FROM " + PROFILE_IMG + " WHERE piId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstm = conn.prepareStatement(SQL)) {
            pstm.setInt(1, piId);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                piName = rs.getString("piName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return piName;
    }



}
