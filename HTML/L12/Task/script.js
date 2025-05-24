//Task 1

function textYellow() {
	document.getElementById("text").style.color = "yellow";
}

function textGreen() {
	document.getElementById("text").style.color = "green";
}

function textRed() {
	document.getElementById("text").style.color = "red";
}

//Task 2

function imageResizeBigger() {
	const image = document.getElementById("image");
	if (image.width + 50 >= 500) {
		alert("Padidinti negalime");
		return;
	}

	image.style.width = (image.width + 50) + "px";
}

function imageResizeSmaller() {
	const image = document.getElementById("image");
	if (image.width - 50 <= 50) {
		alert("Sumažinti negalime");
		return;
	}

	image.style.width = (image.width - 50) + "px";
}

//Task 3

function imageColored() {
	const image = document.getElementById("image2");
	if (image.style.filter === "grayscale(0)") {
		alert("Paveiksliukas jau spalvotas");
		return;
	}

	image.style.filter = "grayscale(0)";
}

function imageGrayscale() {
	const image = document.getElementById("image2");
	if (image.style.filter === "grayscale(1)") {
		alert("Paveiksliukas jau nespalvotas");
		return;
	}

	image.style.filter = "grayscale(1)";
}

//Task 4

function changeTitle() {
	const title = document.getElementById("title");
	const titleInput = document.getElementById("titleInput");
	const titleText = titleInput.value;
	if (titleText.trim() === "") {
		alert("Įrašykite pavadinimą");
		return;
	}
	
	title.innerHTML = titleText;
	titleInput.value = "";
}