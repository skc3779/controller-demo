<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="//cdn.axisj.com/axisj/ui/bulldog/AXJ.min.css" />
    <script type="text/javascript" src="//cdn.axisj.com/axisj/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="//cdn.axisj.com/axisj/dist/AXJ.min.js"></script>
    <script>

        function jsonIn() {
            var url = "/controller/twowelcome/jsonIn.json";
            var data = {
                col1:"data1",
                col2:"data2",
                arrCol1:[
                    {col1:"data1", col2:"data1"},
                    {col1:"data2", col2:"data2"}
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

        function jsonOut() {

        }
    </script>
</head>
<body>

<h1>Spring MVC Json Example</h1>

<h2>${msg}</h2>
<br>
<button onclick="jsonIn()">jsonIn 클릭!</button> <button onclick="jsonOut()">jsonOut 클릭!</button>
</body>
</html>