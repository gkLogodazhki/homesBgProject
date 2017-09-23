<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href = "CSS/LoginPage.css?1">
<title>Login</title>
</head>
<body>
	<div id="header">
		<div class = "linesAboveDomainTabs">
			<div class = "redLine"></div>
			<div class = "blackLine"></div>
		</div>
		<div class = "domainTabs">
			<a class = "apartment" href = "#">
			Апартаменти
			</a>
			<a class = "house commonOptionsProperties" href = "#">
			Къщи
			</a>
			<a class = "land commonOptionsProperties" href="#">
			Земя
			</a>
			<div class = "empty"></div>
			<a class = "office commonOptionsProperties" href= "#">
			<img src="../Images/buildings-white.jpg" class="img" alt="buildings" width="20%" height="70%">
			Офиси и бизнес имоти
			</a>
		</div>
		
		<h2 class="apartmentInfo">Апартаменти</h2>
		
		
		<div class = "bottomMenu">
			<a class = "field" href = "#">Начало</a>
			<a class = "field agency" href = "#">Агенции</a>
			<a class = "field" href = "#">Строителни</a>
			<a class = "field" href = "#">Публикуване</a>
		</div>
		
		
	</div>
		
	
	
	<div id = "enterAndRegisterSection">
	
		<h1 class = "enterAndRegisterText">Вход/Регистрация</h1>
		
		<div class = "yesllowText">
			<p style= "font-size: 80%">В случай че имате акаунт в -----------, можете да използвате Вашето потребителско име и парола и за -------.</p>
		</div>
		
		
		<b class = "registrationText">Регистрация</b>
		<div class = "goToRegister">
			<p style = "font-size: 70%">Регистрацията и публикуването на обяви от агенции и строителни фирми в ------- е безплатно.</p>
			
			<a style="color:black;font-size: 90%;" href="../Registration/RegistrationAgency.jsp">Регистрация</a>
		</div>
		
		
		<div class="enterField">
			<b >Вход</b>
			<div class="innerEnterField">
				<form action="../LogUser" method="post">
					<p>Email:<p>
					<input type="text" name = "email" required>
					<p>Парола:</p>
					<input type="password" name = "password" pattern=".{6,}" required title="минимум 6 символа">
					<input class = "submitButton" type="submit" value="Вход" name = "submit" required>
				</form>
			</div>
		</div>
		
		<div class="straightLine"></div>
	</div>
	


</body>
</html>