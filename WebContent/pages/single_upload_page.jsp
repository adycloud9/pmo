<%@ page import="java.io.*,java.sql.*"%>
<%
	//to get the content type information from JSP Request Header
	String contentType = request.getContentType();

	if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
 		DataInputStream in = new DataInputStream(request.getInputStream());

		int formDataLength = request.getContentLength();
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;

		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
			totalBytesRead += byteRead;
			}
	
		
		String file = new String(dataBytes);

		
		String saveFile = file.substring(file.indexOf("filename=\"") + 10);

		int end=saveFile.indexOf("\"", 10);
		String nameFile=saveFile.substring(0, end);
		%>
<%
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));

		nameFile.replace('\\','/');
	
		Connection con=null; 

		ResultSet rs=null; 

		PreparedStatement psmt=null; 

		FileInputStream fis;

		String url="jdbc:mysql://172.16.43.98:3306/test_pmo"; 

		try{ 

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 

		con=DriverManager.getConnection(url,"root","Pa55word");


		File image=new File(nameFile); 


		psmt=con.prepareStatement("insert into saveSowFile(sowName,sowFile)"+"values(?,?)"); 

		psmt.setString(1,saveFile); 


		fis=new FileInputStream(image); 


		psmt.setBinaryStream(2, (InputStream)fis, (int)(image.length())); 

		int s = psmt.executeUpdate(); 


		if(s>0) { 

		%>



<%%>

<% 

		}

		else { 

		out.println("unsucessfull to upload image."); 

		}

		con.close();

		psmt.close();

		}catch(Exception ex){ 

		out.println("Error in connection : "+ex); 

		}
		%>
<Br>
<table border="2">
	<tr>
		<td><b>You have successfully upload the file by the name of:</b>
		<% out.println(saveFile); %>
		</td>
	</tr>
</table>
<%
		}
%>
