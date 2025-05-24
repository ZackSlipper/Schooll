const baseLevelXP = 100;
const killPerLevelXP = 25;

// Pagrindinė klasė Personažas
class Personažas {
	#jega;
	#xp;
	_gyvybes;

	constructor(vardas, lygis, gyvybes, jega) {
		this.vardas = vardas;
		this.lygis = lygis;
		this._gyvybes = gyvybes; //HP
		this.#jega = jega;
		this.#xp = 0;
		this._klase = "Nežinoma"; // Apsaugota savybė
	}

	// Getteris jėgai
	get jega() {
		return this.#jega;
	}

	// Setteris jėgai
	set jega(naujaJega) {
		if (naujaJega > 0) {
			this.#jega = naujaJega;
		} else {
			console.log("Jėga negali būti neigiama!");
		}
	}

	get xp() {
		return this.#xp;
	}

	gautiXP(xp) {
		this.#xp += xp;
		console.log(`${this.vardas} gavo ${xp} XP!`);

		while (this.#xp >= baseLevelXP * this.lygis) {
			this.#xp -= baseLevelXP * this.lygis;
			this.lygis++;
			console.log(`${this.vardas} pasiekė ${this.lygis} lygį!`);
		}
	}

	get gyvybes() {
		return this._gyvybes;
	}

	set gyvybes(naujosGyvybes) {
		this._gyvybes = naujosGyvybes;
	}

	// Puolimo metodas
	puolti(kitas) {
		kitas.gyvybes -= this.#jega;
		console.log(`${this.vardas} puolė ${kitas.vardas} ir padarė ${this.#jega} žalos!`);

		this.killCheck(kitas);
	}

	killCheck(kitas) { 
		if (kitas.gyvybes <= 0) {
			if (kitas instanceof Monstras) {
				this.gautiXP(kitas.siaubas * killPerLevelXP);
				return;
			}
			this.gautiXP(kitas.lygis * killPerLevelXP);
		}
	}
}

// Karys - paveldėta klasė
class Karys extends Personažas {
	constructor(vardas, lygis, gyvybes, jega, sarvai) {
		super(vardas, lygis, gyvybes, jega);
		this._klase = "Karys";
		this.sarvai = sarvai;
	}

	get gyvybes() {
		return this._gyvybes;
	}

	//Sarvu logika
	set gyvybes(naujosGyvybes) {
		let change = naujosGyvybes - this.gyvybes;
		if (change < 0) {
			if (this.sarvai >= Math.abs(change))
				this._gyvybes = naujosGyvybes;
			else
				this._gyvybes -= Math.abs(change) - this.sarvai;
		}
		else
			this._gyvybes = naujosGyvybes;
	}

	// Perrašome puolimo metodą
	puolti(kitas) {
		let papildomaJega = this.lygis * 2;
		let bendraZala = this.jega + papildomaJega;
		kitas.gyvybes -= bendraZala;
		console.log(`${this.vardas} puolė su kalaviju ir padarė ${bendraZala} žalos!`);

		this.killCheck(kitas);
	}
}

// Burtininkas - paveldėta klasė
class Burtininkas extends Personažas {
	constructor(vardas, lygis, gyvybes, jega, mana) {
		super(vardas, lygis, gyvybes, jega);
		this._klase = "Burtininkas";
		this.mana = mana;
	}

	get gyvybes() {
		return this._gyvybes;
	}

	set gyvybes(naujosGyvybes) {
		this._gyvybes = naujosGyvybes;
	}

	// Naujas metodas užkeikimui
	uzkeikimas(kitas) {
		if (this.mana >= 10) {
			let zala = this.jega * 2;
			kitas.gyvybes -= zala;
			this.mana -= 10;
			console.log(`${this.vardas} naudojo užkeikimą ir padarė ${zala} žalos! Mana liko: ${this.mana}`);
		} else {
			console.log(`${this.vardas} neturi pakankamai manų!`);
		}

		this.killCheck(kitas);
	}
}

// Vagis - paveldėta klasė
class Vagis extends Personažas {
	constructor(vardas, lygis, gyvybes, jega) {
		super(vardas, lygis, gyvybes, jega);
		this._klase = "Vagis";
	}

	get gyvybes() {
		return this._gyvybes;
	}

	set gyvybes(naujosGyvybes) {
		this._gyvybes = naujosGyvybes;
	}

	// Naujas metodas užkeikimui
	vogti(kitas) {
		if (kitas.mana > 0) {
			let zala = kitas.mana - this.jega > 0 ? this.jega : kitas.mana;

			kitas.mana -= zala;
			this.gyvybes += zala;

			console.log(`${this.vardas} pavoge ${zala} manos! Dabar turi ${this.gyvybes} HP.`);
		} else {
			let zala = kitas.gyvybes - this.jega > 0 ? this.jega : kitas.gyvybes;

			kitas.gyvybes -= zala;
			this.gyvybes += zala;

			console.log(`${this.vardas} pavoge ${zala} HP! Dabar turi ${this.gyvybes} HP.`);
		}

		this.killCheck(kitas);
	}
}

// Monstras
class Monstras {
	constructor(vardas, gyvybes, siaubas) {
		this.vardas = vardas;
		this.gyvybes = gyvybes;
		this.siaubas = siaubas;
	}

	// Puolimo metodas su 50% šansu dvigubai žalai
	puolti(kitas) {
		let zala = Math.random() < 0.5 ? this.siaubas * 2 : this.siaubas;
		kitas.gyvybes -= zala;
		console.log(`🧟‍♂️ Monstras ${this.vardas} puolė ir padarė ${zala} žalos!`);
	}
}

function zaidejasPuola(zaidejas, priesininkas) {
	let special = prompt("Ar naudoti specialųjį puolimą? (taip/ne; T/N)");
	while (special !== "taip" && special !== "ne" && special !== "T" && special !== "N")
		special = prompt("Neteisingai įvesta, bandykite dar kartą: (taip/ne; T/N)");

	if (special == "taip" || special == "T") {
		if (zaidejas instanceof Burtininkas) {
			zaidejas.uzkeikimas(priesininkas);
			return;
		}
		else if (zaidejas instanceof Vagis) {
			zaidejas.vogti(priesininkas);
			return;
		}
		console.log("🚫 Specialusis puolimas negalimas šiam personažui!");
	}
	zaidejas.puolti(priesininkas);
}

// Kova tarp personažų
function kova(personazas1, personazas2) {
	console.log("🔥 Kova prasideda!");

	while (personazas1.gyvybes > 0 && personazas2.gyvybes > 0) {
		zaidejasPuola(personazas1, personazas2);

		if (personazas2.gyvybes <= 0)
			break;

		personazas2.puolti(personazas1);
	}

	if (personazas1.gyvybes > 0) {
		console.log(`🏆 Nugalėtojas: ${personazas1.vardas}!`);
	} else {
		console.log(`🏆 Nugalėtojas: ${personazas2.vardas}!`);
	}
}

// Žaidėjų kūrimas
const karys = new Karys("Arthas", 5, 100, 15, 10);
const burtininkas = new Burtininkas("Merlin", 4, 80, 10, 50);
const vagis = new Vagis("Petras", 3, 60, 20);
const monstras = new Monstras("Drakonas", 150, 25);

// Pradėkime kovą!
kova(karys, monstras);
kova(burtininkas, monstras);
kova(vagis, monstras);
