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
        }

        .wrapper {
            width: 100vw;
            height: 100vh;
            position: relative;
        }

        .header {
            position: relative;
            width: 100%;
            height: 80px;
        }

        .logo {
            position: absolute;
            left: 20px;
        }

        #logo {
            border: none;
            width: 100px;
        }

        .menu-wrapper {
            position: relative;
        }

        .menu-ic {
            position: absolute;
            right: 30px;
        }

        .logo,
        .menu-ic {
            margin-top: 25px;
            display: inline-block;
            font-size: 2em;
            text-align: center;
            color: #F2C8B0;
        }

        .menu {
            display: none;
            border: solid 1px #F2C8B0;
            position: absolute;
            width: 300px;
            right: 30px;
            top: 65px;
            text-align: center;
        }

        .menu i {
            font-size: 2em;
        }

        i {
            color: #F2C8B0;
        }

        .menu-ic-wrapper {
            margin: 10px;
            display: inline-block;
            width: 70px;
            color: #F2C8B0;
            text-decoration: none;
        }

        .menu-ic-wrapper p {
            width: 70px;
            text-align: center;
            margin: 5px 0;
        }

        .menu-ic-wrapper:hover {
            transform: scale(1.15);
            transition: .5s;
        }

        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 100px;
            background-color: #ccc;
        }

        .content-wrapper {
            padding: 50px;
        }

        li {
            list-style: url(./assets/icon/paw-solid.svg);
            margin-bottom: 50px;
            font-size: 1.5em;
        }

        li:hover {
            font-size: 2em;
            transition: .5s;
        }

        a {
            color: black;
            text-decoration: none;
        }

        #temp, .submit {
            display: none;
        }
    </style>
</head>

<body>
<form method="post">
    <input type="submit" id="temp" formaction="setting.do">
    <div class="wrapper">
        <div class="header">
            <div class="logo">
                <input type="image" src="./assets/logo.png" formaction="main.do" id="logo">
            </div>
            <div class="menu-wrapper">
                <i class="fa-solid fa-bars menu-ic"></i>
                <div class="menu">
                    <a href="./diaryList.jsp" class="menu-ic-wrapper">
                        <i class="fa-solid fa-book-bookmark"></i>
                        <p>다이어리</p>
                    </a>
                    <a href="./album.jsp" class="menu-ic-wrapper">
                        <i class="fa-solid fa-image"></i>
                        <p>앨범</p>
                    </a>
                    <a href="./setting.jsp" class="menu-ic-wrapper">
                        <i class="fa-solid fa-gear"></i>
                        <p>설정</p>
                    </a>
                </div>
            </div>
        </div>
        <div class="content-wrapper">
            <ul>
                <li><a href="./profileList.do">프로필</a></li>
                <li><a href="">정보 수정</a></li>
                <li><a href="./logout.do" id="logoutBtn">로그아웃</a></li>
                <li><a href="./delete.do">회원 탈퇴</a></li>
            </ul>
        </div>
        <div class="footer">
            <p>푸터입니다</p>
        </div>
    </div>
</form>

<script type="text/javascript">
    $('.menu-ic').click(function (e) {
        e.stopPropagation();
        $('.menu').toggle();
    });
    $(document).click(function () {
        $('.menu').hide();
    });
</script>
</body>

</html>