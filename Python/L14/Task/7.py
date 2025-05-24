class Darbuotojas:
	def __init__(self, vardas : str, pareigos : str, atlyginimas : float):
		self._vardas = vardas
		self._pareigos = pareigos
		self._atlyginimas = atlyginimas

	@property
	def vardas(self):
		return self._vardas
	
	@vardas.setter
	def vardas(self, vardas):
		if not vardas:
			raise ValueError("Vardas negali buti tuscias.")
		self._vardas = vardas

	@property
	def pareigos(self):
		return self._pareigos
	
	@pareigos.setter
	def pareigos(self, pareigos):
		if not pareigos:
			raise ValueError("Pareigos negali buti tuscios.")
		self._pareigos = pareigos

	@property
	def atlyginimas(self):
		return self._atlyginimas
	
	@atlyginimas.setter
	def atlyginimas(self, atlyginimas):
		if self.ar_atlyginimas_teisingas(atlyginimas):
			self._atlyginimas = atlyginimas
		else:
			raise ValueError("Atlyginimas negali buti neigiamas.")
		
	def metinis_atlyginimas(self) -> float:
		return self.atlyginimas * 12

	@staticmethod
	def ar_atlyginimas_teisingas(atlyginimas: float) -> bool:
		return isinstance(atlyginimas, (int, float)) and atlyginimas > 0
	

darbuotojas = Darbuotojas("Jonas", "Programuotojas", 2000)
print(darbuotojas.metinis_atlyginimas())
darbuotojas.atlyginimas = -1000