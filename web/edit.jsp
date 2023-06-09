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
            position: relative;
            width: calc(100vw - 19px);
            height: 100vh;
            margin: 0;
        }

        .wrapper {
            position: absolute;
            border-radius: 10px;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            border: solid 3px #F2C8B0;
            padding: 20px 70px;
        }

        tr {
            display: block;
            margin: 50px;
        }

        input {
            margin-top: 10px;
            border: solid 1px #bbb;
            border-radius: 5px;
            padding-left: 10px;
            width: 290px;
            height: 30px;
        }

        input:focus {
            outline: none;
            border-color: #F2C8B0;
        }

        .check {
            font-size: small;
            margin-top: 5px;
            margin-left: 3px;
            color: #f89090;
            width: 290px;
        }

        #submit {
            border: solid 1px #F2C8B0;
            border-radius: 8px;
            background-color: #fff;
            height: 35px;
            width: 305px;
            margin-top: 0;
        }

        #submit:hover {
            background-color: #F2C8B0;
        }

        #logo {
            border: none;
            width: 100px;
        }

        .enterd {
            width: 300px;
            border: #bbb 1px solid;
            height: 32px;
            border-radius: 6px;
            margin-top: 10px;
        }

        .enterd p {
            margin: 10px;
            font-size: 0.8em;
            cursor: default;
        }
    </style>
</head>

<body>
<form action="edit.do" method="post" id="form">
    <div class="wrapper">
        <input type="image" id="logo" src="./assets/logo.png">
        <div class="table-wrapper">
            <table>
                <tr>
                    <td><label>아이디</label><br>
                        <div class="enterd"><p id="id">${id}</p></div>
                    </td>
                </tr>
                <tr>
                    <td><label for="pwd">비밀번호</label><br>
                        <input type="password" id="pwd" name="pwd" class="item" data-name="비밀번호" value="${pwd}" onkeyup="validationPwd()">
                        <p class="check" id="p_text"></p>
                    </td>
                </tr>
                <tr>
                    <td><label for="ch_pwd">비밀번호 확인</label><br>
                        <input type="password" id="ch_pwd" name="ch_pwd" class="item" data-name="비밀번호 확인" value="${pwd}" onkeyup="checkPwd()">
                        <p class="check" id="c_text"></p>
                    </td>
                </tr>
                <tr>
                    <td><label for="email">이메일</label><br>
                        <div class="enterd"><p id="email">${email}</p></div>
                    </td>
                </tr>
                <tr>
                    <td><label for="name">이름</label><br>
                        <input type="text" id="name" name="name" class="item" data-name="이름" value="${name}">
                    </td>
                </tr>
                <tr>
                    <td><label>생년월일 8자리</label><br>
                        <div class="enterd"><p id="birth">${birth}</p></div>
                    </td>
                </tr>
                <tr>
                    <td><label for="nickname">닉네임</label><br>
                        <input type="text" id="nickname" name="nickname" class="item" data-name="닉네임" value="${nickname}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="수정하기" id="submit">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>

<script type="text/javascript">
    (() => {
        checkPwd();
        validationPwd();
    })();

    function checkPwd() {
        const pwd = document.getElementById("pwd").value;
        const ch_pwd = document.getElementById("ch_pwd").value;
        const text = document.getElementById("c_text");

        if (pwd.length !== 0 || ch_pwd.length !== 0) {
            if (pwd === ch_pwd) {
                text.innerHTML = "";
            } else {
                text.innerHTML = "비밀번호가 일치하지 않습니다.";
            }
        } else {
            text.innerHTML = "비밀번호를 입력해주세요.";
        }
    }

    function validationPwd() {
        const pwd = document.getElementById("pwd").value;
        const text = document.getElementById("p_text");
        const reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
        if (pwd.length !== 0) {
            if (!reg.test(pwd)) {
                text.innerHTML = '8~16자 영문자, 숫자 및 특수 문자가 포함되어야 합니다.';
            } else if (reg.test(pwd)) {
                text.innerHTML = "";
            }
        } else {
            text.innerHTML = "비밀번호를 입력해주세요.";
        }
    }

    $(function () {
        $("#submit").click(function () {
            let isRight = true;
            $("#form").find($('.item')).each(function (index, item) {
                if ($(this).val().trim() == "") {
                    alert($(this).attr("data-name") + "을/를 입력하세요.");
                    isRight = false;
                    return false;
                }
            });

            if ($('#pwd').val() !== $('#ch_pwd').val()) {
                alert('비밀번호가 일치하지 않습니다.');
                isRight = false;
                return false;
            }

            console.log(isRight);
            if (!isRight) {
                return false;
            }
        });
    });

</script>
</body>

</html>