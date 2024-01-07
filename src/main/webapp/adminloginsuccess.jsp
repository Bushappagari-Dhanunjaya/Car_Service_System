<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin's Home</title>
<style>
     body{
        margin: 0;
        background-color: rgb(236, 234, 234);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .nav{
      
        background-color: rgb(0, 153, 255);
        display: flex;
        justify-content: space-around;
        align-items: center;
        gap:10px;

    }
    .nav a{
        color: white;
        border: 2px solid white;
        padding: 6px;
        border-radius: 4px;
        text-decoration: none;
        transition: 0.4s;
    }
    .nav a:hover{
        color:black;
        background-color: white;
    }
    #admin-name{
        background-color: black;
        color:white;
        padding: 6px;
        border-radius: 4px;
    }

    .bg{
        background-color: rgb(40, 167, 252);
        transform: skew(-45deg);
        width: 200px;
        color:white;
        padding:0px 30px;
        margin-left: 4%;
        box-shadow: 4px 4px black;
        transition: 0.4s;
    }
    .bg:hover{
        width: 240px;
    }
    p{
        transform: skew(45deg);
    }
     p a{
        
        font-size: larger ;
        text-decoration: none;
        color: white;
        font-weight: 600;
    }
    p a:hover{
        color: black;
    }
   
    @media screen and (max-width:800px){
        .bg{
            margin:0px auto;
        }
    }

    
    </style>
</head>
<body>
<%
String adminName=(String)session.getAttribute("aname");
%>

<div class="nav"> 
        <h2>Admin</h2>
        <h5 id="admin-name">Mr.<%if (adminName!=null){ %><%=adminName.toUpperCase() %> <%} %></h5> 
        <h5><a href="AdminLogoutServlet">LOGOUT</a></h5>
      
    </div><br><br>

     <div  class="bg">
        <p ><a href="/CSS/GetRegisteredCustomers">Registered Customer</a></p>
      </div>
      <div  class="bg">
        <p ><a href="/CSS/GetServiceRequest">Service Requests</a></p>
      </div>
      <div  class="bg">
        <p ><a href="searchcustomer.html">Search Customer </a></p>
      </div>
      <div  class="bg">
        <p ><a href="updateservice.html">Update Service</a></p>
      </div>
      <div  class="bg">
        <p ><a href="deletecustomer.html">Delete Customer</a></p>
      </div>
      <div  class="bg">
        <p ><a href="/CSS/HistoryOfServices">History of Services</a></p>
      </div>


</body>
</html>