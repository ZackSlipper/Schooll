// 1 uzduotis

function play() { 
	let n = prompt("Iveskite iki kurio bus generuojamas atsitiktinis skaicius:");
	let random = Math.floor(Math.random() * n) + 1;
	console.log("Random: " + random);

	let guessCount = 0;
	while (true) {
		let guess = prompt("Iveskite spejima:");
		
		if (guess == null) {
			alert("Sugeneruotas atsitiktinis skaicius buvo " + random + ". Jus atlikote " + guessCount + " spejimus. Deja laimeti nepavyko.");
			return;
		} else if (isNaN(guess)) {
			alert("Ivestas ne skaicius, bandykite dar karta");
			continue;
		}

		guessCount++;

		if (guess == random) {
			alert("Atspejote! Sugeneruotas skaicius buvo " + random + ". Jus atlikote " + guessCount + " spejimus.");
			return;
		} else {
			if (guess < random)
				alert("Skaicius mazesnis uz sugeneruota, bandykite dar karta");
			else
				alert("Skaicius didesnis uz sugeneruota, bandykite dar karta");
		}
	}
}

function runGame() {
	play();
	while (true) {
		let playAgain = prompt("Ar norite zaisti dar karta? (taip/ne)");
		if (playAgain == "ne" || playAgain == null)
			break;
		else if (playAgain != "taip")
			alert("Iveskite taip arba ne");
		else
			play();
	}
}

runGame();