// Automobilio ir Elektromobilio klasės (jūsų jau sukurta kodas)

class Automobilis {

	#marke;
	#modelis;
	#metai;
	#kuras;

	constructor(marke, modelis, metai, kuras) {
		this.#marke = marke;
		this.#modelis = modelis;
		this.#metai = metai;
		this.#kuras = kuras;
	}

	get marke() {
		return this.#marke;
	}

	set marke(marke) {
		this.#marke = marke;
	}

	get modelis() {
		return this.#modelis;
	}

	set modelis(modelis) {
		this.#modelis = modelis;
	}

	get metai() {
		return this.#metai;
	}

	set metai(metai) {
		this.#metai = metai;
	}

	get kuras() {
		return this.#kuras;
	}

	set kuras(kuras) {
		this.#kuras = kuras;
	}

	pagreitinti(kiek) {
		this.#kuras -= kiek;
	}

	pradetiLenktynes(kitasAutomobilis) {
		lenktynes(this, kitasAutomobilis);
	}
}

class Elektromobilis extends Automobilis {

	constructor(marke, modelis, metai, baterija) {
		super(marke, modelis, metai, baterija);
	}

	get baterija() {
		return this.kuras;
	}

	set baterija(baterija) {
		this.kuras = baterija;
	}
}

// Sukurkite du automobilių objektus
const bmw = new Automobilis("BMW", "M3", 2022, 60);
const tesla = new Elektromobilis("Tesla", "Model S", 2023, 100);

// Lenktynių funkcija
function lenktynes(automobilis1, automobilis2) {
	let speed = prompt("Koks greitis?", 50);
	while (speed == "" || isNaN(speed) || speed <= 0) {
		alert("Neteisingai įvesti duomenys!");
		speed = prompt("Koks greitis?", 50);
	}

	if (automobilis1.kuras < speed || automobilis2.kuras < speed) {
		console.log("Nepakankamas kuro kiekis!");
		return;
	}

    console.log(" Lenktynės prasideda! ");

    automobilis1.pagreitinti(speed);
    automobilis2.pagreitinti(speed);

    console.log(automobilis1.kuras);
    console.log(automobilis2.baterija ? `Liko baterijos: ${automobilis2.baterija} kWh` : automobilis2.kuras);

    if (automobilis1.kuras > automobilis2.baterija) {
        console.log(` Nugalėtojas: ${automobilis1.marke} ${automobilis1.modelis}!`);
    } else {
        console.log(` Nugalėtojas: ${automobilis2.marke} ${automobilis2.modelis}!`);
    }
}

// Pradėkite lenktynes!
bmw.pradetiLenktynes(tesla);
