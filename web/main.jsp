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
            width: calc(100vw);
            min-height: calc(100vh - 100px);
        }

        .header {
            position: relative;
            width: 100%;
            height: 80px;
        }

        .wrapper {
            min-height: calc(100vh - 100px);
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

        .content-wrapper {
            padding-top: 50px;
        }

        .profile-wrapper {
            text-align: center;
            padding: 20px;
            max-width: 1255px;
            margin: auto;
        }

        .profile,
        .more,
        .x {
            vertical-align: top;
            width: 200px;
            height: 230px;
            display: inline-block;
            margin: 50px;
            font-size: large;
        }

        .profile img {
            border-radius: 100%;
            width: 200px;
            height: 200px;
            margin-bottom: 10px;
        }

        .more,
        .x {
            display: none;
            position: relative;
            cursor: pointer;
        }

        .more i,
        .x i {
            font-size: 4em;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        .img-wrapper {
            padding: 30px 0;
            margin-top: 70px;
        }

        .img {
            background-color: #ccc;
            width: 300px;
            height: 300px;
            margin: 10px;
        }

        .img img {
            width: 300px;
            height: 300px;
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
            left: 30px;
        }

        .slick-next {
            background: url(./assets/icon/circle-chevron-right-solid.svg) no-repeat;
            right: 30px;
        }

        #current {
            display: none;
        }
    </style>
</head>

<body>
<div class="wrapper">
    <div class="header">
        <div class="logo">
            <input type="image" src="./assets/logo.png" formaction="main.do" id="logo">
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
    <div class="content-wrapper">
        <form action="main.do" method="post" id="form">
            <div class="profile-wrapper">
                <c:forEach var="profileImg" items="${profileImg}" varStatus="status">
                    <c:forEach var="profile" items="${profile}" begin="${status.index}" end="${status.index}">
                        <div class="profile">
                            <img src="/LoadProfileImageCommand?piId=${profileImg.piId}">
                            <p>${profile.pName} ${profile.pSex}</p>
                        </div>
                    </c:forEach>
                </c:forEach>
                <div class="more" onclick="showMore()">
                    <i class="fa-solid fa-ellipsis"></i>
                </div>
                <div class="x" onclick="hideMore()">
                    <i class="fa-solid fa-xmark"></i>
                </div>
            </div>
        </form>
        <div class="img-wrapper">
            <div class="center">
                <c:forEach var="current" items="${current}">
                    <div class="img">
                        <img src="/LoadCurrentCommand?aName=${current}">
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <p>ⓒ petry</p>
</div>
<script type="text/javascript">
    (() => {
        hideMore();
    })();

    $('.menu-ic').click(function (e) {
        e.stopPropagation();
        $('.menu').toggle();
    });
    $(document).click(function () {
        $('.menu').hide();
    });

    function start() {
        document.getElementById("form").submit();
    }

    function hideMore() {
        const count = $('.profile').length;
        const more = document.getElementsByClassName('more')[0];
        const x = document.getElementsByClassName('x')[0];

        if (count >= 4) {
            more.style.display = "inline-block";
            x.style.display = 'none';
            for (let i = 3; i < count; i++) {
                document.getElementsByClassName('profile')[i].style.display = "none";
            }
        }
    }

    function showMore() {
        const count = $('.profile').length;
        const more = document.getElementsByClassName('more')[0];
        const x = document.getElementsByClassName('x')[0];

        more.style.display = "none";
        x.style.display = 'inline-block';

        for (let i = 3; i < count; i++) {
            document.getElementsByClassName('profile')[i].style.display = "inline-block";
        }
    }

    $(document).ready(function () {
        $('.center').slick({
            centerMode: true,
            centerPadding: '50px',
            autoplay: true,
            autoplayspeed: 10000,
            pauseOnHover: true,
            arrows: true,
            variableWidth: true,
            prevArrow: "<button type='button' class='slick-prev'>&nbsp;</button>",
            nextArrow: "<button type='button' class='slick-next'>&nbsp;</button>"
        });
    });

    // function currentImg() {
    //     let list = $('#current').val();
    //     console.log(list);
    //     list = list.split(" ");
    //     for (let i = 0; i < list.length; i++) {
    //         console.log(list[i]);
    //     }
    // }
    //
    // (() => {
    //     currentImg();
    // })();

    // (() => {
    //     $('#temp').submit();
    //     console.log('.do 실행');
    // })();


</script>
</body>

</html>