<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<script src="https://kit.fontawesome.com/1ade4f5b7b.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="customerhome.css">
<link rel="stylesheet" href="about.css">

</head>
<body>
	<%
 String name=(String)session.getAttribute("SessionName");

%>

	<div class="home-body-container">
		<div class="nav-container">
			<h2 id="logo-name">
				Car<span id="x">X</span>Service
			</h2>
			<nav style="margin: auto;">
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#services">Services</a></li>
					<li><a href="/CSS/CustomerServiceHistory">History</a></li>
					<li><a href="#">Login</a></li>
					<li><a href="LogoutServlet">Logout</a></li>
				</ul>

			</nav>
			<div style="flex-grow: 1;">
				<div class="profile-container">
					<p>
						<span><i class="fa-regular fa-user" id="profile-icon"></i></span>&emsp;&nbsp;<% if(name!=null){ %><%=name.toUpperCase() %><%} %>
					</p>

				</div>

			</div>

		</div>


		<div class="body-container">
			<h3>Welcome to Our CarXService</h3>
			<p>We always focus on providing good Services to our customers</p>
			<a href="#getservices">
				<button>Get Service</button>
			</a>
		</div>


	</div>
	<br>

	<a href="#" name="services"></a>
	<div class="our-services">
		<h2>
			OUR SERVICES &nbsp;<i class="fa-solid fa-angles-right"
				style="font-size: 22px; color: gold;"></i>
		</h2>
	</div>

	<div class="service-container">
		<div class="service">
			<h2>Mechanical Services</h2>
			<p>Engine repair, brake repair, exhaust system maintenance, and
				transmission work</p>
		</div>
		<div class="service">
			<h2>Paint and Body Services</h2>
			<p>Paint replacement, body repairs, dent removal, and auto
				detailing</p>
		</div>
		<div class="service">
			<h2>Electrical Services</h2>
			<p>Battery replacement, ignition and electrical system
				troubleshooting, and power window replacement</p>
		</div>
		<div class="service">
			<h2>Emission Services</h2>
			<p>Emissions testing, inspection, and diagnostic services to
				ensure the vehicle is meeting emission standards</p>
		</div>
		<div class="service">
			<h2>Wheel and Tire Services</h2>
			<p>Tire rotation, tire replacement, wheel alignment, and brake
				maintenance.</p>
		</div>
		<div class="service">
			<h2>HVAC Services</h2>
			<p>Heating and cooling system, thermostat, and air filter</p>
		</div>

		<div class="service">
			<h2>Auto Transport Services</h2>
			<p>Transportation of a vehicle from one location to another,
				often by specialized trucks and professionals.</p>
		</div>
		<div class="service">
			<h2>Collision Services</h2>
			<p>Damage repair after an accident, painting, and any other
				necessary services to make the vehicle roadworthy again</p>
		</div>
		<div class="service">
			<h2>Recycling Services</h2>
			<p>Disposal of old vehicles, properly crushing and recycling the
				steel, copper, plastic, and rubber components</p>
		</div>
	</div>

	<br>
	<a href="#" name="getservices"></a>
	<div class="our-services" style="width: 350px">
		<h2>
			REQUEST FOR SERVICE &nbsp;<i class="fa-solid fa-angles-right"
				style="font-size: 22px; color: gold;"></i>
		</h2>
	</div>

	<div class="car-service-container">
		<div class="car-services">
			<div class="car-service-heading">
				<h4 style="transform: skew(30deg);" id="add-det">ADD CAR
					DETAILS</h4>
			</div>
			<a href="addcardetails.html">
				<button class="get-now">ADD NOW</button>
			</a> <img src="images/car_gold.png" alt="" class="car-car">

		</div>
		<div class="car-services">
			<div class="car-service-heading">
				<h4 style="transform: skew(30deg);" id="add-det">EDIT CAR
					DETAILS</h4>
			</div>
			<button class="get-now" onclick="openPop()">EDIT
					NOW</button><img src="images/car_blue1.png" alt="" class="car-car">

		</div>

		<!-- Pop up messages -->

		<!-- Edit details -->
		<div class="popup-div" id="pop-up-div">
			<span><i class="fa-regular fa-circle-xmark" id="wrong"
				onclick="closePop()"></i></span>
			<form action="/CSS/EditCarDetailsOne">
				<input type="text" name="CarRegNo" id="regno"
					placeholder="Enter Car Registration No.." class="tf" required> <br>
				<input type="submit" value="Edit Details" class="submit-btn">
			</form>
		</div>
		<!-- get status -->

		<div class="statusPopupDiv" id="status-popup-div">
			<span><i class="fa-regular fa-circle-xmark" id="wrong-2"
				onclick="closePop2()"></i></span>
			<form action="/CSS/CheckServiceStatus">
				<input type="text" name="CarRegNo" id="regno"
					placeholder="Enter Car Regstration No.." class="tf" required> <input
					type="submit" value="Check Status" class="submit-btn">
			</form>
		</div>






		<div class="car-services">
			<div class="car-service-heading">
				<h4 style="transform: skew(30deg);" id="add-det">REQUEST A
					SERVICE</h4>
			</div>
			<a href="carservicerequest.html"><button class="get-now" >REQUEST
					NOW</button></a>  <img src="images/car_black.png" alt="" class="car-car">

		</div>
		<div class="car-services">
			<div class="car-service-heading">
				<h4 style="transform: skew(30deg);" id="add-det">CHECK SERVICE
					STATUS</h4>
			</div>
			<button class="get-now" onclick="CheckStatusPopup()">CHECK
					NOW</button><img src="images/car_wg.png" alt="" class="car-car">

		</div>


	</div>
	
	<br>
		<div class="our-services" style="width: 350px;">
		<h2>
			ABOUT &nbsp;<i class="fa-solid fa-angles-right"
				style="font-size: 22px; color: gold;"></i>
		</h2>
	</div>
 <div id="about-about">
        <div id="footer">

            <div class="About-headings">
                <div style="display: flex;">
                    <h3 class="logo"> Car<span style="color:gold">X</span>Service</h3>
                </div>

            </div>
            <div class="About-headings">
                <h3 style="color:gold">Our Services</h2>
                    <br>
                    <a href="contactus.html">Contact Us</a><br><br>
                    <a href="">Learn more</a><br><br>
                    <a href="">Car Services</a><br><br>

            </div>
            <div class="About-headings">
                <h3 style="color:gold">Company</h2>
                    <br>
                    <a href="about.html">About Us</a><br><br>
                    <a href="">CEO</a><br><br>
                    <a href="terms.html">Terms & Conditions</a><br><br>
                    <a href="privacy.html">Privacy Policy</a>
            </div>
            <div class="About-headings">
                <h3 style="color:gold">Connect With Us</h2>
                    <br>
                    <a href=""><i class="fa-brands fa-facebook " style="color:orange;font-size:20px;" id="fb-fb"></i>
                        &nbsp;Facebook</a> <br><br>
                    <a href=""><i class="fa-brands fa-instagram" style="color: orange;font-size:20px;"></i>&nbsp;
                        Instagram</a> <br><br>
                    <a href=""> <i class="fa-brands fa-twitter" style="color: orange;font-size:20px;"></i>
                        &nbsp;Twitter</a> <br><br>

            </div>

        </div>

    </div>



    
    <script>
    
        let popup=document.getElementById("pop-up-div");
        function openPop(){
           popup.classList.add("open-popup-div");
        }
        function closePop(){
           popup.classList.remove("open-popup-div");
           
        }

        let popup2=document.getElementById("status-popup-div");
     function CheckStatusPopup(){
        popup2.classList.add("statusPopupDivOpen");
     }
     function closePop2(){
        popup2.classList.remove("statusPopupDivOpen");
        
     }
   
       </script>

</body>
</html>