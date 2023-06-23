<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/8908bd1bc0.js" crossorigin="anonymous"></script>
    <script src="./js/jquery.js"></script>
    <title>Petry</title>
</head>
<body onload="start()">
    <form method="post" action="deleteDiary.do" id="submit">
        <input type="text" id="dId" name="dId">
    </form>

<script>
    function start() {
        const url = window.location.href;
        const dId = url.split('=')[1];
        console.log(dId)
        $('#dId').attr('value', dId);
        $('#submit').submit();
    }
</script>
</body>
</html>