list = input("Enter a list of numbers separated by space: ").split()

# Convert each item to int type
list = [int(i) for i in list]
oddPositives = [i for i in list if i % 2 != 0 and i > 0]

# Sum of all positive odd numbers in the list
sum = 0
for i in oddPositives:
	sum += i

print("Sum of all positive odd numbers in the list is: ", sum)