package com.petry.diary.dao;

import com.petry.diary.dto.AlbumDTO;
import com.petry.diary.dto.DiaryDTO;
import org.apache.commons.io.FileUtils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
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
        String SQL = "INSERT INTO " + ALBUM + " (aName, aOriName, aPath, aType, aSize, aThumbnail, aImg,  dId, uId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            byte[] bytes = FileUtils.readFileToByteArray(dto.getaImg());

            pstmt.setString(1, dto.getaName());
            pstmt.setString(2, dto.getaOriName());
            pstmt.setString(3, dto.getaPath());
            pstmt.setString(4, dto.getaType());
            pstmt.setLong(5, dto.getaSize());
            pstmt.setInt(6, dto.getaThumbnail());
            pstmt.setBytes(7, bytes);
            pstmt.setInt(8, dto.getdId());
            pstmt.setInt(9, dto.getuId());

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public DiaryDTO selectDiary(int dId, int uId) {
        DiaryDTO dto = new DiaryDTO();
        String SQL = "SELECT * FROM " + DIARY + " WHERE dId = ? AND uId = ?";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dId);
            pstmt.setInt(2, uId);

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

    public String selectDiaryImg(int dId) {
        String list = "";
        String SQL = "SELECT * FROM " + ALBUM + " WHERE dId = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, dId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list += rs.getString("aName") + " ";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<String> selectDiaryImgLimit5(int uId) {
        ArrayList<String> list = new ArrayList<>();
        String SQL = "SELECT * FROM " + ALBUM + " WHERE uId = ? ORDER BY aUploadTime DESC LIMIT 5";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("aName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteDiary(int uId, int dId) {
        String SQL = "DELETE FROM " + DIARY + " WHERE uId = ? AND dId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);
            pstmt.setInt(2, dId);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDiaryImg(int uId, int dId) {
        String SQL = "DELETE FROM " + ALBUM + " WHERE uId = ? AND dId = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);
            pstmt.setInt(2, dId);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDiary(int dId, int uId, String newTitle, String newContent) {
        String SQL = "UPDATE " + DIARY + " SET dTitle = ?, dContent = ? WHERE dId = ? AND uId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
             pstmt.setString(1, newTitle);
             pstmt.setString(2, newContent);
             pstmt.setInt(3, dId);
             pstmt.setInt(4, uId);
             int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<AlbumDTO> selectAllDiaryImg(int uId) {
        ArrayList<AlbumDTO> list = new ArrayList<>();
        String SQL = "SELECT * FROM " + ALBUM + " WHERE uId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AlbumDTO dto = new AlbumDTO();
                dto.setdId(rs.getInt("dId"));
                dto.setaId(rs.getInt("aId"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
