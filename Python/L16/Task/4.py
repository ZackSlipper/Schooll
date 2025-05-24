import random

n = random.randint(10, 30)
m = random.randint(10, 30)

A = [] #2D array
B = [] #Row averages

for i in range(n):
	A.append([])
	for j in range(m):
		A[i].append(random.randint(-100, 100))
	B.append(sum(A[i]) / len(A[i]))

with open('A.txt', 'w') as f:
	for row in A:
		for elem in row:
			f.write(f'{str(elem) + " ":>4}')
		f.write('\n')

	f.write('\n')
	for elem in B:
		f.write(f'{str(round(elem, 2)) + " ":>4}')
	f.write('\n')
