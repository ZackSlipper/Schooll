class Knyga:
	def __init__(self, pavadinimas : str, autorius: str, puslapiu_skaicius: int):
		self._pavadinimas = pavadinimas
		self._autorius = autorius
		self._puslapiu_skaicius = puslapiu_skaicius

	#Create getters and setters
	@property
	def pavadinimas(self):
		return self._pavadinimas
	
	@pavadinimas.setter
	def pavadinimas(self, pavadinimas):
		if not pavadinimas:
			raise ValueError("Pavadinimas negali buti tuscias.")
		self._pavadinimas = pavadinimas

	@property
	def autorius(self):
		return self._autorius
	
	@autorius.setter
	def autorius(self, autorius):
		if not autorius:
			raise ValueError("Autoriaus vardas negali buti tuscias.")
		self._autorius = autorius
	
	@property
	def puslapiu_skaicius(self):
		return self._puslapiu_skaicius
	
	@puslapiu_skaicius.setter
	def puslapiu_skaicius(self, puslapiu_skaicius):
		if self.ar_puslapiai_teisingi(puslapiu_skaicius):
			self._puslapiu_skaicius = puslapiu_skaicius
		else:
			raise ValueError("Puslapiu skaicius turi buti teigiamas skaicius.")

	def vidutinis_teksto_ilgis(self, zodziu_skaicius: int) -> int:
		zodziai_puslapyje = zodziu_skaicius // self.puslapiu_skaicius
		print(f"{zodziai_puslapyje} zodziu per puslapi")
		return zodziai_puslapyje

	
	@staticmethod
	def ar_puslapiai_teisingi(puslapiu_skaicius: int) -> bool:
		return isinstance(puslapiu_skaicius, int) and puslapiu_skaicius > 0
	

knyga = Knyga("Haris Poteris", "J.K. Rowling", 300)
knyga.vidutinis_teksto_ilgis(90000)
knyga.puslapiu_skaicius = -10
