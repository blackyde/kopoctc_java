var replaceId = /[<>!;/']/gi;

$(document).ready(function() {
	$('.summernote').summernote({
		height: 300,                 // set editor height
		minHeight: null,             // set minimum height of editor
		maxHeight: null,             // set maximum height of editor
		focus: true,                  // set focus to editable area after initializing summernote
		popover: false
	});
	
	$("#subject").on("focusout", function() {
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
	
	$("#contents").on("focusout", function() {
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
$(document).ready(function () {
    $('.bxslider').bxSlider({
        auto: true, // 자동으로 애니메이션 시작
        speed: 500,  // 애니메이션 속도
        pause: 5000,  // 애니메이션 유지 시간 (1000은 1초)
        mode: 'fade', // 슬라이드 모드 ('fade', 'horizontal', 'vertical' 이 있음)
        autoControls: true, // 시작 및 중지버튼 보여짐
        pager: true, // 페이지 표시 보여짐
        captions: true, // 이미지 위에 텍스트를 넣을 수 있음
    });
});
function go(where){
    document.fr.contentPage.value = where;
    document.fr.action = "/Resort/";
    document.fr.submit();
}
function checkAll() {
	var fr = document.forms["inputForm"];
	if(fr["subject"].value.length < 1 || fr["subject"].value.trim().length < 1) {
		fr["subject"].focus();
		return false;
	}
	if(fr["contents"].value.length < 1 || fr["contents"].value.trim().length < 1) {
		fr["contents"].focus();
		return false;
	}
	return true;
}
function checkUpdate() {
	var fr = document.forms["updateForm"];
	
	fr["subjectFinal"].value = document.getElementById("subject").value;
	fr["contentsFinal"].value = document.getElementById("contents").value;
	
	if(fr["subjectFinal"].value.length < 1 || fr["subjectFinal"].value.trim().length < 1) {
		document.getElementById("subject").focus();
		return false;
	}
	if(fr["contentsFinal"].value.length < 1 || fr["contentsFinal"].value.trim().length < 1) {
		document.getElementById("contents").focus();
		return false;
	}
	return true;
}
function checkDelete() {
	var answer = confirm("정말 삭제하시겠습니까?");
	return answer;
}
function go_notice(write_num){
    
    document.noticeForm.write_num.value = write_num;
    document.noticeForm.contentPage.value = "news/board/item.jsp";
    document.noticeForm.action = "/Resort/";
    document.noticeForm.submit();

}
function go_reply(write_num){
    
    document.replyForm.write_num.value = write_num;
    document.replyForm.contentPage.value = "news/reboard/item.jsp";
    document.replyForm.action = "/Resort/";
    document.replyForm.submit();

}
function go_list(){
    
    document.wform.contentPage.value = "news/reboard/list.jsp";
    document.wform.action = "/Resort/";
    document.wform.submit();

}
function go_boardlist(){
    
    document.wform.contentPage.value = "news/board/list.jsp";
    document.wform.action = "/Resort/";
    document.wform.submit();

}
function boxcheck(num) {
	for(i = 0; i < num; i++) {
		var files = "file" + i;
		var checks = "check" + i;
		if($("input:checkbox[id=" + files + "]").is(":checked") == false) {
			$("input:checkbox[id=" + checks + "]").prop("checked", false);
		} else {
			$("input:checkbox[id=" + checks + "]").prop("checked", true);
		}
	}
	
}
function logout() {
	var logout = confirm("로그아웃 하시겠습니까?");
	if(logout) {
		document.wform.contentPage.value = "logout.jsp";
	    document.wform.action = "/Resort/";
	    document.wform.submit();
	}
}