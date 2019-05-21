<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.io.*"%>
<%
	String fileName = request.getHeader("X-File-Name");
	fileName = java.net.URLDecoder.decode(fileName, "UTF-8");
	String ext = fileName.substring(fileName.lastIndexOf("."));
	String uploadFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "_" + System.currentTimeMillis()
			+ ext;
	File uploadDir = new File(application.getRealPath("fileupload"));
	if (!uploadDir.exists()) {
		uploadDir.mkdir();
	}
	File uploadFile = new File(uploadDir, uploadFileName);

	InputStream in = request.getInputStream();
	OutputStream outFile = new FileOutputStream(uploadFile);
	byte[] buf = new byte[1024 * 2];
	int size = 0;
	while ((size = in.read(buf)) != -1) {
		outFile.write(buf, 0, size);
	}
	outFile.close();
	in.close();

	String fileUrl = application.getContextPath() + "/fileupload/" + uploadFileName;
	out.write("<a href='" + fileUrl + "'>" + fileName + "</a>");
%>













