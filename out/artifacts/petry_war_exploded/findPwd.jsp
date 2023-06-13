<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Petry</title>
</head>
<body>
<script>
    (() => {
        let pwd = '${requestScope.info}';
        let result = '';

        for (let i = 0; i < pwd.length; i++) {
            if (i > 3) {
                result += '*';
                continue;
            }
            result += pwd[i];
        }
        alert("비밀번호는 \' " + result + " \'입니다.");
        location.href = './index.jsp';
    })();
</script>
</body>
</html>