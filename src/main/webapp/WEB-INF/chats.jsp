<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chats</title>
<script src="https://kit.fontawesome.com/8132e3a9c0.js" crossorigin="anonymous"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="resources/css/stylesprofile.css">
  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>

	<div id="modal-message-background">
      <div id="modal-message">
      <div class="close-chat" onClick="closemsg();">+</div>
      <input type="hidden" class="form-control" id="sender" name="sender" value="${sender}" readonly>
      <input type="hidden" class="form-control" id="totalmsgs" name="totalmsgs" value="${totalmsgs}" readonly>
      <input type="hidden" class="form-control" id="receiver" name="receiver" value="${receiver}" readonly>
      <div style="position: fixed;font-size: x-large;font-weight: bold;top: 35px;">
      <div style="height: 45px;width: 45px;position: fixed;top: 30px;clip-path: circle();">
      <img id="chatdp" alt="No image available for this Post!" src="/profile/picture/${fordp}" onerror="this.src='resources/images/profileicon.png'" />
      </div><div style="height: 45px;width: 45px;position: fixed;top: 35px;left: 370px;text-transform: uppercase;">${receiver}</div></div>
     	<div id=gotob><div id=gotob>
     	<div id="chatarea"><%int n=1;%>
     	<j:forEach items="${msgs}" var="m"><j:set var="num" value="<%=n%>"></j:set>
     	<div id="foralign${num}">
     	
     		<div id="eachmsg${num}" style="display: inline-block;padding: 10px;box-shadow: 10px 10px 25px rgb(0 0 0 / 60%);
     		border-radius: 10px;">${m.message}</div>
<!--    			onMouseOver="show()" -->
<!--    			onMouseOut="hide()" -->
     		<span id="msgdate${num}" 
   style="display:none;">${m.messageDate}</span>
   </div>
     		<input type="hidden" id="eachsender${num}" value="${m.sender}">
     		<script type="text/javascript">
     		function show(){
     			document.getElementById("msgdate${num}").style.display = "flex";
     		}
     		function hide(){
     			document.getElementById("msgdate${num}").style.display = "none";
     		}
     	var v1 = "${m.sender}";
     	var v2 = "${sender}";
     		if(v1 == v2)
     		{
     			document.getElementById("eachmsg${num}").style.backgroundColor= "rgba(0,0,0,.5)";
     			document.getElementById("eachmsg${num}").style.color= "#03e9f4";
     			document.getElementById("foralign${num}").style.textAlign= "right";
     		}
     		else{
     			document.getElementById("eachmsg${num}").style.backgroundColor= "#03e9f4";
     			document.getElementById("eachmsg${num}").style.color= "rgba(0,0,0,.5)";
     			document.getElementById("foralign${num}").style.textAlign= "left";
     		}
     		
     	</script>
     	
     	 <%n++;%>
     	 
     	</j:forEach>
     	</div>
     	<script type="text/javascript">chatarea.scrollTop = chatarea.scrollHeight;</script>
<!--      	<script type="text/javascript">gotob.scrollTop = gotob.scrollHeight;</script> -->
     	<input type="text" class="input" id="message">
     	<a class="sendbtn" onClick="send();"><i class="fa-regular fa-paper-plane" style="font-size: 25px;height: 30px;width: 50px;"></i></a>
     	</div></div>
      </div></div>
      
      <script src="resources/js/chat.js"></script>
</body>
</html>