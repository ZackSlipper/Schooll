def ReadStudentFile(filePath : str) -> dict:
	students = {}
	with open(filePath, "r") as file:
		for line in file.readlines():
			data = line.split(" ")
			students[data[0].strip()] = float(data[1].strip())
	return students

def ReadClassData() -> list:
	classes = []
	for i in range(1, 5):
		classes.append(ReadStudentFile(f"duom3_{i}.txt"))
	return classes

def GetAverageGrade(students : dict) -> float:
	total = 0
	for grade in students.values():
		total += grade
	return total / len(students)

def GetAverageForAllClasses(classes : list) -> float:
	total = 0
	count = 0
	for students in classes:
		for grade in students.values():
			total += grade
			count += 1
	return total / count

def RemoveLessThanAverageStudents(students : dict) -> dict:
	average = GetAverageGrade(students)
	for student in list(students.keys()):
		if students[student] < average:
			students.pop(student)
	return students

def GetAboveAverageForAllClasses(classes : list) -> dict:
	aboveAverage = {}
	average = GetAverageForAllClasses(classes)
	for students in classes:
		for student in students.keys():
			if students[student] > average:
				aboveAverage[student] = students[student]
	return aboveAverage

def SortStudentsByGrade(students : dict) -> dict:
	return dict(sorted(dict(sorted(students.items(), key = lambda item: item[0])).items(), key = lambda item: item[1], reverse=True))

def ClearResultFile(filePath : str):
	with open(filePath, "w") as file:
		file.write("")

def WriteClassToFile(filePath : str, title : str, students : dict):
	with open(filePath, "a") as file:
		file.write(f"{title}:\n")
		for student, grade in students.items():
			file.write(f"{student} {grade:.2f}\n")
		file.write("----------------------------\n")


resultFile = "rez3.txt"
ClearResultFile(resultFile)
classes = ReadClassData()
classIndex = 1
for cls in classes:
	cls = RemoveLessThanAverageStudents(cls)
	cls = SortStudentsByGrade(cls)
	WriteClassToFile(resultFile, f"Klase {classIndex}", cls)
	classIndex += 1

topStudents = GetAboveAverageForAllClasses(classes)
topStudents = SortStudentsByGrade(topStudents)
WriteClassToFile(resultFile, "Rezultatas", topStudents)

print(f"Results written to: {resultFile}")