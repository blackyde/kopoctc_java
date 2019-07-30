<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String msg = request.getParameter("msg");
%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<ul class="bxslider">
			<!-- <li><a href="#"><img src="http://img1.daumcdn.net/thumb/R1920x0/?fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F99C7143A5BEE75FB3092D4" alt="" title="이미지1"></a></li>
			<li><a href="#"><img src="http://img1.daumcdn.net/thumb/R1920x0/?fname=http%3A%2F%2Fcfile10.uf.tistory.com%2Fimage%2F99C7223A5BEE75FB303A8E" alt="" title="이미지2"></a></li>
			<li><a href="#"><img src="http://img1.daumcdn.net/thumb/R1920x0/?fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F9982093A5BEE75FC259992" alt="" title="이미지3"></a></li> -->
			<li>
				<div class="jumbotron main1">
					<h1 class="display-3 dokdo">RESORT CHARMANDER</h1>
					<p class="lead" style="padding-left: 20px;">
						설악과 동해, 자연의 감성을 담은 공간
					</p>
					<hr class="my-4">
					<p>
						파이리조트
					</p>
				</div>
			</li>
			<li>
				<div class="jumbotron main2">
					<h1 class="display-3 dokdo">RESORT CHARMANDER</h1>
					<p class="lead" style="padding-left: 20px;">
						설악과 동해, 자연의 감성을 담은 공간
					</p>
					<hr class="my-4">
					<p>
						파이리조트
					</p>
				</div>
			</li>
			<li>
				<div class="jumbotron main3">
					<h1 class="display-3 dokdo">RESORT CHARMANDER</h1>
					<p class="lead" style="padding-left: 20px;">
						설악과 동해, 자연의 감성을 담은 공간
					</p>
					<hr class="my-4">
					<p>
						파이리조트
					</p>
				</div>
			</li>
		</ul>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="alert alert-dismissible alert-warning">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<h4 class="alert-heading">파이리조트 Coming Soon!</h4>
			<p class="mb-0">
				파이리조트가 8월중으로 완공됩니다.
			</p>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-lg-4">
		<div class="alert alert-dismissible alert-danger">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>금수저룸</strong><br>
			금수저룸이 새단장을 마쳤습니다.
		</div>
	</div>
	<div class="col-lg-4">
		<div class="alert alert-dismissible alert-success">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>은수저룸</strong><br>
			은수저룸이 새단장을 마쳤습니다.
		</div>
	</div>
	<div class="col-lg-4">
		<div class="alert alert-dismissible alert-info">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>흙수저룸</strong><br>
			흙수저룸이 새단장을 마쳤습니다.
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<h3><%=msg %></h3>
	</div>
</div>