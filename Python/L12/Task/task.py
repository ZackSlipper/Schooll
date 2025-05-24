
import os

def readAllFiles(dirName: str) -> dict:
	"""
	Reads all files in the directory at 'dirName' and returns the content of the files in a dictionary where the key is the file name and the value is the content of the file.
	"""
	data = {}
	files = os.listdir(dirName)
	for file in files:
		# Read the content of the file
		with open(f"./{dirName}/{file}", "r") as f:
			data[file] = f.read()
	return data


def splitDataIntoLines(data: dict) -> dict:
	"""
	Splits the data into lines. Where the return value is a dictionary with the key being the file name and the value being a list of lines in the file.
	"""
	newData = {}
	for key, value in data.items():
		newData[key] = value.split("\n")
	return newData


def splitDataIntoTokens(data: dict) -> dict:
	"""
	Splits the data into tokens. Where the return value is a dictionary with the key being the file name and the value being a list of lines containing a list of tokens in the given line. Where a token is a tuple containing the token value and weather or not it is valid.
	"""
	newData = {}
	for key, value in data.items():
		newData[key] = []
		for line in value:
			tokens = []

			tokenValues = line.split(" ")
			tokenValues = list(filter(lambda x: x != "", tokenValues))

			for tokenValue in tokenValues:
				token = ""
				try:
					token = int(tokenValue)
					tokens.append((token, True))
				except ValueError:
					token = tokenValue
					tokens.append((token, False))
			newData[key].append(tokens)
	return newData


def witeAllInvalidTokensToFile(fileName: str, data: dict) -> None:
	"""
	Writes all invalid tokens to a file.
	"""
	with open(fileName, "w") as f:
		for key, value in data.items():
			for i in range(len(value)): # Iterate over the lines
				for j in range(len(value[i])): # Iterate over the tokens
					if not value[i][j][1]:
						f.write(f"Byloje {key}, eiluteje {i + 1}, zenkle {j + 1}, reiksme '{value[i][j][0]}' nera sveikas skaicius\n")


def getStatisticData(data: dict) -> dict:
	"""
	Returns a dictionary with the keys 'sum':<Value>, 'min':<Value>, 'minCount':<Value>, 'max':<Value>, 'maxCount':<Value>, 'count':[(Token, Count)].
	"""
	stats = {}
	sum = 0
	min = float("inf")
	max = float("-inf")
	count = {}

	for value in data.values():
		for line in value:
			for token in line:
				if token[1]:
					value = token[0]

					# Sum
					sum += value

					# Min
					if value < min:
						min = value
					
					# Max
					if value > max:
						max = value

					# Count
					if value in count:
						count[value] += 1
					else:
						count[value] = 1

	# Min and Max Counts
	minCount = count[min]
	maxCount = count[max]

	#Build the count list
	countList = []
	for key, value in count.items():
		countList.append((key, value))
	countList = sorted(countList, key=lambda x: (x[1], x[0]), reverse=True)

	# Set all the stats values
	stats['sum'] = sum
	stats['min'] = min
	stats['minCount'] = minCount
	stats['max'] = max
	stats['maxCount'] = maxCount
	stats['count'] = countList

	return stats


def writeStatsToFile(fileName: str, stats: dict) -> None:
	"""
	Writes the statistics to a file.
	"""
	with open(fileName, "w") as f:
		f.write(f"Suma: {stats['sum']}\n\n")
		f.write(f"Maziausias: {stats['min']} ({stats['minCount']} kartai)\n")
		f.write(f"Didziausias: {stats['max']} ({stats['maxCount']} kartai)\n\n")
		f.write("Skaiciu dazniai:\n")
		for token in stats['count']:
			f.write(f"{token[0]} - {token[1]} kartai\n")


data = splitDataIntoTokens(splitDataIntoLines(readAllFiles("klaidu taisymas")))
witeAllInvalidTokensToFile("klaidos.txt", data)

writeStatsToFile("rez.txt", getStatisticData(data))