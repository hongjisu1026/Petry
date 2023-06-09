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
    <link rel="icon" href="./assets/favicon.png">
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
            width: 100vw;
            height: calc(100vh - 100px);
        }

        .header {
            position: relative;
            width: 100%;
            height: 80px;
        }

        .wrapper {
            height: calc(100vh - 100px);
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
            background-color: white;
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
            width: 100%;
            height: 100px;
            background-color: #ccc;
        }

        .footer p {
            margin: 0 auto;
            text-align: center;
            font-size: 1.5em;
            color: white;
            line-height: 100px;
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

        #temp {
            display: none;
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
            width: 150px;
            border: solid 1px #F2C8B0;
            background-color: #fff;
            border-radius: 7px;
            margin: auto;
            display: inline-block;
            cursor: pointer;
        }

        .submit:hover {
            background-color: #F2C8B0;
        }

        .popup-overlay {
            display: none;
            z-index: 10000;
            width: 100vw;
            height: 100vh;
            position: absolute;
            top: 0;
            background-color: rgba(0, 0, 0, 0.7);
        }

        .popup-overlay.show {
            display: block;
        }

        .confirm {
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

        .confirm p {
            margin-bottom: 20px;
            color: #F2C8B0;
            font-size: 1.5em;
        }

        #edit input {
            margin: auto;
        }

        #edit input[type="submit"] {
            width: 305px;
            margin: 10px;
        }

        .fa-xmark {
            position: absolute;
            right: 30px;
            top: 30px;
            cursor: pointer;
        }
    </style>
</head>

<body>
<form method="post">
    <input type="submit" id="temp">
    <div class="wrapper">
        <div class="header">
            <div class="logo">
                <input type="image" src="./assets/logo.png" formaction="main.do" id="logo">
            </div>
            <div class="menu-wrapper">
                <i class="fa-solid fa-bars menu-ic"></i>
                <div class="menu">
                    <a href="./diaryList.do" class="menu-ic-wrapper">
                        <i class="fa-solid fa-book-bookmark"></i>
                        <p>다이어리</p>
                    </a>
                    <a href="./album.do" class="menu-ic-wrapper">
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
                <li><a onclick="editPopup()">정보 수정</a></li>
                <li><a href="./logout.do" id="logoutBtn">로그아웃</a></li>
                <li><a href="#delete" onclick="deletePopup()">회원 탈퇴</a></li>
            </ul>
        </div>
        <div class="popup-overlay" id="delete">
            <div class="confirm">
                <p>정말 탈퇴하시겠습니까?</p>
                <input type="submit" id="deleteBtn" class="submit" formaction="delete.do" value="예">
                <input type="button" value="아니오" id="no" class="submit">
            </div>
        </div>
        <div class="popup-overlay" id="edit">
            <div class="confirm">
                <p>비밀번호 확인</p>
                <i class="fa-solid fa-xmark"></i>
                <input type="password" id="check_pwd" name="check_pwd" placeholder="비밀번호 입력">
                <input type="submit" class="submit" value="확인" formaction="moveEdit.do">
            </div>
        </div>
    </div>
    <div class="footer">
        <p>ⓒ petry</p>
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

    function deletePopup() {
        $('#delete').addClass('show');
    }

    function editPopup() {
        $('#edit').addClass('show');
    }

    $('#no').click(function () {
        $('.popup-overlay').removeClass('show');
    });

    $('.fa-xmark').click(function () {
        $('.popup-overlay').removeClass('show');
    });

    $(document).mouseup(function (e) {
        const overlay = $('.popup-overlay');
        if (overlay.has(e.target).length === 0) {
            overlay.removeClass('show');
        }
    });
</script>
</body>

</html>