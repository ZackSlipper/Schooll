# Python Notes

## Number operators

* **\+** <----- addition
* **\-** <----- subtraction
* **\*** <----- multiplication
* **/** <----- division
* **%** <----- modulus
* **\*\*** <----- exponentiation
* **//** <----- floor division

## Converting a base10 number to binary

Number: 75

* 64 - 1
* 32 - 0
* 16 - 0
* 8 - 1
* 4 - 0
* 2 - 1
* 1 - 1

## Function definition and call

```python
def function_name(parameter1, parameter2 = 0): #Default parameter
	"""This is a function that adds two numbers""" #Documentation
	return parameter1 + parameter2
```

```python
result = function_name(5, 3)
result2 = function_name(parameter2=5, parameter1=3) #Named parameter
```

```python
def function_name(*args): #Variable number of arguments
	for arg in args:
		print(arg)
```

```python
def function_name(**kwargs): #Variable number of keyword arguments
	for key, value in kwargs.items():
		print(f"{key}: {value}")
```

```python
def function_name(parameter1, parameter2, *args, **kwargs): #Combining all types of arguments
	print(parameter1)
	print(parameter2)
	for arg in args:
		print(arg)
	for key, value in kwargs.items():
		print(f"{key}: {value}")
```

```python

## Print Function

```python
print("Hello World!") #output the given text to the console
```

```python
print("Hello World!", file="file_name") #output the given text to the file
```

```python
print("Text", end="") #output the given text without a newline
```

```python
print("Text", "more text", sep=" ") #output the given text concatenated with more text with a space separator
```

```python
print("Text \n more text") #output the given text with a newline
```

```python
print("Text " + "more text") #output the given text concatenated with more text (usage not recommended)
```

```python
print("Text", "more text") #output the given text concatenated with more text
```

```python
print(f"Text {variable} more text") #output the given text concatenated with a variable
```

```python
print(f"{variable:20}") #output the given variable with a width of 20
```

```python
print(f"{variable:^20}") #output the given variable centered with a width of 20
```

```python
print(f"{variable:<20}") #output the given variable left aligned with a width of 20
```

```python
print(f"{variable:>20}") #output the given variable right aligned with a width of 20
```

```python
print (f"{variable:.2f}") #output the given variable with 2 decimal places
```

## Variables And Types

```python
a = 5 #integer
b = 5.0 #float
c = "Hello World!" #string
d = True #boolean
e = None #null
f = [1, 2, 3] #list - mutable
g = (1, 2, 3) #tuple - immutable
h = {1, 2, 3} #set - unordered
i = {"name": "John", "age": 30} #dictionary
k = 5 + 3j #complex
l = b"Hello World!" #bytes
m = bytearray(5) #bytearray
n = memoryview(bytes(5)) #memoryview
o = range(5) #range
p = frozenset({1, 2, 3}) #frozenset
```

```python
print(type(a)) #output the type of the variable
```

### Variable Assignment

```python
a = b = c = 5
a, b, c = 5, 5.0, "Hello World!"

a, b = b, a #swap the values of a and b
```

### Constants

```python
PI = 3.14 #constant convention
```

## Input

```python
name = input("Enter your name: ") #get input from the user of type string
```

```python
age = int(input("Enter your age: ")) #get input from the user of type integer
```

## Lists

* Assigning one list variable to another list variable will create a reference to the original list

## Functions

```python
type(variable) #return the type of the variable
```

```python
id(variable) #return the memory address of the variable
```

```python
help(function) #return the documentation of the function
```

```python
bin(5) #return the binary representation of the given number
```

```python
oct(5) #return the octal representation of the given number
```

```python
hex(5) #return the hexadecimal representation of the given number
```

```python
min([1, 2, 3]) #return the minimum value of the given list
```

```python
max([1, 2, 3]) #return the maximum value of the given list
```

```python
sum([1, 2, 3]) #return the sum of the given list
```

## Math

```python
import math #import the math module
```

```python
math.factorial(5) #return the factorial of the given number
```

```python
math.sqrt(25) #return the square root of the given number
```

```python
math.pow(5, 2) #return the power of the given number
```

```python
math.pi #return the value of pi
math.e #return the value of e
```

```python
math.modf(5.5) #return the fractional and integer parts of the given number separtated into a tuple
```

```python
round([number], [decimal places]) #round the given number to the given decimal places
```

## Match Case

```python
match variable:
	case 1:
		print("One")
	case 2:
		print("Two")
	case 3:
		print("Three")
	case _:
		print("Something else")
```

## Loops

```python
for i in range(5): #for loop
	print(i)
```

```python
for i in range(5, 10): #for loop with a start and end
	print(i)
```

```python
for i in range(5, 10, 2): #for loop with a start, end, and step
	print(i)
```

```python
for i in range(10, 5, -1): #for loop with a start, end, and negative step
	print(i)
```

```python
for i in [1, 2, 3]: #for loop with a list
	print(i)
```

```python
for i in (1, 2, 3): #for loop with a tuple that prints 'Done' after the loop
	print(i)
else:
	print("Done")
```

## File Operations

```python
file = open("file_name", "r") #open a file in read mode
file.readline()
file.close()
```

```python
file = open("file_name", "w") #open a file in write mode
file.write("Hello World!")
```

```python
file = open("file_name", "a") #open a file in append mode
file.write("Hello World!")
```

```python
file = open("file_name", "r+") #open a file in read/write mode
file.write("Hello World!")
file.close()
```

```python
with open("file_name", "r") as file: #open a file using a context manager
	print(file.read())
```

```python
with open("file_name", "rb") as file: #open a file in binary mode
	print(file.read())
```

```python
with open("file_name", "wb") as file: #open a file in binary write mode
	file.write(b"Hello World!")
```

```python
with open("file_name", "ab") as file: #open a file in binary append mode
	file.write(b"Hello World!")
```

```python
with open("file_name", "r+b") as file: #open a file in binary read/write mode
	file.write(b"Hello World!")
```

```python
with open("file_name", "a+") as file: #open a file in append/read mode
	file.write("Hello World!")
	file.seek(0)
	print(file.read())
```

```python
with open("file_name", "x") as file: #open a file in exclusive creation mode
	file.write("Hello World!")
```

```python
try:
	file = open("file_name", "r")
finally:
	file.close()
```