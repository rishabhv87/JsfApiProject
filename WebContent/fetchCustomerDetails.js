
alert("Click alert detected");

var output = "ABC through js";
var htmlcontainerpl = document.getElementById("placeholder");
var btn = document.getElementById("btn");
document.getElementById("btn").addEventListener("click", function()
{
	document.getElementById("placeholder").innerHTML = "DEF";
}

  );