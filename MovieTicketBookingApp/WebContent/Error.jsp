<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<style>
body, html {height: 100%}
body,h1,h2,h3,h4,h5,h6 {font-family: "Amatic SC", sans-serif}
.menu {display: none}
.bgimg {
  background-repeat: no-repeat;
  background-size: cover;
   
  min-height: 90%;
}
</style>
<body>


  
<!-- Header with image -->
<header class="bgimg w3-display-container w3-grayscale-min" id="home">
	
  <div class="w3-display-bottomleft w3-padding">
  </div>
  <div class="w3-display-center w3-center">
    <span class="w3-text-black w3-hide-small" style="font-size:100px">OOPS !! <br> ${errorMsg}</span>
    <span class="w3-text-black w3-hide-large w3-hide-large" style="font-size:60px"><b>OOPS !! <br>${errorMsg}</b></span>
    <p><a href="HomePage.html" class="w3-button w3-xxlarge w3-black">Click to back to HomePage</a></p>
  </div>
</header>



<!-- Footer -->
<footer class="w3-center w3-black w3-padding-48 w3-xxlarge">
 
</footer>

<script>
// Tabbed Menu
function openMenu(evt, menuName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("menu");
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
     tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
  }
  document.getElementById(menuName).style.display = "block";
  evt.currentTarget.firstElementChild.className += " w3-red";
}
document.getElementById("myLink").click();
</script>

</body>
</html>
