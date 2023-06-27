<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./assets/favicon.png">
    <title>Petry</title>
</head>
<body>
    <script>
        (() => {
            start();
        })();
        function start() {
            alert('아이디 혹은 비밀번호가 일치하지 않습니다.');
            location.href = './index.jsp';
        }
    </script>
</body>
</html>