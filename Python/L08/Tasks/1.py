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

def playGame():
	global playCount
	playCount += 1

	randomMax = enterNumber('Iveskite skaiciu nuo 1 iki 1000: ', 1, 1000)
	randomNumber = random.randint(1, randomMax)

	log(f"Sugeneruotas atsitiktinis skaicius: {randomNumber}")

	guessCount = 0
	while True:
		guess = enterNumber('Iveskite spejima: ', 1, randomMax)
		guessCount += 1

		if guess == randomNumber:
			log(f"{guessCount} spejimu vartotojas ivede {guess}. Atsakymas - atspejo skaiciu")
			print(f'Teisingai! Sugeneruotas skaicius buvo {randomNumber}')
			break
		elif guess < randomNumber:
			log(f"{guessCount} spejimu vartotojas ivede {guess}. Atsakymas - skaicius didesnis")
			print('Sugeneruotas skaicius didesnis')
		else:
			log(f"{guessCount} spejimu vartotojas ivede {guess}. Atsakymas - skaicius mazesnis")
			print('Sugeneruotas skaicius mazesnis')

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