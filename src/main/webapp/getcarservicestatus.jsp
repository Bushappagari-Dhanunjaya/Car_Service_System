<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service status</title>
<style>
body{
background-color:rgb(219, 217, 217);
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
</style>
</head>
<body >
      <% String model=(String)session.getAttribute("carModel");
      String regno=(String)session.getAttribute("carRegNo");
      String status=(String)session.getAttribute("carStatus");
      
      %>    
        
<table class="table" border cellpadding="10px" cellspacing="0px">
     <caption>YOUR CAR SERVICE STATUS</caption>
   <thead><tr><th>Car Model</th><th>Car Reg No</th><th>Car Service Status</th></tr></thead>
   <tbody>
      <tr>
         <td><%=model %></td>
         <td><%=regno %></td>
         <td><%=status %></td>
      </tr>
   </tbody>
</table>
</body>
</html>