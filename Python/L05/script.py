num = int(input("Enter a number: "))

#Pyramid
for i in range(-num-1, num+1):
	for j in range(num - abs(i)+1):
		print(num - j, end=" ")
	print()

print()

#Square
print("*"*num)
for i in range(num-2):
	for j in range(num):
		if j == 0 or j == num-1:
			print("*", end="")
		else:
			print(" ", end="")
	print()
print("*"*num)

#Double Factorial
rez = 1
print(f"{num}!! = ", end="")
for i in range(2 if num % 2 == 0 else 1, num+1, 2):
	rez *= i
	print (i, end=" * " if i != num else " = ")
print(rez)
		