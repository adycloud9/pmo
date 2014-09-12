<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma","no-cache");
try{%>
<!--
 * JSP
 *
 * Name: menu.jsp
 * Action Class : LoginAction.java  
 * Form Class   : LoginForm.java 
 * <p>
 * <b>Revision History:</b><pre>
 * ========================================================================================
 *                            Prior
 * Date       By              Version  	Description
 * ---------- --------------- -------  ----------------------------------------------------
 * 
 * ========================================================================================
 * </pre>
 *
 * @author   Tata Consultancy Service
 
-->
<%@page import="com.vsnl.model.Letter;"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<link rel='stylesheet' href='../style/global.css'>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/tree.css" type="text/css">
<script language="javascript" src="<%=request.getContextPath()%>/jscripts/tree.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jscripts/jquery.js"></script>
 
<BODY topmargin=0 leftmargin=0 rightmargin=0 marginwidth="0" marginheight="0" vlink="#000000" alink="#000000" link="#000000">

<script type="text/javascript">

/***********************************************
* Switch Menu script- by Martial B of http://getElementById.com/
* Modified by Dynamic Drive for format & NS4/IE4 compatibility
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/
var message="Function Disabled..";//V 1.0


function callBOWindow(){
window.open('http://172.16.41.123/wiasp/','mywin');
}
if (document.getElementById){ //DynamicDrive.com change
document.write('<style type="text/css">\n')
document.write('.submenu{display: none;}\n')
document.write('</style>\n')
}

//V1.0 Start..
function Redirect(url){
//alert(url);
setTimeout("top.frames['frWorkspace'].location.href ='"+url+"'" ,100);
return false;
}


function clickIE4(){
if (event.button==2){
alert(message);
return false;
}
}

function clickNS4(e){
if (document.layers||document.getElementById && !document.all){
if (e.which==2||e.which==3){
alert(message);
return false;
}
}
}

if (document.layers){
document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS4;
}
else if (document.all && !document.getElementById){
document.onmousedown=clickIE4;
}

document.oncontextmenu=new Function("alert(message);return false")


//V1.0 ends..

function SwitchMenu(obj){
	if(document.getElementById){
	var el = document.getElementById(obj);
	var ar = document.getElementById("masterdiv").getElementsByTagName("span");

		if(el.style.display != "block"){
			for (var i=0; i<ar.length; i++){
				if (ar[i].className=="submenu")
				ar[i].style.display = "none";
			}
			el.style.display = "block";
		}else{
			el.style.display = "none";
		}

	}
}


function SwitchMenutrans(obj){
	if(document.getElementById){
	var el = document.getElementById(obj);
	var ar = document.getElementById("transdiv").getElementsByTagName("span");

		if(el.style.display != "block"){
			for (var i=0; i<ar.length; i++){
				if (ar[i].className=="submenu")
				ar[i].style.display = "none";
			}
			el.style.display = "block";
		}else{
			el.style.display = "none";
		}
	}
}


</script>

<script>
function moving()
{
	if (slm.style.pixelTop>topboard.style.pixelTop)
		slm.style.pixelTop-=20;
		moveid = setTimeout("moving()",1);
	if(slm.style.pixelTop<=topboard.style.pixelTop+3)
		clearTimeout(moveid);
}


function movingtrans()
{
	if (slm2.style.pixelTop>topboard.style.pixelTop)
		slm2.style.pixelTop-=20;
		moveid2 = setTimeout("movingtrans()",1);
	if(slm2.style.pixelTop<=topboard.style.pixelTop+3)
		clearTimeout(moveid2);
}
</script>

<Script Language="JavaScript">browsername=navigator.appName;
if (browsername.indexOf("Microsoft")==-1)
{alert("This program wil not work in your browser, Please use Microsoft Inernet Explorer 4 or higher version");
location.href="vnetsorry.html";}
var submenuinner;
var submenutrans;

function menu(k){
var menuDivList='';
switch(k)
{

	
	case "1" :
	submenutrans = " ";
			//submenutrans = submenutrans + "<div align=left><table border=0 cellpadding='2' cellspacing=1 width=150><tr><td  class=menutitle align=left><a id='x2FORM' class=menutitle> <!-- href=javascript:Toggle('2FORM');--> Main Menu</a></td></tr></table>";
			submenutrans = submenutrans + "<div id='2FORM' style='display: none; align:left; margin-left: 2em;'>";
			
			
			<%
			String arrowImage="arrow.gif";
		    java.util.List menuList=(java.util.List)session.getAttribute("menu");
		    
				int size=menuList.size();
				try{
				String subMenuName=null;
				String subMenuURL=null;
				String submenuId=null;
				String submenucode=null;				 
				for(int i=0; i<size; i++){

					submenuId=((com.vsnl.model.Letter)menuList.get(i)).getMenuId();	
					submenucode=((com.vsnl.model.Letter)menuList.get(i)).getMenuCode();	
					subMenuName=((com.vsnl.model.Letter)menuList.get(i)).getMenuTitle();					
					subMenuURL=((com.vsnl.model.Letter)menuList.get(i)).getMenuurl();
					
					
					if (submenuId.trim().charAt(0)=='-'){%>
																																																																	
							submenutrans = submenutrans + "<table width='100%' border=0 cellpadding='0' cellspacing='0' onmouseover=\"this.className='submenuhighlight';\" onmouseout=\"this.className='';\" ><tr><td><img src='<%=request.getContextPath()%>/images/<%=arrowImage%>' border=0>&nbsp;<a href='<%=request.getContextPath()%>/<%=subMenuURL%>' class=mlink target=frWorkspace><%=subMenuName%></a></td></tr></table>";		
											
					<%}else{%>
						submenutrans = submenutrans + "</div>";	
					  <%if(i==0){%>
						   submenutrans += "<table border=0 cellpadding='0' cellspacing=1><tr><td>";
					   <%}else{%>
						   submenutrans += "</td></tr><tr><td>";
						<%}%>					
						<%if (subMenuURL==null){
						%>
							submenutrans = submenutrans + "<table class='menurow' onmouseover=\"this.className='menurowinvert';\" onmouseout=\"this.className='menurow';\" width='100%' border=0 cellpadding='0' cellspacing='0'><tr><td width='1' height='20px' class=menutitle ><a id='xdiv<%=submenucode%>' href=javascript:Toggle('div<%=submenucode%>'); ></td><td class=submenutitle><a class=menutitle href=javascript:Toggle('div<%=submenucode%>');><%=subMenuName%></a><td></tr></table>";
							submenutrans = submenutrans + "<div id='div<%=submenucode%>' style='display: none;'>";
							menuDivList+='div<%=submenucode%>'+',';
						<%
						}else{%>			
								submenutrans = submenutrans + "<table class='menurow' onmouseover=\"this.className='menurowinvert';\" onmouseout=\"this.className='menurow';\"  width='100%' border=0 cellpadding='0' cellspacing='0'><tr><td width='1' height='20px' class=menutitle ><a id='xdiv<%=submenucode%>' href=<%=subMenuURL%>'></a></td><td class=submenutitle><a class=menutitle href='<%=request.getContextPath()%>/<%=subMenuURL%>' target=frWorkspace><%=subMenuName%></a></td></tr></table>";
						
						<%}
					   if(i==size-1)
					   {%>
						   submenutrans += "<div id='2FORM' style='display: none; align:left; margin-left: 2em;'>";
					   <%}
						   
					}
				  }				
				}catch(Exception e){
					out.println("Error: "+e);
					System.out.println("Exception: " +e);
				}
			%>

			
		submenutrans = submenutrans + "</div></td></tr><tr class='menurow' onmouseover=\"this.className='menurowinvert';\" onmouseout=\"this.className='menurow';\"><td>";
		submenutrans = submenutrans + "<table  border=0  cellpadding='2' cellspacing=1><tr><td class=submenutitle><a class=menutitle href='<%=request.getContextPath()%>/pages/logout.jsp' target=_parent>Logout </a><td></tr></table>";
		submenutrans = submenutrans + "</td></tr></table>";
		submenutrans = submenutrans + "</div>";
	//document.getElementById('sample').value=submenutrans;
	slm.style.pixelTop = document.body.scrollHeight/2+5;
	moving();
	slm.innerHTML=submenutrans;
	break;

}
document.getElementById('menudtls').value=menuDivList;
}

</script>

<script language =  "Javascript">
var myimages=new Array();
var imgcount = 0;
function preloadimages()
{
	imgcountmax=preloadimages.arguments.length;
	for (i=0;i<preloadimages.arguments.length;i++){
		myimages[i]=new Image();
		myimages[i].src="./image/"+preloadimages.arguments[i];
	}
	
}


function changeimage(){
slm.innerHTML = "<IMG border=2 src="+myimages[imgcount].src+" style=\'border-color: #ff6801\' ><br>";
imgcount++;
if (imgcount==imgcountmax)
{
imgcount =0;
}

}
</script>


<!-- A class=mlink HREF = "javascript:onClick=">test</a -->

<table border = 0 height = 100% width =150>
<tr>
<td height=100% align=left valign = top><BR>
<div id = "topboard" style="position:relative" align="left"></div>
<!--  <textarea name="sample" rows="30" cols="30"></textarea> -->
<div id = "slm" style="position: relative" align="left"><font size=10 color = menutitle face=tahoma><i> </i></font></div>
</td>
</tr>
<tr>
	<td>
		<input type="hidden" name="menuDetail" id="menudtls"/>
	</td>
	
</tr>

</table>

<script>
	menu('1');
	Toggle('2FORM');
</script>




</BODY>
<%}catch(Exception e){
  e.printStackTrace();
}%>