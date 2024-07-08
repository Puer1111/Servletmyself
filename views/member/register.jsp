<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	</head>
	<body>
		<h1>회원가입</h1>
	<h3>회원정보를 입력하세요</h3>
	<fieldset>
	<!-- http:127.0.0.1/member/join.do -->
	<!-- 주소 직접 만들어서 쓰는건 무조건 Get만 가능하다 -->
	<legend>회원가입</legend>
	<form action = "/member/join.do" method = "post">
	아이디: <input type = "text" name = "member-id"> <br>
	비밀번호: <input type = "password" name = "member-pw"> <br>
	성별: 남자 <input type = "radio" name = "gender">
	여자 <input type = "radio" name = "gender"><br>
	이름: <input type = "text" name = "member-name"><br>
	나이: <input type = "number" name = "age"><br>
	이메일: <input type = "text" name = "email"><br>
	전화번호: <input type = "text" name = "phone"><br>
	주소: <input type = "text" name ="address"><br>
	취미: <input type = "text" name = "hobby">
	<input type = "submit" value = "회원가입">
	</form>
	</fieldset>
	</body>
</html>