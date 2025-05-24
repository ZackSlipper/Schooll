num = int(input("Enter a number with 5 digits: "))

sum = 0
sum += num % 10
print (num % 10)

num //= 10
sum += num % 10
print (num % 10)

num //= 10
sum += num % 10
print (num % 10)

num //= 10
sum += num % 10
print (num % 10)

num //= 10
sum += num % 10
print (num % 10)

print("The sum of the digits is: ", sum)