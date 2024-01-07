<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList,com.car.model.History" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History of services</title>
<style>

body{
background-color:rgb(219, 217, 217);
font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
.srtable{
background-color:white;
width:60%;
text-align:center;
border:2px solid blue;
margin:100px auto;
border:none;

}


@media  screen and (max-width: 600px) {
  .srtable{
  width:70%;
  }
}
@media only screen and (min-width: 601px) and (max-width:899px) {
  .srtable{
  width:80%;
  }
}


@media only screen and (min-width: 900px) {
  .srtable{
  width:65%;
  }
}
</style>
</head>
<body>
<%ArrayList<History> list=(ArrayList)session.getAttribute("history");%>
<h2>History of Completed Service Requests </h2>
<table class="srtable" border cellpadding="10px" cellspacing="0px">
<caption>History of Completed Services</caption>
<thead>
<tr>
<th>UserName</th>
<th>Car Model</th>
<th>Car Reg No</th>
<th>Service</th>
<th>Date</th>
</tr>
</thead>
<%for(History h:list){
	
	%>

<tbody>
<tr>
<td> <%=h.getUsername() %> </td>
<td> <%=h.getCarmodel() %> </td>
<td> <%=h.getCarregno()%> </td>
<td> <%=h.getService() %> </td>
<td> <%=h.getDate() %> </td>
</tr>
<%} %>
</tbody>
</table>


</body>
</html>