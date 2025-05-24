lastPage = int(input("Enter the last page number: "))

digits = 0
mod = 0
for i in range(1, lastPage + 1):
	while i > 0:
		i //= 10
		digits += 1
print(digits)