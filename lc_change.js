var button = document.querySelectorAll(".btn-success");
for(var i = 0; i < button.length; i++) {
	button[i].style.background="white";
	button[i].style.border="0";
}
var buttonprim = document.querySelectorAll(".btn-primary");
for(var i = 0; i < buttonprim.length; i++) {
	buttonprim[i].style.background="white";
	buttonprim[i].style.border="0";
}
var buttonwarn = document.querySelectorAll(".btn-warning");
for(var i = 0; i < buttonwarn.length; i++) {
	buttonwarn[i].style.background="white";
	buttonwarn[i].style.border="0";
}
var anchor = document.querySelectorAll("a");
for(var i = 0; i < anchor.length; i++) {
	anchor[i].style.background="white";
//	anchor[i].style.color="white";
	anchor[i].style.border="0";
}
document.title="JAVA";

var p = document.querySelectorAll("p");
p[p.length - 1].textContent="";
p[6].innerHTML="";
p[8].innerHTML="";

var svg = document.querySelectorAll("svg");
for(var i = 0; i < svg.length; i++) {
	svg[i].remove();
}

document.getElementById("general_questions").querySelectorAll("span")[0].textContent = "";
document.getElementById("yes").innerHTML="";
document.getElementById("no").innerHTML="";
document.getElementsByClassName("iubenda-white")[0].innerHTML="";
document.getElementById("i_badge-link").innerHTML="";
