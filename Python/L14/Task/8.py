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

	def __str__(self):
		return f"Knyga: {self.pavadinimas}, Autorius: {self.autorius}, Puslapiai: {self.puslapiu_skaicius}"

	@staticmethod
	def ar_puslapiai_teisingi(puslapiu_skaicius: int) -> bool:
		return isinstance(puslapiu_skaicius, int) and puslapiu_skaicius > 0


class Biblioteka:
	def __init__(self):
		self._knygos = []

	def prideti_knyga(self, knyga):
		if isinstance(knyga, Knyga):
			self._knygos.append(knyga)
		else:
			raise ValueError("Tai ne knyga")

	def rasti_knyga(self, knygos_pavadinimas):
		for knyga in self._knygos:
			if knyga.pavadinimas == knygos_pavadinimas:
				return knyga
		else:
			return None

	def pasalinti_knyga(self, knygos_pavadinimas):
		knyga = self.rasti_knyga(knygos_pavadinimas)
		if knyga:
			self._knygos.remove(knyga)
		else:
			print("Tokios knygos nera")

	def vidutinis_puslapiu_skaicius(self):
		if len(self._knygos) == 0:
			return 0
		return sum([knyga.puslapiu_skaicius for knyga in self._knygos]) // len(self._knygos)
	

biblioteka = Biblioteka()
biblioteka.prideti_knyga(Knyga("Haris Poteris", "J.K. Rowling", 300))
biblioteka.prideti_knyga(Knyga("LoTR", "J.R.R. Tolkien", 500))
print(biblioteka.vidutinis_puslapiu_skaicius())
biblioteka.pasalinti_knyga("LoTR")
print(biblioteka.rasti_knyga("Haris Poteris"))