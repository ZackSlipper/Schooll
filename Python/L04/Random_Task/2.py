import random

def printSeparatorLine():
	print()
	print("********************************")
	print()

# Game loop
maxTakableRocks = 3
while True:
	#Rules
	printSeparatorLine()

	print ("Keik akmenu galima paimti vienu ejimu (nuo 1 iki 5): ")
	while True:
		maxTakableRocks = int(input("Iveskite akmenu skaiciu: "))
		if (maxTakableRocks < 1 or maxTakableRocks > 5):
			print("Neteisingas pasirinkimas. Veskite is naujo.")
			continue
		break

	print()
	print (f"Vienu ejimu galima paimti iki {maxTakableRocks} akmenu")
	printSeparatorLine()
	print("Pradekime zaidima!")
	print()

	rockCount = random.randint(15, 30)
	print(f"Maise yra {rockCount} akmenu")
	print()

	while True:
		if rockCount < maxTakableRocks:
			maxTakableRocks = rockCount
		
		takenRocks = int(input(f"Kiek akmenu norite paimti ({"1-" if maxTakableRocks > 1 else ""}{maxTakableRocks}): "))
		while takenRocks < 1 or takenRocks > maxTakableRocks:
			print("Neteisingas pasirinkimas. Veskite is naujo.")
			takenRocks = int(input(f"Kiek akmenu norite paimti ({"1-" if maxTakableRocks > 1 else ""}{maxTakableRocks}): "))

		rockCount -= takenRocks
		if rockCount == 0:
			printSeparatorLine()
			print("Jus paemete paskutini akmeni! Jus laimejote!")
			printSeparatorLine()
			break

		print(f"Jus paemete {takenRocks}. Liko {rockCount} akmenu")
		print()

		# Computers turn
		if rockCount < maxTakableRocks:
			maxTakableRocks = rockCount
		
		takenRocks = random.randint(1, maxTakableRocks)

		rockCount -= takenRocks
		print(f"Kompiteris paeme {takenRocks} akmenis. Liko {rockCount} akmenu")
		print()

		if rockCount == 0:
			printSeparatorLine()
			print("Kompiteris paeme paskutini akmeni! Jus pralaimejote!")
			printSeparatorLine()
			break

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