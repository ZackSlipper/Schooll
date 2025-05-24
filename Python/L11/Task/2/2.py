def readExercises():
	exercises = {}
	with open('duom2.txt', 'r') as file:
		for line in file:
			exerciseData = line.strip().split()
			exerciseName = exerciseData[0]
			exerciseCount = int(exerciseData[1])
			if exerciseName not in exercises:
				exercises[exerciseName] = exerciseCount
			else:
				exercises[exerciseName] += exerciseCount
	return exercises

def sortExercises(exercises):
	return dict(sorted(exercises.items(), key=lambda item: item[1], reverse=True))

def writeExercises(exercises):
	with open('rez.txt', 'w') as file:
		for exerciseName in exercises:
			file.write(f"{exerciseName} {exercises[exerciseName]}\n")

writeExercises(sortExercises(readExercises()))