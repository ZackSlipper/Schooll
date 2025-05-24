import random

playCount = 0
logFile = open('reg.txt', 'w', encoding='utf-8')

def log(message):
	global logFile
	logFile.write(f'{message}\n')

def enterNumber(message, min = None, max = None):
	number = input(message)
	try:
		number = int(number)
		if min is not None and number < min:
			print(f'Skaicius turi buti ne mazesnis uz {min}')
			return enterNumber(message, min, max)
		elif max is not None and number > max:
			print(f'Skaicius turi buti ne didesnis uz {max}')
			return enterNumber(message, min, max)
	except:
		print(f'Netinkamas skaicius')
		return enterNumber(message, min, max)
	
	# Log number
	log(f'"{message}" uzklausai vartotojas ivede skaiciu {number}')
	return number

def enterText(message):
	text = input(message)
	
	if len(text) == 0:
		print('Tekstas negali buti tuscias')
		return enterText(message)

	# Log text
	log(f'"{message}" uzklausai vartotojas ivede teksta {text}')
	return text

def randomName(exclude = None):
	names = ['Jonas', 'Petras', 'Antanas', 'Kazys', 'Kestas', 'Tomas',
		  'Gediminas', 'Rokas', 'Lukas', 'Mantas', 'Marius',
		  'Mindaugas', 'Tadas', 'Aurimas', 'Karolis', 'Paulius', 'Gintaras',
		  'Darius', 'Mantas', 'Vytas', 'Vytautas', 'Aurimas']
	if exclude is not None and exclude in names:
		names.remove(exclude)
	return random.choice(names)

def playGame():
	global playCount
	playCount += 1

	stickCount = enterNumber('Iveskite lazdeliu kieki nuo 10 iki 25: ', 10, 25)
	playerName = enterText('Iveskite zaidejo varda: ')
	computerName = randomName(playerName)

	print(f"Kompiuterio zaidejo vardas: {computerName}")
	log(f"Kompiuterio zaidejo vardas: {computerName}")

	while stickCount > 0:
		# Players turn
		maxSticks = 3 if stickCount >= 3 else stickCount

		playerSticks = enterNumber(f"{playerName}, iveskite lazdeliu kieki nuo 1 iki {maxSticks}: ", 1, maxSticks)
		stickCount -= playerSticks
		print(f"{playerName} paeme {playerSticks} lazdeles. Likusiu lazdeliu kiekis: {stickCount}")
		log(f"{playerName} paeme {playerSticks} lazdeles. Likusiu lazdeliu kiekis: {stickCount}")

		if stickCount <= 0:
			print(f"Zaidima laimejo {computerName}!")
			log(f"Zaidima laimejo {computerName}!")
			break

		# Computers turn
		computerSticks = random.randint(1, 3)
		if (computerSticks > stickCount):
			computerSticks = stickCount
		stickCount -= computerSticks
		print(f"{computerName} paeme {computerSticks} lazdeles. Likusiu lazdeliu kiekis: {stickCount}")
		log(f"{computerName} paeme {computerSticks} lazdeles. Likusiu lazdeliu kiekis: {stickCount}")

		if stickCount <= 0:
			print(f"Zaidima laimejo {playerName}!")
			log(f"Zaidima laimejo {playerName}!")
			break

def playAgain():
	again = input('Ar norite zaisti dar karta? (T/N): ').lower()
	if again == 't':
		log(f'I uzkalusa "Ar zaisite dar" vartotojas pasirinko "Taip"')
		log("")
		return True
	elif again == 'n':
		log(f'I uzkalusa "Ar zaisite dar" vartotojas pasirinko "Ne"')
		log(f'Vartotojas zaide {playCount} kartus')
		print(f'Zaidimas baigtas.')
		return False
	else:
		print('Neteisingas pasirinkimas')
		return playAgain()

# Game replay loop	
while True:
	playGame()
	if not playAgain():
		break
logFile.close()