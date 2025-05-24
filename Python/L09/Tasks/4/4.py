passwords = []
with open('duom4.txt') as file:
	passwords = file.readlines()

def countUpper(password: str) -> int:
	count = 0
	for char in password:
		if char.isupper():
			count += 1
	return count

def countLower(password: str) -> int:
	count = 0
	for char in password:
		if char.islower():
			count += 1
	return count

def countDigits(password: str) -> int:
	count = 0
	for char in password:
		if char.isdigit():
			count += 1
	return count

def countSpecial(password: str) -> int:
	count = 0
	for char in password:
		if not char.isalnum():
			count += 1
	return count

def checkPassword(password: str) -> list:
	password = password.strip()
	errors = []

	if (len(password) < 12):
		errors.append("Slaptažodis per trumpas")
	if (countUpper(password) < 2):
		errors.append("Turi būti bent 2 didžiosios raidės")
	if (countLower(password) < 2):
		errors.append("Turi būti bent 2 mažosios raidės")
	if (countDigits(password) < 2):
		errors.append("Turi būti bent 2 skaičiai")
	if (countSpecial(password) < 2):
		errors.append("Turi būti bent 2 specialūs simboliai")

	return errors

def parseErrors(errors: list) -> str:
	if len(errors) == 0:
		return "Tinkamas"
	return "Netinkamas. " + ', '.join(errors)

result = []
for password in passwords:
	result.append(parseErrors(checkPassword(password)))

with open('rez4.txt', 'w') as file:
	file.write('\n'.join(result))