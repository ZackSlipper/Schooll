def readNextDataLine(file):
	line = file.readline()
	while not line.strip():
		line = file.readline()
	return line

def readStarterAndFinisherData() -> tuple:
	with open("duom3.txt", "r") as file:
		# Read starter data
		starterCount = int(readNextDataLine(file))
		starters = {}
		for _ in range(starterCount):
			starterData = readNextDataLine(file).strip()
			starterName = starterData[:20]
			starterData = starterData[20:].split()
			starters[starterName] = int(starterData[0]) * 60 * 60 + int(starterData[1]) * 60 + int(starterData[2])

		# Read finisher data
		finisherCount = int(readNextDataLine(file))
		finishers = {}
		for _ in range(finisherCount):
			finisherData = readNextDataLine(file).strip()
			finisherName = finisherData[:20]
			finisherData = finisherData[20:].split()
			finishers[finisherName] = int(finisherData[0]) * 60 * 60 + int(finisherData[1]) * 60 + int(finisherData[2])

		return (starters, finishers)

def calculateTotalTime(starterAndFinisherData: tuple) -> dict:
	starters, finishers = starterAndFinisherData
	totalTimes = {}
	for starter in starters:
		if starter in finishers:
			totalTimes[starter] = finishers[starter] - starters[starter]
		else:
			totalTimes[starter] = -1
	return totalTimes

def sortTotalTimes(totalTimes: dict) -> list:
	return sorted(totalTimes.items(), key=lambda x: x[1])

def writeTotalTimesToFile(totalTimes: list):
	with open("rez3.txt", "w") as file:
		for total in totalTimes:
			if total[1] != -1:
				file.write(f"{total[0]} {total[1]//60} {total[1]%60}\n")

		file.write("\n")
		for total in totalTimes:
			if total[1] == -1:
				file.write(f"{total[0]} Nebaige trasos\n")

writeTotalTimesToFile(sortTotalTimes(calculateTotalTime(readStarterAndFinisherData())))