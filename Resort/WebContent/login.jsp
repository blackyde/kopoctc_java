<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Object obj = session.getAttribute("loginCheck");
if(obj != null) {
	String str = (String)session.getAttribute("loginCheck");
	if(str.equals("wrong")) {
%>
<script>alert('ID와 PW를 다시 확인해주세요.');</script>
<%
	}
}
%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="main.do">Home</a></li>
			<li class="breadcrumb-item">로그인</li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<form method="post" name="loginForm" action="loginAction.do" onsubmit="return login();">
			<fieldset>				
				<div class="form-group">
					<label for="exampleInputEmail1">ID</label>
					<input
						type="text" class="form-control" id="id" name="id"
						aria-describedby="emailHelp" placeholder="Enter ID" maxlength="20">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="password" name="password"
						placeholder="Enter Password" maxlength="20">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</fieldset>
		</form>
	</div>
</div>