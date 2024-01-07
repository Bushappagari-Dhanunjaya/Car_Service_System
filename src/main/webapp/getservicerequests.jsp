<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,com.car.model.Car" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All service requests</title>
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
span{
background-color:black;
color:white;
padding:6px;
border-radius:30%;

}
</style>
</head>
<body>
<%
ArrayList<Car> sr=(ArrayList)session.getAttribute("SRs");
int len=sr.size()+1;
int i=0;
%>
<h2>Service Requests <span><%=len-1 %></span></h2>
<table class="srtable" border cellpadding="10px" cellspacing="0px">
<caption>Service Requests</caption>
<thead> <tr>
<th>S.No</th>
<th>UserName</th>
<th>Car Model</th>
<th>Car Type</th>
<th>Car Registration No.</th>
<th>Service</th>
<th>Status</th>

</tr></thead>
<tbody>
<%
for(Car c1:sr){
	i++;
%>

<tr>
<td><%=i %></td>
<td><%=c1.getUsername() %></td>
<td><%=c1.getCarmodel() %></td>
<td><%=c1.getCartype() %></td>
<td><%=c1.getCarregno() %></td>
<td><%=c1.getCarservice() %></td>
<td><%=c1.getCarstatus() %></td>

</tr>

<%} %>
</tbody>
</table>

</body>
</html>