n = int(input("Enter how many numbers should be counted: "))

result = 1
div = 3
for i in range(0, n):
	if (i % 2 == 0):
		result -= 1/div
	else:
		result += 1/div
	div += 2
result *= 4
print(f"Pi = {result}")