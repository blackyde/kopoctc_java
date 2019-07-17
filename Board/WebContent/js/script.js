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