import math

a = int(input("Enter A: "))
c = int(input("Enter C: "))

b = math.sqrt(c**2 - a**2)
print ("The value of B is: ", b)
area = a * b / 2
print ("The area of the triangle is: ", area)
