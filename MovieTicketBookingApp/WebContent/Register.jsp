<!DOCTYPE html>
<html>
<title>Registration</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
<body class="w3-light-grey">

<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-large">
  <a href="HomePage.html" class="w3-bar-item w3-button w3-red w3-mobile">Go Back</a>
</div>
<!-- Header -->
<header class="w3-display-container w3-content" style="max-width:1500px;">
  <img class="w3-image" src="images/register.jpg" alt="The Hotel" style="min-width:1000px" width="1500" height="800">
  <div class="w3-display-right w3-padding w3-col l6 m8">
    <div class="w3-container w3-red">
      <h2>Register</h2>
    </div>
    <div class="w3-container w3-white w3-padding-16">
      <form action="RegisterInt.jsp" method = "POST">
        <div class="w3-row-padding" style="margin:0 -16px;">
          <div class="w3-half w3-margin-bottom">
            <label><i class="fa fa-male"></i> First Name</label>
            <input class="w3-input w3-border" type="text" placeholder="First Name" name="fname" required>
          </div>
          <div class="w3-half">
            <label><i class="fa fa-male"></i> Last Name</label>
            <input class="w3-input w3-border" type="text" placeholder="Last Name" name="lname" required>
          </div>
        </div>
        <div class="w3-row-padding" style="margin:8px -16px;">
            <label><i class="fa fa-male"></i> Email</label>
            <input class="w3-input w3-border" type="text" placeholder="Email" name="email" required>
            <label><i class="fa fa-male"></i> Password</label>
            <input class="w3-input w3-border" type="password" placeholder="Password" name="pass" required>
            <label><i class="fa fa-male"></i> Re-Enter Password</label>
            <input class="w3-input w3-border" type="password" placeholder="Re-Enter Password" name="rpwd" required>
            <label><i class="fa fa-male"></i> Address</label>
            <input class="w3-input w3-border" type="text" placeholder="Address" name="address" required>
            <label><i class="fa fa-male"></i> Phone Number</label>
            <input class="w3-input w3-border" type="text" placeholder="Phone-No" name="phone_no" required>
        </div>
        <button class="w3-button w3-dark-grey" type="submit">REGISTER ! <br/>${errorMsg}</button>
      </form>
    </div>
  </div>
</header>



<!-- Footer -->
<footer class="w3-padding-32 w3-black w3-center w3-margin-top">
  <h5>Find Us On</h5>
  <div class="w3-xlarge w3-padding-16">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
  </div>
  
</footer>

<!-- Add Google Maps -->
<script>
function myMap() {
  myCenter=new google.maps.LatLng(41.878114, -87.629798);
  var mapOptions= {
    center:myCenter,
    zoom:12, scrollwheel: false, draggable: false,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapOptions);

  var marker = new google.maps.Marker({
    position: myCenter,
  });
  marker.setMap(map);
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->

</body>
</html>