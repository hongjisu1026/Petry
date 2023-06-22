package com.petry.diary.dao;

import com.petry.diary.dto.AlbumDTO;
import com.petry.diary.dto.DiaryDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiaryDAO {
    private static DiaryDAO diaryDAO = new DiaryDAO();
    private final String DIARY = "diary";
    private final String ALBUM = "album";
    private DataSource dataSource;

    private DiaryDAO() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/petry");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static DiaryDAO getDiaryDAO() {
        return diaryDAO;
    }

    public void insertDiary(DiaryDTO dto) {
        String SQL = "INSERT INTO " + DIARY + " (dTitle, dContent, uId) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getdTitle());
            pstmt.setString(2, dto.getdContent());
            pstmt.setInt(3, dto.getuId());

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDiaryImg(AlbumDTO dto) {
        String SQL = "INSERT INTO " + ALBUM + " (aName, aOriName, aPath, aType, aSize, aThumbnail, dId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getaName());
            pstmt.setString(2, dto.getaOriName());
            pstmt.setString(3, dto.getaPath());
            pstmt.setString(4, dto.getaType());
            pstmt.setLong(5, dto.getaSize());
            pstmt.setInt(6, dto.getaThumbnail());
            pstmt.setInt(7, dto.getdId());

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int selectdId(DiaryDTO dto) {
        String SQL = "SELECT dId FROM " + DIARY + " WHERE dTitle = ? AND dContent = ?";
        int dId = 0;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getdTitle());
            pstmt.setString(2, dto.getdContent());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dId = rs.getInt("dId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dId;
    }

    public ArrayList<DiaryDTO> selectAllDiary(int uId) {
        ArrayList<DiaryDTO> list = new ArrayList<>();
        String SQL = "SELECT * FROM " + DIARY + " WHERE uId = ?";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DiaryDTO dto = new DiaryDTO();
                dto.setdId(rs.getInt("dId"));
                dto.setdTitle(rs.getString("dTitle"));
                dto.setdContent(rs.getString("dContent"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String selectThumbnailImg(int dId) {
        String aName = null;
        String SQL = "SELECT aName FROM " + ALBUM + " WHERE dId = ? AND aThumbnail = 1";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                aName = rs.getString("aName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aName;
    }

    public DiaryDTO selectDiary(int dId) {
        DiaryDTO dto = new DiaryDTO();
        String SQL = "SELECT * FROM " + DIARY + " WHERE dId = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setdTitle(rs.getString("dTitle"));
                dto.setdContent(rs.getString("dContent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    public ArrayList<String> selectDiaryImg(int dId) {
        ArrayList<String> list = new ArrayList<>();
        String aName = null;
        String SQL = "SELECT * FROM " + ALBUM + " WHERE dId = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                aName = rs.getString("aName");

                list.add(aName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
