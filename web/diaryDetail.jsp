<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .detail-wrapper {
            width: 50%;
            float: right;
            height: calc(100vh - 220px);
            overflow: auto;
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
            height: 300px;
        }

        .img {
            width: 100%;
            height: 300px;
            text-align: center;
        }

        .img img {
            height: 300px;
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
<body>
<form action="diaryDetail.do" method="post" id="form">
    <input type="hidden" id="dId" name="dId">
        <div class="detail-wrapper">
            <div class="detail">
                <div class="diary-menu-wrapper">
                    <i class="fa-solid fa-ellipsis"></i>
                    <div class="diary-menu" id="diaryMenu">
                        <a href="./updateDiary.do" class="submit-diary-menu">수정</a>
                        <a href="#confirm" class="submit-diary-menu">삭제</a>
                    </div>
                </div>
                <p id="detailTitle">${dContent}</p>
                <div class="img-wrapper">
                    <div class="detail-img">
                        <c:forEach var="album" items="${album}">
                            <div class="img"><img src="./assets/images/album/${album}"></div>
                        </c:forEach>
                    </div>
                </div>
                <p id="detailContent">${dContent}</p>
            </div>
        </div>
        <div class="popup-overlay" id="confirm">
            <div class="confirm">
                <i class="fa-solid fa-xmark"></i>
                <p>정말 삭제하시겠습니까?</p>
                <input type="submit" value="예" class="submit" id="yes" formaction="deleteDiary.do">
                <input type="button" value="아니오" id="no" class="submit">
            </div>
        </div>
</form>
<script>

    $(document).ready(function () {
        $('.detail-img').slick({
            arrows: true,
            prevArrow: "<button type='button' class='slick-prev'>&nbsp;</button>",
            nextArrow: "<button type='button' class='slick-next'>&nbsp;</button>",
        });

    });

    $(document).on("click", ".submit-diary-menu", function () {
        const target = $(this).attr("href");
        $(target).addClass('show');
    });

    $('#no').click(function () {
        $('.popup-overlay').removeClass('show');
    });

    function start() {
        let dId = sessionStorage.getItem("dId");

        $('#dId').val(dId);
        $('#form').submit();
    }

    (() => {
        start();
    })();
</script>
</body>
</html>