<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "../Registration/CSS/Registration.css?22312">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Публикувай обява</title>
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
			<a class = "field" href = "../Login/LoginPage.jsp">Начало</a>
			<a class = "field agency" href = "#">Агенции</a>
			<a class = "field" href = "#">Строителни</a>
			<a class = "field" href = "#">Публикуване</a>
		</div>
	</div>
	
	<div id="middleText">
		<div class = "regTitle">
			Публикуване на обява
		</div>
		<div class="warningImg">
			<img class="warning" src="../Images/warnings_sign.jpg" alt="Warning" width="51px" height="46px">
		</div>
		<p><strong>Тази секция е предназначена за публикуване на обяви само от частни лица или юридически лица собственици на имота. </strong>
		</p>
	</div>
	
	
	
	<div id="registerSection">
		<form action="../Registration" method = "post">
			
			<p class="beforeSectionData">Данни за обявата</p>
			<div class = "agencyData">
			
				<div class= "textArea firstDataInAgencySection">
					<b>Публикуване:</b>
				</div>
				<div class="mainOptions">
					<input class="inputPageType" type="radio" name="adType" value="1"
						checked>
					<p class="pPageType">За продажба</p>
					<input class="inputPageType" type="radio" name="adType" value="2">
					<p class="pPageType">Под наем</p>


					<div class="gogataOptions">
						<b>Тип имот:</b>
					</div>
					<div class="gogataOptions2">

						<div>
							<p class="pPageType">Апартамент</p>
							<input class="inputGogataType" type="radio" name="estateType"
								value="1" checked>
						</div>
						<div>
							<p class="pPageType">Къща</p>
							<input class="inputGogataType2" type="radio" name="estateType"
								value="2" >
						</div>
						<div>
							<p class="pPageType">Парцел</p>
							<input class="inputGogataType3" type="radio" name="estateType"
								value="3" >
						</div>
						<div>
							<p class="pPageType">Земя</p>
							<input class="inputGogataType4" type="radio" name="estateType"
								value="4" >
						</div>

					</div>
				</div>



				<div class="straightLine"></div>
				
				
				<div class= "textArea companyName">
						<b>Цена:</b>
				</div>
				
				<div class="companyNameInputArea">
					<input class="inputData" type="text" name="companyName" required>
				</div>
				
				<div class = "textArea companyAddress">
						<b>Допълнителна информация:</b>
				</div>
				
				<div class="companyAddressInputArea">
					<textarea style="width: 96%; text-align:left;" name="companyAddress" rows="5" cols="30"required>
					</textarea>
				</div>
				
				<div class= "textArea MOL">
						<b>Вид на имота: </b>
				</div>
				
				<div class="companyMOLInputArea">
					<input class="inputData" type="text" name="MOL" required>
				</div>
				
				<div class= "textArea EIK">
						<b>Обзавеждане: </b>
				</div>
				<div class="companyEIKInputArea">
					<input class="inputData" type="text" name="EIK" required>
				</div>
				
				<div class= "textArea administrativeContact">
						<b>Година на построяване: </b>
				</div>
				<div class="companyAdministrativeContactInputArea">
					<input class="inputData" type="text" name="administrativeContact" required>
				</div>
				
				
				<div class= "textArea duty">
						<b>Позволени ли са домашни любимци:</b>
				</div>
				<div class="companyDutyInputArea">
					<input class="inputData" type="text" name="companyDuty" required>
				</div>
			
				
				<div class= "textArea phoneNumber">
						<b>Вид строителство: </b>
				</div>
				<div class="companyPhoneNumberInputArea ">
					<input class="inputData" type="text" name="phoneNumber" required>
				</div>
				
				<div class= "textArea administrativeContactEmail">
						<b>Брой етажи: </b>
				</div>
				<div class="companyAdministrativeContactEmailInputArea ">
					<input class="inputData" type="text" name="administrativeContactEmail" required>
				</div>
				
			</div>
			
			<p class="beforeSectionData beforeContactData">Данни за контакт</p>
			
			<div class="contactData">
				
				<p style="font-size:75%; margin-left:3%; margin-top:2%;">
				Тези данни се публикуват като част от офертите на агенцията и служат за контакт от страна на купувачите/наемателите с агенцията</p>
				
				
				<div class="contactDataName">
				<span class = "redStar">*</span>
						<b>Име на агенцията:</b>
						<input class="contactInputData" type="text" name="agencyName" required>
				</div>
				
				<div class="contactDataCountry">
				<span class = "redStar">*</span>
						<b>Държава:</b>
						<select class="selectCountry" name="contactCountry" >
							<option value="1">България</option>
							<option value="2">Сърбия</option>
							<option value="3">Румъния</option>
							<option value="4">Гърция</option>
							<option value="5">Македония</option>
						</select>
				</div>
				
				
				
				<div class="contactDataArea">
				<span class = "redStar">*</span>
						<b>Област:</b>
						<input class="areaInputData" type="text" name="contactArea" required>
				</div>
					
				
				<div class="contactDataLivingArea">
					<span class = "redStar">*</span>
					<b>Населено място:</b>
					<input class="livingAreaInputData" type="text" name="contactLivingArea" required>
				</div>
				
				<div class = "contactDataAddress">
					<div>
						<span class = "redStar">*</span>
						<b>Адрес:</b>
					</div>
					<textarea class="addressInputData" name="contactAddress" rows="5" cols="30" required>
					</textarea> 
				</div>
				
				<div class="contactDataPhone">
					<span class = "redStar">*</span>
					<b>Телефон:</b>
					<input class="phoneInputData" type="text" name="contactPhone" required>
				</div>
				
				<div class="contactDataWebSite">
					<b>Уеб сайт:</b>
					<input class="webSiteInputData" type="text" name="contactWebSite">
				</div>
				
			</div>
			
			<p class="beforeSectionData beforePageData">Страница на агенцията в -------</p>
			<div id ="page">
				<p class="pageText">Тази страница съдържа всички оферти, публикувани от агенцията в -------. Адресът на страницата се показва във визитката на агенцията под всяка оферта. Препоръчително е името на страницата да съвпада с името на агенцията. Желаното име се изписва с малки букви на латиница, без интервали.</p>
			
				<div class="pageData">
					<span class = "redStar">*</span>
					<b>Желанo име на страница:</b>
					<input class="pageInputData" type="text" name="pageName" required>
				</div>
			</div>
			
			<p class="beforeSectionData beforeCustomerData">Данни за потребителя</p>
			<div id = "customerData" >
				<p style="margin-top: 2%; margin-left:2%; margin-bottom:0;font-size:75%;">Този потребител ще има администраторски права. С него ще можете:</p>
				<p class="customerText">- да редактирате данните за Вашата агенция</p>
				<p class="customerText">- да добавяте/изтривате допълнителни потребители (брокери) с права за публикуване на обяви към акаунта на агенцията</p>
				<p class="customerText">да публикувате/разглеждате/редактирате обяви публикувани от Вас и/или други потребители (брокери)</p>
			
				<div class="customerEmail">
					<span class = "redStar">*</span>
					<b>Email:</b>
					<input class="customerEmailInput" type="text" name="customerEmail" required>
					<p style="margin:0;font-size:60%; position:relative; left:11%;">(Този Email служи като потребителско име.)</p>
				</div>
			
				<div class="customerPassword">
					<span class = "redStar">*</span>
					<b>Парола:</b>
					<input class="customerPasswordInput" type="password" name="password" pattern=".{6,}" required>
					<p style="margin:0;font-size:60%; position:relative; left:11%;">(Паролата не трябва да е по-малка от 6 символа.)</p>
				</div>
			
				<div class="customerRepeatePassword">
					<span class = "redStar">*</span>
					<b>Парола (повтори):</b>
					<input class="customerRepeatePasswordInput" type="password" name="repeatedPassword" pattern=".{6,}" required>
				</div>
			
				<div class="customerFName">
					<span class = "redStar">*</span>
					<b>Име:</b>
					<input class="customerFNameInput" type="text" name="fName"  required>
				</div>
				
				
				<div class="customerLName">
					<span class = "redStar">*</span>
					<b>Фамилия:</b>
					<input class="customerLNameInput" type="text" name="lName"  required>
				</div>
				
				<div class="customerDuty">
					<span class = "redStar">*</span>
					<b>Длъжност:</b>
					<input class="customerDutyInput" type="text" name="customerDuty"  required>
				</div>
				
				<div class="customerPhone">
					<span class = "redStar">*</span>
					<b>Телефон:</b>
					<input class="customerPhoneInput" type="text" name="customerPhone"  required>
				</div>
				
				
				<div class="customerSkype">
					<b>Skype:</b>
					<input class="customerSkypeInput" type="text" name="skype" >
				</div>
				
				<div class = "customerAdditionalInfo">
					<div>
						<b>Допълнителна информация:</b>
					</div>
					<textarea class="customerAdditionalInfoInput" name="additionalInfo" rows="5" cols="30" >
					</textarea> 
					<p style="margin:0;font-size:65%; position:relative; left:15%;">Тук може да въведете кратка информация за вас, която ще се показва под вашата снимка и телефони</p>
				</div>
				
				<div class="finalOptions">
					<div class="onlyAdministratorOption">
						<b>Допълнителна информация:</b>
						<input style="padding-left:5px;" type="radio" checked name="accountUsage" value="1">
						<span style="font-size: 80%;">само като администратор</span>
					</div>
					<div class="administratorAndBrokerOption">
						<input type="radio" name="accountUsage" value="2">
						<span style="font-size: 80%;">като администратор и брокер</span>
					</div>
					<p style="font-size:58%;">(Ако използвате този потребител като брокер, въведените данни съставят вашата визитка, която се публикува под вашите оферти)</p>
				</div>
				
				<div class="endLine"></div>	
				<input id="submitData" type="submit" name="submit" value="Регистрирай">
			</div>
			
		</form>
		
	</div>
</body>
</html>