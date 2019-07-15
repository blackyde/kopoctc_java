<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.Connector"%>
<%@ page import="java.util.*" %>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery.min.js"></script>
<style>
table, tr, th, td {
	border: 1px solid #000000;
	border-collapse: collapse;
	padding: 5px;
	text-align: left;
}

a {
	text-decoration: none;
}

span {
	color: red;
	font-size: 10px;
}
</style>
<script>
function check(which) {
	var fr = document.forms["inputForm1"];
	var form = fr[which];
	var where = which + "Alert";
	
	if(isNaN(form.value)) {
		form.value="";
		document.getElementById(where).innerHTML=("숫자만 입력하세요.");		
	} else if(form.value > 100) {
		form.value="";
		document.getElementById(where).innerHTML=("0에서 100 사이로 입력하세요.");
	} else {
		document.getElementById(where).innerHTML=("");
	}
}
function check2(which) {
	var fr = document.forms["inputForm2"];
	var form = fr[which];
	var where = which + "Alert";
	
	if(isNaN(form.value)) {
		form.value="";
		document.getElementById(where).innerHTML=("숫자만 입력하세요.");		
	} else {
		document.getElementById(where).innerHTML=("");
	}
}
function checkAll() {
	var fr = document.forms["inputForm1"];
	if(fr["name"].value.length < 1) {
		document.inputForm1.name.focus();
		return false;
	}
	if(fr["kor"].value.length < 1) {
		document.inputForm1.kor.focus();
		return false;
	}
	if(fr["eng"].value.length < 1) {
		document.inputForm1.eng.focus();
		return false;
	} 
	if(fr["mat"].value.length < 1) {
		document.inputForm1.mat.focus();
		return false;
	}
	return true;
}
function checkAll2() {
	var fr = document.forms["inputForm2"];
	if(fr["id"].value.length < 6) {
		document.inputForm2.id.focus();
		document.getElementById("idAlert").innerHTML=("학번은 6자리 숫자입니다. ex)209901");
		return false;
	}
	if(fr["id"].value.length > 6) {
		document.inputForm2.id.focus();
		document.getElementById("idAlert").innerHTML=("학번은 6자리 숫자입니다. ex)209901");
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<h2>성적 조회후 정정/삭제</h2>
	<form method="post" action="?contentPage=showREC.jsp" name="inputForm2" onsubmit="return checkAll2()">
	
		<table style="border: 0px;">
			<colgroup>
				<col style="width: 100px;"/>
				<col style="width: 200px;"/>
				<col />
			</colgroup>
			<tr style="border: 0px;">
				<th style="border: 0px;">조회할 학번</th>
				<td style="border: 0px;">
					<input type="text" name="id" id="id" onkeyup="check2('id')">
				</td>
				<td style="border: 0px;"><input type="submit" value="조회"></td>
			</tr>
			<tr style="border: 0px;">
				<td colspan="3" style="text-align: center; border: 0px;"><span id="idAlert" style="display: inline-block; "></span></td>
			</tr>
		</table>
	</form>
	<form method="post" name="inputForm1" onsubmit="return checkAll()">
		<table>
			<colgroup>
				<col style="width: 60px;" />
				<col style="width: 400px;" />
			</colgroup>
			<%
				int studentid = Integer.parseInt(id);
				String sql = String.format("SELECT * FROM examtable WHERE studentid = %d",
						studentid);
				PreparedStatement pstmt = CONN.prepareStatement(sql);
				ResultSet rset = null;
				try {
					rset = pstmt.executeQuery();
					if(!rset.next()) {
						out.print("<tr><td colspan='2'>없는 학번입니다.</td></tr>");
					} else {
			%>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" value="<%=rset.getString(1)%>">
					<script>    
					    // 입력을 제한 할 특수문자의 정규식
					    var replaceId  = /[<>()!0-9/*@#$%^&+_='"\-\\]/gi;
					    
					    $(document).ready(function(){
					        
					        $("#name").on("focusout", function() {
					            var x = $(this).val();
					            if (x.length > 0) {
					                if (x.match(replaceId)) {
					                   x = x.replace(replaceId, "");
					                }
					                $(this).val(x);
					            }
					        }).on("keyup", function() {
					            $(this).val($(this).val().replace(replaceId, ""));
					
					        });
					
					    });					 
					</script>
					<span id="nameAlert"></span>
				</td>
			</tr>
			<tr>
				<th>학번</th>
				<td>
					<input type="text" name="studentid" id="studentid" value="<%=rset.getInt(2)%>" readonly>
					<span id="studentidAlert"></span>
				</td>
			</tr>
			<tr>
				<th>국어</th>
				<td>
					<input type="text" name="kor" id="kor" value="<%=rset.getInt(3)%>" onkeyup="check('kor')">
					<span id="korAlert"></span>
				</td>
			</tr>
			<tr>
				<th>영어</th>
				<td>
					<input type="text" name="eng" id="eng" value="<%=rset.getInt(4)%>" onkeyup="check('eng')">
					<span id="engAlert"></span>
				</td>
			</tr>
			<tr>
				<th>수학</th>
				<td>
					<input type="text" name="mat" id="mat" value="<%=rset.getInt(5)%>" onkeyup="check('mat')">
					<span id="matAlert"></span>
				</td>
			</tr>
			<%
					}
					rset.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
				pstmt.close();
			%>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" formaction="?contentPage=updateDB.jsp">
					<input type="submit" value="삭제" formaction="?contentPage=deleteDB.jsp">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>