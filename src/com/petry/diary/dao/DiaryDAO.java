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
        String SQL = "INSERT INTO " + DIARY + " (dTitle, dContent) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getdTitle());
            pstmt.setString(2, dto.getdContent());

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDiaryImg(AlbumDTO dto) {
        String SQL = "INSERT INTO " + ALBUM + " (aName, aOriName, aPath, aType, aSize, dId) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getaName());
            pstmt.setString(2, dto.getaOriName());
            pstmt.setString(3, dto.getaPath());
            pstmt.setString(4, dto.getaType());
            pstmt.setLong(5, dto.getaSize());
            pstmt.setInt(6, dto.getdId());

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
}
