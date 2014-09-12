// Rev. 09/07/2003
function Toggle(item) {
    var menuList=document.getElementById('menudtls').value;
	var menuArray=menuList.split(',');
	menuArray.splice(menuArray.length-1,1);
   obj=document.getElementById(item);
   visible=(obj.style.display!="none")
   key=document.getElementById("x" + item);
   if (visible) {
     obj.style.display="none";
     //key.innerHTML="";
   } else {
      obj.style.display="block";
   }
   for(i=0;i<menuArray.length;i++)
   {
		if(item!=menuArray[i])
		{
			document.getElementById(menuArray[i]).style.display='none';
			
		}
   }
}

function Expand() {
  
   divs=document.getElementsByTagName("DIV");
   for (i=0;i<divs.length;i++) {
     divs[i].style.display="block";
     key=document.getElementById("x" + divs[i].id);
     key.innerHTML=" ";
//     key.innerHTML="<img src='/crmnew/images/arrow.gif' width='16' height='16' hspace='0' vspace='0' border='0'>";
   }
}

function Collapse() {
   divs=document.getElementsByTagName("DIV");
   for (i=0;i<divs.length;i++) {
     divs[i].style.display="none";
     key=document.getElementById("x" + divs[i].id);
     key.innerHTML=" ";
//     key.innerHTML="<img src='/crmnew/images/arrow.gif' width='16' height='16' hspace='0' vspace='0' border='0'>";
   }
}


