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

        .wrapper {
            height: calc(100vh - 100px);
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
            width: 100%;
            height: calc(100% - 180px);
        }

        .item-wrapper {
            position: absolute;
            width: 50%;
            height: 500px;
            top: 50%;
            transform: translateY(-50%);
        }

        .item-wrapper:first-child {
            left: 0;
        }

        .item-wrapper:last-child {
            right: 0;
        }

        .inputs-wrapper {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }

        .input-wrapper {
            margin-bottom: 20px;
            font-size: larger;
        }

        .input-wrapper input {
            margin-top: 7px;
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

        .radio-wrapper {
            display: inline-block;
            width: 100px;
            position: relative;
            margin-right: 10px;
        }

        .label, .radio-wrapper input {
            display: inline-block;
            vertical-align: middle;
        }

        .label {
            margin-top: 1px;
        }

        input[type='radio'] {
            appearance: none;
            border-radius: 50%;
            width: 20px;
            height: 20px;
            margin: 0 10px 0 0;
        }

        input[type='radio']:checked {
            border: 0.4em solid #F2C8B0;
        }

        input[type='file'] {
            font-family: 'Cafe24SsurroundAir';
            padding: 5px;
            margin: auto;
            border: none;
            height: 40px;
        }

        input[type='file']::file-selector-button {
            width: 100px;
            height: 30px;
            border: 1px solid #F2C8B0;
            border-radius: 10%;
            margin-top: 4.5px;
            background-color: white;
            font-family: 'Cafe24SsurroundAir';
            float: right;
        }

        input[type='file']::file-selector-button:hover {
            background-color: #F2C8B0;
        }

        :root {
            accent-color: #F2C8B0;
        }

        .img-wrapper {
            text-align: center;
            height: 500px;
        }

        #prevImg {
            width: 500px;
            height: 500px;
            border-radius: 50%;
            border: 1px solid #F2C8B0;
        }

        .submit {
            font-family: 'Cafe24SsurroundAir';
            width: 290px;
            border: solid 1px #F2C8B0;
            background-color: #fff;
            border-radius: 7px;
            margin-top: 10px;
        }

        .submit:hover {
            background-color: #F2C8B0;
        }

        #temp {
            display: none;
        }
    </style>
</head>

<body>
    <form method="post" enctype="multipart/form-data">
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
                <div class="item-wrapper">
                    <div class="inputs-wrapper">
                        <div class="input-wrapper">
                            <label for="pName">이름</label>
                            <input type="text" name="pName" id="pName">
                        </div>
                        <div class="input-wrapper">
                            <label for="pBirth">생년월일</label>
                            <input type="text" name="pBirth" id="pBirth">
                        </div>
                        <div class="input-wrapper">
                            <div class="radio-wrapper">
                                <input type="radio" value="♂" name="pSex" id="male">
                                <label for="male" class="label">남자 ♂</label>
                            </div>
                            <div class="radio-wrapper">
                                <input type="radio" value="♀" name="pSex" id="female">
                                <label for="female" class="label">여자 ♀</label>
                            </div>
                        </div>
                        <div class="input-wrapper">
                            <input type="file" name="pImg" id="pImg" accept=".png, .jpeg, .jpg" value="">
                        </div>
                        <div class="input-wrapper">
                            <input type="submit" value="등록하기" class="submit" formaction="profile.do">
                        </div>
                    </div>
                </div>
                <div class="item-wrapper">
                    <div class="img-wrapper">
                        <img id="prevImg">
                    </div>
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

        function readImg(input) {
            if (input.files && input.files[0]) {
                const reader = new FileReader();
                reader.onload = e => {
                    document.getElementById('prevImg').src = e.target.result;
                }

                reader.readAsDataURL(input.files[0]);
            } else {
                document.getElementById('prevImg').src = '';
            }
        }

        document.getElementById('pImg').addEventListener("change", e => {
            readImg(e.target);
        });
    </script>
</body>

</html>