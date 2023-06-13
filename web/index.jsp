<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/8908bd1bc0.js" crossorigin="anonymous"></script>
    <script src="./js/jquery.js"></script>
    <title>Petry</title>
    <style>
        /* http://meyerweb.com/eric/tools/css/reset/
        v2.0 | 20110126
        License: none (public domain)
        */
        html,
        body,
        div,
        span,
        applet,
        object,
        iframe,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        p,
        blockquote,
        pre,
        a,
        abbr,
        acronym,
        address,
        big,
        cite,
        code,
        del,
        dfn,
        em,
        img,
        ins,
        kbd,
        q,
        s,
        samp,
        small,
        strike,
        strong,
        sub,
        sup,
        tt,
        var,
        b,
        u,
        i,
        center,
        dl,
        dt,
        dd,
        ol,
        ul,
        li,
        fieldset,
        form,
        label,
        legend,
        table,
        caption,
        tbody,
        tfoot,
        thead,
        tr,
        th,
        td,
        article,
        aside,
        canvas,
        details,
        embed,
        figure,
        figcaption,
        footer,
        header,
        hgroup,
        menu,
        nav,
        output,
        ruby,
        section,
        summary,
        time,
        mark,
        audio,
        video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }

        /* HTML5 display-role reset for older browsers */
        article,
        aside,
        details,
        figcaption,
        figure,
        footer,
        header,
        hgroup,
        menu,
        nav,
        section {
            display: block;
        }

        body {
            line-height: 1;
        }

        ol,
        ul {
            list-style: none;
        }

        blockquote,
        q {
            quotes: none;
        }

        blockquote:before,
        blockquote:after,
        q:before,
        q:after {
            content: '';
            content: none;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }
    </style>

    <style>
        @font-face {
            font-family: 'Cafe24Ssurround';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/Cafe24Ssurround.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }

        @font-face {
            font-family: 'Cafe24SsurroundAir';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/Cafe24SsurroundAir.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }

        body {
            font-family: 'Cafe24SsurroundAir';
            overflow: hidden;
            position: relative;
            width: 100vw;
            height: 100vh;
        }

        .outer-wrapper {
            width: 100vw;
            height: 100vh;
        }

        .inner-wrapper {
            width: 50%;
            height: 100%;
            float: right;
            position: relative;
        }

        .content-wrapper {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }

        .img-wrapper {
            width: 50%;
            height: 100%;
            float: left;
        }

        .img-wrapper img {
            height: 935px;
            width: 100%;
        }

        #logo {
            font-size: 2em;
            text-align: center;
            margin: 10px;
            color: #F2C8B0;
            cursor: pointer;
        }

        input {
            display: block;
            height: 30px;
            width: 290px;
            margin-bottom: 15px;
            margin-left: 1px;
            border: solid 1px #bbb;
            border-radius: 5px;
            padding-left: 10px;
        }

        input:focus {
            outline: none;
            border-color: #F2C8B0;
            box-shadow: none;
            text-shadow: none;
        }

        .submit {
            font-family: 'Cafe24SsurroundAir';
            width: 305px;
            border: solid 1px #F2C8B0;
            background-color: #fff;
            border-radius: 7px;
        }

        .submit:hover {
            background-color: #F2C8B0;
        }

        .menu p {
            display: inline-block;
            margin-right: 10px;
        }

        .menu p:first-child {
            margin-left: 10px;
        }

        .menu p a {
            color: #ccc;
            text-decoration: none;
            cursor: pointer;
        }

        .menu p:hover {
            color: #ccc;
            text-decoration: underline;
        }

        .popup-overlay {
            display: none;
            width: 100vw;
            height: 100vh;
            position: absolute;
            background-color: rgba(0, 0, 0, 0.7);
        }

        .popup-overlay.show {
            display: block;
        }

        .find {
            position: absolute;
            background-color: white;
            width: 400px;
            text-align: center;
            padding: 30px;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border: solid #F2C8B0 1px;
            border-radius: 10px;
            font-weight: 600;
        }

        .find p {
            margin-bottom: 20px;
            color: #F2C8B0;
            font-size: 1.5em;
        }

        .find i {
            position: absolute;
            color: #F2C8B0;
            right: 20px;
            top: 20px;
            font-size: larger;
            cursor: pointer;
        }

        .find input {
            margin: auto;
            margin-bottom: 10px;
        }
    </style>
</head>

<body>

<div class="outer-wrapper">
    <div class="img-wrapper">
        <img src="./assets/background/sole.jpg" alt="sole">
    </div>
    <div class="inner-wrapper">
        <div class="content-wrapper">
            <p id="logo" onclick="move()">로고</p>
            <form action="login.do" method="post" id="form">
                <input type="text" name="userId" id="userId" placeholder="아이디" data-name="아이디">
                <input type="password" name="userPwd" id="userPwd" placeholder="비밀번호" data-name="비밀번호">
                <input type="submit" value="로그인" class="submit" id="loginBtn">
            </form>
            <div class="menu">
                <p><a href="#findId" id="btn_findId">아이디 찾기</a></p>
                <p><a href="#findPwd" id="btn_findPwd">비밀번호 찾기</a></p>
                <p><a href="./register.jsp">회원가입</a></p>
            </div>
        </div>
    </div>

    <div class="popup-overlay" id="findId">
        <div class="find">
            <i class="fa-solid fa-xmark"></i>
            <p>아이디 찾기</p>
            <form action="findId.do" method="post" id="findIdForm">
                <input type="text" name="iName" id="iName" placeholder="이름" data-name="이름">
                <input type="email" name="iEmail" id="iEmail" placeholder="이메일" data-name="이메일">
                <input type="submit" value="찾기" class="submit" id="findIdBtn">
            </form>
        </div>
    </div>

    <div class="popup-overlay" id="findPwd">
        <div class="find">
            <i class="fa-solid fa-xmark"></i>
            <p>비밀번호 찾기</p>
            <form action="findPwd.do" method="post" id="findPwdForm">
                <input type="text" name="pId" id="pId" placeholder="아이디" data-name="아이디">
                <input type="email" name="pEmail" id="pEmail" placeholder="이메일" data-name="이메일">
                <input type="submit" value="찾기" class="submit" id="findPwdBtn">
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    function move() {
        location.href = "./index.jsp";
    }

    $('.fa-xmark').click(function () {
        $('.popup-overlay').removeClass('show');
    });

    $(document).mouseup(function (e) {
        const overlay = $('.popup-overlay');
        if (overlay.has(e.target).length === 0) {
            overlay.removeClass('show');
        }
    });

    $(document).on("click", "#btn_findId", function () {
        const target = $(this).attr("href");
        $(target).addClass('show');
    });

    $(document).on("click", "#btn_findPwd", function () {
        const target = $(this).attr("href");
        $(target).addClass('show');
    });

    $(function () {
        $("#loginBtn").click(function () {
            let isRight = true;
            $("#form").find("input").each(function (index, item) {
                if ($(this).val().trim() === '') {
                    alert($(this).attr("data-name") + " 항목을 입력하세요.");
                    return false;
                }
            });

            if (!isRight) {
                return;
            }

            $(this).prop("disabled", true);
            $(this).prop("disabled", false);
        });
    });

</script>
</body>

</html>