<%@ page import="java.sql.*"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
function trim(stringToTrim) {
return stringToTrim.replace(/^\s+|\s+$/g,"");
}

function validate(){
var emp_value ="";
for (var i=0; i < document.employee.empid.length; i++){
if (document.employee.empid[i].checked){

var emp_value = document.employee.empid[i].value;
}
}
if(emp_value=="" || emp_value==null){
alert("Please select Employee Id");
return false;
}
return true;
}
function showEmp(){
if(validate()){
	for (var i=0; i < document.employee.empid.length; i++){
		if(document.employee.empid[i].checked){
			var emp_value = document.employee.empid[i].value;
		}
	}
	xmlHttp=GetXmlHttpObject();
	if (xmlHttp==null){
		alert ("Browser does not support HTTP Request");
		return false;
	}
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	var url="getuser.jsp"
	url=url+"?emp_id="+emp_value;
	xmlHttp.onreadystatechange=stateChanged();
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}
}
/* function trim1(String stringToTrim)
{
   for(int i=0;i<stringToTrim.length;i++)
    {
      if(stringToTrim.charAt(i) == ":")
      {
          strar[j]=s1;
         String s1="";
         }
         else
         {
         String s2=stringToTrim.charAt(i);
         s1=s1+s2;
         }
       }
       return strar;
       }
*/   
   
   
function stateChanged(){ 
if (xmlhttp.readyState==4 && xmlhttp.status==200){ 
var showdata =xmlHttp.responseText; 
alert(showdata);
var strar = trim(showdata);
if(strar.length>0){
window.opener.location.reload();
window.location.reload(); 
alert(strar);
opener.document.getElementById("emp_id").value=strar[1];
opener.document.getElementById("emp_name").value=strar[2];

window.close();
}
}
}
function GetXmlHttpObject(){
var xmlHttp=null;
try{
// Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}
catch (e){
//Internet Explorer
try{
xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
}
catch (e){
xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
}
}
return xmlHttp;
}
</script>
</head>
<body>
<form name="employee" action=""><br>
<br>
<table border="0" width="400px" align="center" bgcolor="#CDFFFF">
	<tr>
		<td align="center" colspan="2"><b>Select Employee Id</b></td>
	</tr>
	<%
Connection con = null;
String url = "jdbc:mysql://localhost:3306/";
String db = "student";
String driver = "com.mysql.jdbc.Driver";
String userName ="root";
String password="Pa55word";

int sumcount=0; 
Statement st;
try{
Class.forName(driver).newInstance();
con = DriverManager.getConnection(url+db,userName,password);
String query = "select * from Employee";
st = con.createStatement();
ResultSet rs = st.executeQuery(query);
%>
	<html:select property="select" value="SELECT">
		<%
while(rs.next()){
%>


		<html:option value="<%=rs.getString(1)%>">
			<%=rs.getString(2)%>
		</html:option>

		<%
}
%>
	</html:select>
	<%
}
catch (Exception e) {
e.printStackTrace();
}
%>
	<tr>
		<td align="center" width="50%"><input type="submit"
			value="Select" onclick="return showEmp()"></td>
	</tr>
</table>
</form>
</body>
</html>
