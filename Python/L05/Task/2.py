count = 0
for i in range(1000, 10000):
	num1 = i // 100
	num2 = i % 100
	if (num1 + num2) ** 2 == i:
		count += 1
		print(i)

print(f"Skaiciai su savybe: {count}")