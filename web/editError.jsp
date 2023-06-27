<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/8908bd1bc0.js" crossorigin="anonymous"></script>
    <script src="./js/jquery.js"></script>
    <link rel="icon" href="./assets/favicon.png">
    <title>Petry</title>
</head>
<body>
    <script>
        (() => {
            alert('비밀번호가 일치하지 않습니다.');
            location.href = './setting.jsp';
        })();
    </script>
</body>
</html>