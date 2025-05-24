error_count = int(input("Enter the number of errors: "))

if error_count <= 2:
	print("Gerai")
elif error_count <= 7:
	print("Patenkinamai")
else:
	print("Nepatenkinamai")