<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing websockets</title>
</head>
<body>
<div>
	<input type="text">
	<button type="button">입장</button>
</div>
<div>	
	<fieldset>
 	      <textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
        <br/>
        <input id="inputMessage" type="text"/>
        <input type="submit" value="send" onclick="sendMessage()" />
	</fieldset>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(function(){
	var btn = $("button[name=qwer]");
//function login(){
	$(btn).click(function(){
		var info = $("div>input").val();
		//alert("err");
		alert(info);
		
	});
//}

});



        var textarea = document.getElementById("messageWindow");
 
        //프로젝트명 밑의 자바파일 @ServerEndpoint(/boradcasting )으로 간다.
        var webSocket = new WebSocket('ws://localhost:80/chattest/broadcasting');
        var inputMessage = document.getElementById('inputMessage');
 
    webSocket.onerror = function(event) {
      onError(event+"error")
    };
 
    webSocket.onopen = function(event) {
      onOpen(event)
    };
 
    //채팅 텍스트를 상대로부터 받음
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
 
    //받은 메세지를 화면에 출력
    function onMessage(event) {
        textarea.value += "상대 : " + event.data + "\n";
    }
 
    function onOpen(event) {
        textarea.value += "연결 성공\n";
    }
 
    function onError(event) {
      alert(event.data+"nodata");
    }
 
    //채팅 텍스트를 상대에게 보냄
    function sendMessage() {
        textarea.value += "나 : " + inputMessage.value + "\n";
        webSocket.send(inputMessage.value);
        inputMessage.value = "";
    }
    
  </script>



</html>