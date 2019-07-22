function checkAll() {
	var fr = document.forms["inputForm"];
	if(fr["goods_name"].value.length < 1 || fr["goods_name"].value.trim().length < 1) {
		fr["goods_name"].focus();
		return false;
	}
	if(fr["stock"].value.length < 1 || fr["stock"].value.trim().length < 1) {
		fr["stock"].focus();
		return false;
	}
	if(fr["describe"].value.length < 1 || fr["describe"].value.trim().length < 1) {
		fr["describe"].focus();
		return false;
	}
	if(fr["image"].value.length < 1 || fr["image"].value.trim().length < 1) {
		fr["image"].focus();
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
function check(which) {
	var fr = document.forms["inputForm"];
	if(isNaN(fr[which].value)) {
		fr[which].value="";
	}
}