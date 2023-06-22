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
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
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
            width: calc(100vw - 17px);
            min-height: calc(100vh - 100px);
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
            position: absolute;
            right: 0;
        }

        .menu-ic {
            margin: 25px;
            display: inline-block;
            font-size: 2em;
            color: #F2C8B0;
        }

        .menu-ic a {
            text-decoration: none;
        }

        .logo {
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

        i {
            color: #F2C8B0;
            font-size: 2em;
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
            position: relative;
            transform: translateY(747%);
        }

        #temp {
            display: none;
        }

        #writeBtn {
            float: right;
            margin: 20px;
            text-decoration: none;
            color: black;
            border: 1px solid #F2C8B0;
            width: 70px;
            text-align: center;
            padding: 10px 15px;
            border-radius: 10px;
        }

        #writeBtn:hover {
            background-color: #F2C8B0;
        }

        .diary-wrapper {
            width: calc(50% - 100px);
            float: left;
            overflow: auto;
            height: calc(100vh - 220px);
            padding: 20px 50px;
        }

        .diary-img {
            width: 150px;
            height: 150px;
        }
        .diary-img, .diary-content-wrapper {
            display: inline-block;
            vertical-align: top;
        }
        
        .diary-content-wrapper {
            margin-left: 10px;
        }

        .diary-title {
            font-size: 1.7em;
            margin-bottom: 15px;
        }

        .diary-title a {
            text-decoration: none;
            color: black;
            cursor: pointer;
        }

        .diary-title a:hover {
            color: #F2C8B0;
            text-decoration: underline;
        }

        .diary-content {
            font-size: 1.3em;
        }

        .diary {
            margin-top: 30px;
        }

        .wrapper, .footer {
            display: block;
        }



    </style>
</head>

<body>
<form method="post">
    <input type="submit" id="temp" formaction="diaryList.do">
    <div class="wrapper">
        <div class="header">
            <div class="logo">
                <input type="image" id="logo" src="./assets/logo.png" formaction="main.do">
            </div>

            <div class="menu-wrapper">
                <i class="fa-solid fa-bars menu-ic"><a href="#menu"></a></i>
                <div class="overlay" id="menu">
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
        </div>
        <a id="writeBtn" href="./diary.jsp">글쓰기</a>
        <div class="diary-wrapper">
            <c:forEach var="diary" items="${diary}" varStatus="status">
                <c:forEach var="thumbnail" items="${thumbnail}" begin="${status.index}" end="${status.index}">
                    <div class="diary">
                        <img class="diary-img" src="./assets/images/album/${thumbnail}">
                        <div class="diary-content-wrapper">
                            <p class="diary-title">
                                <a href="javascript:void(0)" onclick="ff(${diary.dId})">${diary.dTitle}</a>
                            </p>
                            <p class="diary-content">${diary.dContent}</p>
                        </div>
                    </div>
                </c:forEach>
            </c:forEach>
            
        </div>
        <div class="detail-wrapper">
            
        </div>
    <div class="footer">
        <p>푸터입니다</p>
    </div>
    </div>
</form>
<script type="text/javascript">
    

    $('.fa-ellipsis').click(function (e) {
        e.stopPropagation();
        $('.diary-menu').toggle();
    });

    $(document).click(function () {
        $('.diary-menu').hide();
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

    

    function ff(dId) {
        sessionStorage.setItem("dId", dId);
        $('.detail-wrapper').load('diaryDetail.jsp');
    }

    
</script>
</body>

</html>