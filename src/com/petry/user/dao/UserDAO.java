package com.petry.user.dao;

import com.petry.user.dto.UserDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {
    private static UserDAO userDAO = new UserDAO();
    private final String USER = "user";
    private DataSource dataSource;

    private UserDAO() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/petry");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static UserDAO getUserDAO() {
        return userDAO;
    }

    public int registerOK(UserDTO dto) {
        String SQL = "INSERT INTO " + USER + " (id, pwd, email, name, birth, nickname) VALUES (?, ?, ?, ?, ?, ?)";
        int result = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPwd());
            pstmt.setString(3, dto.getEmail());
            pstmt.setString(4, dto.getName());
            pstmt.setString(5, dto.getBirth());
            pstmt.setString(6, dto.getNickname());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String checkPwd(UserDTO dto) {
        String SQL = "SELECT * FROM " + USER + " WHERE id = ?";
        String pwd = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pwd = rs.getString("pwd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pwd;
    }

    public UserDTO loginOK(UserDTO dto) {
        String SQL = "SELECT * FROM " + USER + " WHERE id = ? AND pwd = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPwd());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setuId(rs.getInt("uId"));
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("pwd"));
                dto.setEmail(rs.getString("email"));
                dto.setName(rs.getString("name"));
                dto.setBirth(rs.getString("birth"));
                dto.setNickname(rs.getString("nickname"));
            } else {
                dto = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public int checkId(String id) {
        String SQL = "SELECT * FROM " + USER + " WHERE id = ?";
        int check = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() || id.equals("")) {
                check = 0;
            } else {
                check = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }

    public int checkEmail(String email) {
        String SQL = "SELECT * FROM " + USER + " WHERE email = ?";
        int check = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() || email.equals("")) {
                check = 0;
            } else {
                check = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }

    public String findId(String name, String email) {
        String id = null;
        String SQL = "SELECT id FROM " + USER + " WHERE name = ? AND email = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getString("user.id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(id);

        return id;
    }

    public String findPwd(String id, String email) {
        String pwd = null;
        String SQl = "SELECT pwd FROM " + USER + " WHERE id = ? AND email = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQl)) {
            pstmt.setString(1, id);
            pstmt.setString(2, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pwd = rs.getString("user.pwd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pwd;
    }

    public void deleteUser(int uId) {
        String SQL = "DELETE FROM " + USER + " WHERE uId=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String checkPwd(int uId) {
        String pwd = null;
        String SQL = "SELECT * FROM " + USER + " WHERE uId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pwd = rs.getString("pwd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pwd;
    }

    public UserDTO selectUser(int uId) {
        UserDTO dto = new UserDTO();
        String SQL = "SELECT * FROM " + USER + " WHERE uId = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("pwd"));
                dto.setEmail(rs.getString("email"));
                dto.setName(rs.getString("name"));
                dto.setBirth(rs.getString("birth"));
                dto.setNickname(rs.getString("nickname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    public void updateUser(UserDTO dto) {
        String SQL = "UPDATE " + USER + " set pwd = ?, email = ?, name = ?, nickname = ? WHERE uId = ?";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, dto.getPwd());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getNickname());
            pstmt.setInt(5, dto.getuId());
            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
