import random;

while True:

	# Input
	chosenValue = ""
	while True:
		chosenValue = input("Iveskite savo pasirinkima (zirkles, popierius, akmuo): ")
		if (chosenValue != "zirkles" and chosenValue != "popierius" and chosenValue != "akmuo"):
			print("Neteisingas pasirinkimas. Veskite is naujo.")
			continue
		break

	# Random computer value
	computerValue = random.choice(["zirkles", "popierius", "akmuo"])
	print("Kompiuteris pasirinko: ", computerValue)

	# Game logic
	if (chosenValue == computerValue):
		print("Rezultatas: Lygiosios")
	elif ((chosenValue == "zirkles" and computerValue == "popierius") or
	   (chosenValue == "popierius" and computerValue == "akmuo") or
	   (chosenValue == "akmuo" and computerValue == "zirkles")):
		print("Rezultatas: Laimejote!")
	else:
		print("Rezultatas: Pralaimejote")

	# Play again
	again = input("Ar norite zaisti dar karta? (T/N): ")
	if (again != "T" and again != "N"):
		while True:
			again = input("Neteisingas pasirinkimas. Veskite is naujo ar zaisti dar karta (T/N): ")
			if (again == "T" or again == "N"):
				break
			continue

	if (again == "N"):
		break