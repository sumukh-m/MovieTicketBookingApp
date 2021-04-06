<!DOCTYPE html>
<html>
<title>Booking Menu</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>
<body class="w3-content" style="max-width:1200px">

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <h3 class="w3-wide"><b>Book Tickets<br/></b></h3>
    <p>Welcome!<br/>${user}</p>
  </div>
  <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
  <a onclick="myAccFunc()" href="javascript:void(0)" class="w3-button w3-block w3-white w3-left-align" id="myBtn">
      Menu <i class="fa fa-caret-down"></i>
    </a>
    <div id="demoAcc" class="w3-bar-block w3-hide w3-padding-large w3-medium">
      <a href="logout.do" class="w3-bar-item w3-button">Log Out</a>
    </div>
  </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <div class="w3-bar-item w3-padding-24 w3-wide">Movie Ticket Booking</div>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  <!-- Top header -->
  <header class="w3-container w3-xlarge">
    <p class="w3-left"><b>Movies Now Showing</b></p>
  </header>

  <!-- Image header -->
  <div class="w3-display-container w3-container">
    <img src="images/movieTicketBooking.jpg" alt="Jeans" style="width:100%">
    <div class="w3-display-bottomright w3-text-white" style="padding:24px 48px">
      <p><a href="#jeans" class="w3-button w3-black w3-padding-large w3-large">BOOK NOW</a></p>
    </div>
  </div>

  <div class="w3-container w3-text-grey" id="jeans">
    <p>8 Movies</p>
  </div>

  <!-- Product grid -->
  <div class="w3-row w3-grayscale">
    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="images/kgf.jpg" style="width:100%">
        <p><b>KGF - Chapter 1</b><br></p>
        <form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="kgf">
          <Input type="Hidden" name="movieName"  id="movieName" value="KGF Chapter-1 (Kannada)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        <br><br>
      </div>
      <div class="w3-container">
        <img src="images/infinity.jpg" style="width:100%">
        <p><b>The Man Who Knew Infinity</b><br></p>
        <form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="infinity">
          <Input type="Hidden" name="movieName"  id="movieName" value="The Man Who Knew Infinity (English)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        <br><br>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-container">
          <img src="images/tenet.jpg" style="width:100%">
        </div>
        <p><b>Tenet</b><br></p>
        <form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="tenet">
          <Input type="Hidden" name="movieName"  id="movieName" value="Tenet (English)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        <br><br>
      </div>
      <div class="w3-container">
        <img src="images/jojo.jpg" style="width:100%">
        <p><b>JoJo Rabbit</b><br><br></p>
        <form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="jojo">
          <Input type="Hidden" name="movieName"  id="movieName" value="JOJO Rabbit (English)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        <br><br>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
      	<div class="w3-container">
        	<img src="images/parasite.jpg" style="width:100%">
        	<p><b>Parasite</b><br></p>
        	<form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="parasite">
          <Input type="Hidden" name="movieName"  id="movieName" value="Parasite (Korean)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        	<br><br>
        </div>
      </div>
      <div class="w3-container">
        <div class="w3-container">
          <img src="images/johnwick.jpg" style="width:100%">
        </div>
        <p><b>John Wick 3</b><br><br></p>
        <form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="johnwick">
          <Input type="Hidden" name="movieName"  id="movieName" value="John Wick - 3 (English)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        <br><br>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="images/lucia.jpg" style="width:100%">
        <p><b>Lucia</b><br></p>
        <form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="lucia">
          <Input type="Hidden" name="movieName"  id="movieName" value="Lucia (Kannada)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        <br><br>
      </div>
      <div class="w3-container">
        <img src="images/joker.jpg" style="width:100%">
        <p><b>Joker</b><br></p>
        <form action="openBookTicketView.do" method = "POST">
          <Input type="Hidden" name="movieImg"  id="movieImg" value="joker">
          <Input type="Hidden" name="movieName"  id="movieName" value="Joker (English)">
          <button type="submit" class="w3-button w3-black w3-padding-large w3-large">Book Show</button>
        </form>
        <br><br>
      </div>
    </div>
  </div>
  
  <!-- Footer -->
  <footer class="w3-padding-64 w3-light-grey w3-small w3-center" id="footer">
    <div class="w3-row-padding">
      

      <div class="w3-col s4 w3-justify">
        <p> © MovieTicketBooking</p>
        <p><b>By Sumukh M and Shrivathsa N V</b></p>
        <p><i class="fa fa-fw fa-envelope"></i> movieticketbooking@gmail.com</p>
        <h4>We accept</h4>
        <p><i class="fa fa-fw fa-cc-amex"></i> Amex</p>
        <p><i class="fa fa-fw fa-credit-card"></i> Credit Card</p>
        <br>
        <i class="fa fa-facebook-official w3-hover-opacity w3-large"></i>
        <i class="fa fa-instagram w3-hover-opacity w3-large"></i>
        <i class="fa fa-snapchat w3-hover-opacity w3-large"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity w3-large"></i>
        <i class="fa fa-twitter w3-hover-opacity w3-large"></i>
        <i class="fa fa-linkedin w3-hover-opacity w3-large"></i>
      </div>
    </div>
  </footer>
  <!-- End page content -->
</div>
<script>
// Accordion 
function myAccFunc() {
  var x = document.getElementById("demoAcc");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}

// Click on the "Jeans" link on page load to open the accordion for demo purposes
document.getElementById("myBtn").click();


// Open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}
</script>


</body>
</html>