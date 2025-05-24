k = float(input("Iveskite vieno smugio gili: "))
n = int(input("Vinies ilgi: "))

hitCount = 0
length = n
while length > 0:
	hitCount += 1
	length -= k
	if length <= 0:
		length = 0
	print(f"Tuk! {hitCount} {length}")

print(f"Vynis ikaltas")
