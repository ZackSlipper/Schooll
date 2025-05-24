# Ported from my own implementation in C# (really don't feel like writing all THIS again -_-)

def tens(number):
	match number:
		case 2:
			return "dvidešimt"
		case 3:
			return "trisdešimt"
		case 4:
			return "keturiasdešimt"
		case 5:
			return "penkiasdešimt"
		case 6:
			return "šešiasdešimt"
		case 7:
			return "septyniasdešimt"
		case 8:
			return "aštuoniasdešimt"
		case 9:
			return "devyniasdešimt"
		case _:
			return ""

def upTo20(number):
	match number:
		case 1:
			return "vienas"
		case 2:
			return "du"
		case 3:
			return "trys"
		case 4:
			return "keturi"
		case 5:
			return "penki"
		case 6:
			return "šeši"
		case 7:
			return "septyni"
		case 8:
			return "aštuoni"
		case 9:
			return "devyni"
		case 10:
			return "dešimt"
		case 11:
			return "vienuolika"
		case 12:
			return "dvylika"
		case 13:
			return "trylika"
		case 14:
			return "keturiolika"
		case 15:
			return "penkiolika"
		case 16:
			return "šešiolika"
		case 17:
			return "septyniolika"
		case 18:
			return "aštuoniolika"
		case 19:
			return "devyniolika"
		case _:
			return ""

def fullHundreds(number, onePrefix = "", tenPrefix = "", finalPrefix = ""):
	_hundreds = number // 100 % 10
	_tens = number // 10 % 10
	_ones = number % 10

	tensStr = upTo20(_tens * 10 + _ones) if _tens < 2 else f"{tens(_tens)}{("" if _ones == 0 else f" {upTo20(_ones)}")}"
	hundredsStr = "" if _hundreds == 0 else "šimtas" if _hundreds == 1 else f"{upTo20(_hundreds)} šimtai"

	prefix = ""
	if number > 0:
		if number % 10 == 0 or number % 100 > 10 and number % 100 < 20:
			prefix = finalPrefix
		elif number % 10 == 1:
			prefix = onePrefix
		else:
			prefix = tenPrefix

	hasPrefixAndIsOne = prefix != "" and number % 10 == 1
	return f"{hundredsStr}{"" if _tens + _ones == 0 or hasPrefixAndIsOne else f" {tensStr}"}{"" if prefix == "" else f" {prefix}"}"


def convert(number):
	if number == 0:
		return "nulis"
	
	thousands = number // 1000
	millions = number // 1000000

	_fullHundreds = fullHundreds(number % 1000)
	_fullThousands = fullHundreds(thousands % 1000, "tūkstantis", "tūkstančiai", "tūkstančių")
	_fullMillions = fullHundreds(millions % 1000, "milijonas", "milijonai", "milijonų")

	result = ""
	if millions > 0:
		result += _fullMillions
	if thousands > 0:
		result += f"{_fullThousands} "
	result += _fullHundreds

	return result.strip()

def priceToWords(price: float):
	if (price > 100000):
		return "Per didelis skaičius"

	euros = int(price)
	cents = round((price - euros) * 100)

	eurosInWords = convert(euros)
	eurosInWords = eurosInWords[0].upper() + eurosInWords[1:]

	euroPrefix = "eurų" if euros % 10 == 0 or euros % 100 > 10 and euros % 100 < 20 else ("euras" if euros % 10 == 1 else "eurai")
	centPrefix = "centų" if cents % 10 == 0 or cents % 100 > 10 and cents % 100 < 20 else ("centas" if cents % 10 == 1 else "centai")

	return f"{eurosInWords} {euroPrefix}, {cents:00} {centPrefix}."

number = float(input("Enter a number: "))
print(priceToWords(number))