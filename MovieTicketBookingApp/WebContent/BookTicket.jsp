<!DOCTYPE html>
<html>
<title>Show Booking</title>
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
    <h3 class="w3-wide"><b>Book Show</b></h3>
  </div>
  <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
    <a href="Menu.jsp" class="w3-bar-item w3-button">Go Back</a>
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
    <p class="w3-left"></p>
  </header>


  <!-- Product grid -->
  <div class="w3-row w3-grayscale">
  <div class="w3-col l3 s6">
      <div class="w3-container">
      </div>
      <div class="w3-container">
       </div>
    </div>
    <div class="w3-col l3 s6">
      <div class="w3-container">
      <div class="w3-display-topleft w3-padding w3-col l6 m8">
        <img src="images/${Img}.jpg" style="width:100%">
        <p><b>${Name}</b><br><br></p>
       </div>
       <div class="w3-display-topright w3-padding w3-col l6 m8">
        <form action="BookTicketInt.jsp" method = "POST">
          Number of Tickets:<p><input class="w3-input w3-border" type="text" placeholder="no_of_tickets" name="no_of_tickets" required></p>
          Date:<p><input class="w3-input w3-border" type="text" placeholder="DD/MM/YYYY" name="date" required></p>
          Timings:<p><input class="w3-input w3-border" type="text" placeholder="HH:MM" name="start_time" required></p>
          Theatre Name:<p><input class="w3-input w3-border" type="text" placeholder="Theatre" name="t_name" required></p>
          Location:<p><input class="w3-input w3-border" type="text" placeholder="Location" name="location" required></p>
          Seat NO:<p><input class="w3-input w3-border" type="text" placeholder="Seat No" name="seat_no" required></p>
          Seat Row:<p><input class="w3-input w3-border" type="text" placeholder="Seat Row" name="seat_row" required></p>
          <Input type="Hidden" name="mov_name"  id="mov_name" value="${Name}">
          <Input type="Hidden" name="email"  id="email" value="${user}">
          <% String generate = String.valueOf((int)(Math.random()*Math.pow(10,7))); %>
          <Input type="Hidden" name="ticket_id"  id="ticket_id" value= <%=generate%> >
          <button type="submit" class="w3-button w3-block w3-black">Book</button>
        </form>
        <br><br>
        <br><br>
        </div>
    </div>
  </div>
  </div>
  
  <!-- Footer -->
  
  <!-- End page content -->
</div>


</body>
</html>