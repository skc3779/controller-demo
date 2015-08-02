<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="//cdn.axisj.com/axisj/ui/bulldog/AXJ.min.css" />
    <script type="text/javascript" src="//cdn.axisj.com/axisj/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="//cdn.axisj.com/axisj/dist/AXJ.min.js"></script>
    <script>

        $.ajaxSetup({
            contentType: "application/json; charset=utf-8",
            dataType:"json"
        });

        function three() {
            var url = "/controller/threewelcome/three.do?name=abc";
            var data = {
                col1:"data1",
                col2:"data2",
                arrCol1:[
                    {col1:"한글1", col2:"data1"},
                    {col1:"한글2", col2:"data2"}
                ]
            };
            $.post(url, data).done(function(result) {
                if (result.ok == true) {
                    AXUtil.alert("저장되었습니다.");
                } else {
                    AXUtil.alert(result.message);
                }
            })
            .fail(function(result) {
                trace(result.status, result.statusText);
            });
        }
        function two() {
        }
    </script>
</head>
<body>

<h1>Spring MVC Json Example</h1>

<h2>${msg}</h2>
<br>
<button onclick="three()">three 클릭</button>
</body>
</html>