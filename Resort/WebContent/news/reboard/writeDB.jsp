<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.reboard.dto.*" %>
<%@ page import = "com.reboard.dao.*" %>
<%@ page import = "java.util.*" %>
<%@ page import="java.io.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%
boolean isMultipart = ServletFileUpload.isMultipartContent(request); // multipart로 전송되었는가를 체크
if (isMultipart) { // multipart로 전송 되었을 경우
	File temporaryDir = new File("c:\\Study\\File\\"); //업로드 된 파일의 임시 저장 폴더를 설정
	String realDir = config.getServletContext().getRealPath("/upload/");
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setSizeThreshold(1 * 1024 * 1024); //1메가가 넘지 않으면 메모리에서 바로 사용
	factory.setRepository(temporaryDir); //1메가 이상이면 temporaryDir 경로 폴더로 이동
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(10 * 1024 * 1024); //최대 파일 크기(10M)
	List<FileItem> items = upload.parseRequest(request); //업로드 요청을 파싱해서 FileItem 목록 저장

	Iterator<FileItem> iter = items.iterator(); //Iterator 사용
	Map<String, String> param = new HashMap<String, String>(); //key, value를 받을 map 준비
	List<String> files = new ArrayList<String>();
	while (iter.hasNext()) {
		FileItem fileItem = (FileItem) iter.next(); //파일을 가져온다
		if (fileItem.isFormField()) { //input type file 이외의 form 에서 전송된 값들
			String parameter = fileItem.getFieldName(); //input name
			String value = fileItem.getString("utf-8"); //input value
			if(!(value.contains("&lt;") || value.contains("&gt;"))) {
				value = value.replaceAll(";", "&#59;");
			} //input 값에 sql문이 들어오는  것을 방지하기 위해 replace
			value = value.replaceAll("'", "&#39;");
			param.put(parameter, value); //map 에 key, value 쌍을 저장
		} else { //파일이면 이부분의 루틴을 탄다
			if (fileItem.getSize() > 0) { //파일이 업로드 되었나 안되었나 체크 size>0이면 업로드 성공
				String fieldName = fileItem.getFieldName();
				String fileName = fileItem.getName();
				String contentType = fileItem.getContentType();
				boolean isInMemory = fileItem.isInMemory();
				long sizeInBytes = fileItem.getSize();
				File uploadedFile = new File(realDir, fileName); //실제 디렉토리에 fileName으로 카피 된다.
				int duplicate = 1;
				while(uploadedFile.exists()) { //파일명 중복처리
					fileName = fileItem.getName();
					fileName = duplicate + "_" + fileName;
					uploadedFile = new File(realDir, fileName);
					duplicate++;
				}
				files.add(fileName);

				try {
					uploadedFile = new File(realDir, fileName); //실제 디렉토리에 fileName으로 카피 된다.
					fileItem.write(uploadedFile);
					fileItem.delete(); //카피 완료후 temp폴더의 temp파일을 제거
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board();
	b.setSubject(param.get("subject"));
	b.setContents(param.get("contents"));
	b.setFile(files);
	bb.insert(b);
} else {
	response.sendRedirect("/Resort/");
}
%>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="news/reboard/list.jsp">
</form>
<script>
fr.submit();
</script>