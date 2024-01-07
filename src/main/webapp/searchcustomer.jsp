<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search a customer</title>
</head>
<style type="text/css">
body{
background-color:rgb(219, 217, 217);
font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
.table{
background-color:white;
width:60%;
text-align:center;
border:2px solid blue;
margin:100px auto;
border:none;

}

@media  screen and (max-width: 600px) {
  .table{
  width:96%;
  }
}
@media only screen and (min-width: 601px) and (max-width:899px) {
  .table{
  width:80%;
  }
}


@media only screen and (min-width: 900px) {
  .table{
  width:65%;
  }
}


@media only screen and (min-width: 900px) {
  .table{
  width:65%;
  }
}

</style>
<body>
<%
String name=(String)session.getAttribute("searchName");
String username=(String)session.getAttribute("searchUsername");
String email=(String)session.getAttribute("searchEmail");
%>
<h2>Customer</h2>
<table class="table" border cellpadding="10px" cellspacing="0px">
<caption>Customer</caption>
<thead>
<tr>
<th>Name</th>
<th>UsernName</th>
<th>Email</th>
</tr>
</thead>
<tbody>
<tr>
<td><%=name %></td>
<td><%=username %></td>
<td><%=email %></td>
</tr>
</tbody>
</table>
</body>
</html>