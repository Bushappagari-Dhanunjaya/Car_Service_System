<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.car.model.Customer,java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered customers</title>


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
</head>
<body>
<%
ArrayList<Customer> list=(ArrayList<Customer>)session.getAttribute("customerlist");
int len=list.size()+1;
int i=0;
%>
<h1>Registered Customers</h1>

<table  class="table" border cellpadding="10px" cellspacing="0px">
<caption>Registered Customers</caption>
<thead>
<tr>
<th>S.No</th>
<th>Name</th> 
<th>UserName</th>
<th>Email</th>
</tr>
</thead>
<tbody>
<%
for(Customer c1:list){
	i++;
	

%>
<tr>
<td><%=i %>	</td>
<td><%=c1.getName() %></td>
<td><%=c1.getUsername() %></td>
<td><%=c1.getEmail() %></td>
</tr>
<%} %>
</tbody>
</table>
</body>
</html>