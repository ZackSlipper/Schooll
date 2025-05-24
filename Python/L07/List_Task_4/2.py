a = input("Enter a list of numbers separated by space: ").split()
a = [int(i) for i in a]

b = input("Enter a second list of numbers separated by space: ").split()
b = [int(i) for i in b]

c = [i for i in a if i > 0] + [i for i in b if i < 0]
print(c)