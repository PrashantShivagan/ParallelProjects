<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function chkEmpty(){
	
if (document.frmReg.mobileno.value == "") {alert("Please fill the Mobile No");
	return false;}
	
	
	else {
	//alert("Hotel Booking completed Successfully.");
	return true;
		}
	}
</script>
<h1 align="center">Deposit Amount in Account</h1>
<body>
<b:form name="frmReg" action="depdata" method="post" modelAttribute="z" onsubmit="return chkEmpty()">
<table align="center" border="2px">
<tr>
<td>Mobile No</td>
<td><b:input path="mobileno" id="mobileno" pattern="[6-9][0-9]{9}"  title="Enter valid 10 digit number starting with 6 to 9"/></td>
</tr>
<tr>
<td>Deposit Balance</td>
<td><b:input path="bal"/></td>
</tr>

<tr>
<td>
<td align="right"><input type="Submit" value="Deposit Amt"/>
</td>
</tr>
</table>
</b:form>
</body>
</html>