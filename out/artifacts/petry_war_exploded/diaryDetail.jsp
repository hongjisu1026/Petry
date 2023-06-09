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
        }

        .footer p {
            margin: 0 auto;
            text-align: center;
            font-size: 1.5em;
            color: white;
            line-height: 100px;
        }

        #temp {
            display: none;
        }


        .detail-wrapper {
            width: calc(100vw - 80px);
            height: calc(100vh - 250px);
            overflow: auto;
            padding: 30px;
        }

        .detail {
            padding: 20px 30px;
            margin: auto;
        }

        #detailTitle {
            font-size: 2em;
            margin-bottom: 20px;
            margin-left: 5px;
        }

        #detailContent {
            font-size: 1.3em;
            margin-top: 20px;
            margin-left: 5px;
        }

        .detail-img {
            height: 500px;
        }

        .img {
            width: 100%;
            height: 500px;
            text-align: center;
        }

        .img img {
            height: 500px;
            margin: auto;
        }

        .slick-arrow {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            z-index: 1;
            border: none;
            width: 50px;
            height: 50px;
            cursor: pointer;
        }

        .slick-prev {
            background: url(./assets/icon/circle-chevron-left-solid.svg) no-repeat;
            left: 10px;
        }

        .slick-next {
            background: url(./assets/icon/circle-chevron-right-solid.svg) no-repeat;
            right: 10px;
        }

        .detail i {
            position: relative;
            float: right;
            font-size: 3em;
        }

        .diary-menu-wrapper {
            position: relative;
            float: right;
        }

        .diary-menu {
            display: none;
            position: absolute;
            width: 150px;
            border: 1px solid #F2C8B0;
            padding: 20px;
            border-radius: 5px;
            right: 0;
            top: 50px;
            background-color: white;
            text-align: center;
            z-index: 999;
        }

        .submit-diary-menu {
            background-color: white;
            font-size: 1.3em;
            font-family: 'Cafe24SsurroundAir';
            color: #F2C8B0;
            padding: 5px 10px;
            text-decoration: none;
            vertical-align: middle;
        }

        .submit-diary-menu:hover {
            font-size: 1.5em;
        }

        .submit {
            display: inline-block;
            font-family: 'Cafe24SsurroundAir';
            width: 130px;
            font-size: large;
            border: solid 1px #F2C8B0;
            background-color: #fff;
            border-radius: 7px;
            margin: 10px;
            padding: 5px;
        }

        .submit:hover {
            background-color: #F2C8B0;
        }

        .popup-overlay {
            display: none;
            z-index: 1000;
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

        .confirm i {
            position: absolute;
            color: #F2C8B0;
            right: 20px;
            top: 20px;
            font-size: larger;
            cursor: pointer;
        }
    </style>
</head>

<body onload="ff(${dId}, '${diaryImg}')">
<form method="post">
    <div class="wrapper">
        <div class="header">
            <div class="logo">
                <input type="image" id="logo" src="./assets/logo.png" formaction="main.do">
            </div>

            <div class="menu-wrapper">
                <i class="fa-solid fa-bars menu-ic"><a href="#menu"></a></i>
                <div class="overlay" id="menu">
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
        </div>
        <div class="detail-wrapper">
            <div class="detail">
                <div class="diary-menu-wrapper">
                    <i class="fa-solid fa-ellipsis"></i>
                    <div class="diary-menu" id="diaryMenu">
                        <a id="edit" href="javascript:void(0)" class="submit-diary-menu">수정</a>
                        <a href="#confirm" class="submit-diary-menu">삭제</a>
                    </div>
                </div>
                <p id="detailTitle">${dTitle}</p>
                <div class="img-wrapper">
                    <div class="detail-img">

                    </div>
                </div>
                <p id="detailContent">${dContent}</p>
            </div>
        </div>
        <div class="popup-overlay" id="confirm">
            <div class="confirm">
                <i class="fa-solid fa-xmark"></i>
                <p>정말 삭제하시겠습니까?</p>
                <a class="submit" id="delete">예</a>
                <input type="button" value="아니오" id="no" class="submit">
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



    $(document).on("click", ".submit-diary-menu", function () {
        const target = $(this).attr("href");
        $(target).addClass('show');
    });

    $('#no').click(function () {
        $('.popup-overlay').removeClass('show');
    });
    

    function ff(dId, diaryImg) {
        document.getElementById('edit').href = "./moveEditDiary.do?dId=" + dId;
        document.getElementById('delete').href = "./deleteDiary.do?dId=" + dId;

        let list = diaryImg.split(" ");
        let html = '';
        for (let i = 0; i < list.length - 1; i++) {
            html += '<div class=\"img\"><img src=\"/LoadDiaryImageCommand?dId=' + dId +'&aName=' + list[i] + '\"></div>';
        }

        $('.detail-img').html(html);

        $('.detail-img').slick({
            arrows: true,
            prevArrow: "<button type='button' class='slick-prev'>&nbsp;</button>",
            nextArrow: "<button type='button' class='slick-next'>&nbsp;</button>",
        });
    }
    
</script>
</body>

</html>