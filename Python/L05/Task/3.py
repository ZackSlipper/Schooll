digitCount = int(input("Enter the number of digits: "))

sum = 0
num = 7
for i in range(digitCount):
	print (num, end = " = " if i + 1 == digitCount else " + ")
	sum += num
	num = num * 10 + 7
print (sum)