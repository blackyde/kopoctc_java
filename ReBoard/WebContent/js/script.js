$(document).ready(function() {
     $('#contents').summernote({
             height: 300,                 // set editor height
             minHeight: null,             // set minimum height of editor
             maxHeight: null,             // set maximum height of editor
             focus: true                  // set focus to editable area after initializing summernote
     });
});
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
function go_view(write_num){
    
    document.wform.write_num.value = write_num;
    document.wform.contentPage.value = "item.jsp";
    document.wform.action = "/ReBoard/";
    document.wform.submit();

}
function go_list(){
    
    document.wform.contentPage.value = "list.jsp";
    document.wform.action = "/ReBoard/";
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