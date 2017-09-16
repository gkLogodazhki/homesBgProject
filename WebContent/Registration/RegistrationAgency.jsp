<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href = "CSS/Registration.css?1">
<link >
<title>HOMES.bg - Имоти - апартаменти, къщи, парцели, земеделски земи.</title>
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
			<img src="CSS/Images/buildings-white.jpg" class="img" alt="buildings" width="20%" height="70%">
			Офиси и бизнес имоти
			</a>
		</div>
		
		<h2 class="apartmentInfo">Апартаменти</h2>
		<div class = "logo"></div>
		
		<div class = "bottomMenu">
			<a class = "field" href = "#">Начало</a>
			<a class = "field agency" href = "#">Агенции</a>
			<a class = "field" href = "#">Строителни</a>
			<a class = "field" href = "#">Публикуване</a>
		</div>
	</div>
	
	<div id="middleText">
		<div class = "regTitle">
			Регистрация на агенция за недвижими имоти
		</div>
		<div class="warningImg">
			<img class="warning" src="CSS/Images/warnings_sign.jpg" alt="Warning" width="51px" height="46px">
		</div>
		<p>В случай че имате акаунт в <strong>OfficeSpace.bg</strong>, можете да използвате Вашето потребителско име и парола и за 
			<strong>HOMES.bg</strong>.

			Регистрацията и публикуването на обяви от агенции и строителни фирми в homes.bg е безплатно. 

			В случай че Ви е необходима помощ или допълнителна информация, не се колебайте да се свържете с нас:</p>
	
		<div class="phoneGif">
			<img class="phone" src="CSS/Images/phone.gif" alt="phone" width="20px" height="16px">
			02 439 22 28
		</div>
	</div>
	
	
	
	<div id="registerSection">
		<form action="../RegisterMain" method = "post">
			
			<p class="beforeSectionData">Данни за агенцията</p>
			<div class = "agencyData">
			
				<div class= "textArea firstDataInAgencySection">
					<span class = "redStar">*</span>
					<b>Фирмата е:</b>
				</div>
				<div class = "mainOptions">
					<input class="inputPageType" type="radio" name="pageType" value = "1" checked> 
					<p class="pPageType">Агенция за недвижими имоти</p>
					<input class="inputPageType"  type="radio" name="pageType" value = "2">
					<p class="pPageType">Строителна фирма</p> 
				</div>
				
				
				<div class="straightLine"></div>
				
			</div>
			<input type="submit" value="Регистрация" name = "submit" style="position: absolute;">
			
		</form>
	</div>
	
	
</body>
</html>