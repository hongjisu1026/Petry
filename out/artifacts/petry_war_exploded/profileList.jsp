<%@ page import="java.util.ArrayList" %>
<%@ page import="com.petry.profile.dto.ProfileImgDTO" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

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
            min-height: 100vh;
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

        .logo a {
            text-decoration: none;
            color: #F2C8B0;
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

        img {
            width: 200px;
            height: 200px;
            border-radius: 50%;
            margin-right: 30px;
        }

        .content-wrapper {
            padding: 50px;
        }

        .profiles {
            width: max-content;
            max-width: 1300px;
            margin: auto;
            padding-top: 50px;
        }

        .profile-wrapper {
            position: relative;
            display: inline-block;
            width: 550px;
            margin-bottom: 100px;
        }

        .profile-wrapper:nth-child(even) {
            margin-left: 195px;
        }

        .profile-wrapper img, .p-wrapper {
            display: inline-block;
            vertical-align: middle;
        }

        .p-wrapper p {
            margin-bottom: 10px;
            font-size: large;
        }

        .p-wrapper p:first-child, .p-wrapper p:nth-child(2) {
            display: inline-block;
            margin-right: 5px;
        }

        .fa-pen {
            position: absolute;
            right: 0;
            font-size: 1.5em;
            padding: 20px 10px;
            cursor: pointer;
        }

        .fa-plus {
            font-size: 2em;
            float: right;
            cursor: pointer;
        }
        
    </style>
</head>

<body>
    <form action="profileList.do" method="post">
        <div class="wrapper">
            <div class="header">
                <div class="logo">
                    <a href="./main.jsp">로고</a>
                </div>
                <div class="menu-wrapper">
                    <i class="fa-solid fa-bars menu-ic"></i>
                    <div class="menu">
                        <a href="./diary.jsp" class="menu-ic-wrapper">
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
                <a href="./profile.jsp"><i class="fa-solid fa-plus"></i></a>
                <div class="profiles">
                    <c:forEach var="profileImg" items="${profileImg}" varStatus="status">
                        <c:forEach var="profile" items="${profile}" begin="${status.index}" end="${status.index}">
                            <div class="profile-wrapper">
                                <img class="pImg" src="./assets/images/profile/${profileImg.piName}">

                                <div class="p-wrapper">
                                    <p class="pName">${profile.pName}</p>
                                    <p class="pSex">${profile.pSex}</p>
                                    <p class="pBirth">${profile.pBirth}</p>
                                </div>
                                <a href="./profile.jsp?pId=${profile.pId}&piId=${profileImg.piId}"><i class="fa-solid fa-pen"></i></a>
                            </div>
                        </c:forEach>
                    </c:forEach>
                </div>
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