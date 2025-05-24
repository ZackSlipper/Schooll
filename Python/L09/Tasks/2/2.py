data = ''
with open('duom2.txt', 'r') as file:
	data = file.read()

encodingTable = (('a', 'ž'), ('a', 'z'), ('b', 'v'), ('c', 'u'), ('č', 'ū'), ('d', 'ų'), ('e', 't'), ('ę', 'š'), ('ė', 's'), ('f', 'r'), ('g', 'p'), ('h', 'o'), ('i', 'n'), ('į', 'm'), ('y', 'l'), ('j', 'k'))

def encode(data: str) -> str:
	newData = ''
	for i in range(len(data)):
		isUpper = data[i].isupper()
		char = data[i].lower()
		for j in range(len(encodingTable)):
			if char == encodingTable[j][0]:
				newData += encodingTable[j][1].upper() if isUpper else encodingTable[j][1]
				break
			elif char == encodingTable[j][1]:
				newData += encodingTable[j][0].upper() if isUpper else encodingTable[j][0]
				break
		else:
			newData += data[i]

	return newData

with open('rez2.txt', 'w') as file:
	file.write(encode(data))