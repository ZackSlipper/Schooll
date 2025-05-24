import time

# Decorator
def howMuchTime(func):
	def startEnd(*args, **kwargs):
		start = time.time()
		result = func(*args, **kwargs)
		end = time.time()
		print(f"Execution time for '{func.__name__}': {end - start} s")
		return result
	return startEnd

@howMuchTime
def sumFunc(n):
	sum = 0
	for i in range(n+1):
		sum += i
	return sum

print(sumFunc(1000000))


class Robot:
	HOURS_PER_YEAR = 200

	def __init__(self, name, age, enable, force):
		self._name = name
		self.age = age
		self.enable = enable
		self._force = force
		self.info(name, age, enable, force)

	@classmethod
	def cut(cls, line):
		name, age, enable, force = line.split(", ")
		age = int(age)
		enable = bool(enable)
		force = float(force[:-2])
		return cls(name, age, enable, force)
	
	@staticmethod
	def energyUnit():
		return "kWh"
	
	@staticmethod
	def energyPerYear(power):
		return power * Robot.HOURS_PER_YEAR

	def info(self, name, age, enable, force):
		print(f"Name: {name}, Age: {age}, Enable: {enable}, Force: {force}kW, will use in a year: {Robot.energyPerYear(force)}{Robot.energyUnit()}")

	@property
	def name(self):
		return self._name
	
	@property
	def force(self):
		return self._force
	
	@force.setter
	def force(self, value):
		if type(value) in (int, float):
			self._force = value
		else:
			raise ValueError("Force must be a number")

	@force.deleter
	def force(self):
		choice = input("Are you sure you want to delete the force? (y/n): ")
		if choice == "y":
			del self._force
			print("Force deleted")
		else:
			print("Force deletion canceled")


vacuum = Robot.cut("Xiaomi, 2, True, 0.47kW")
vacuum.force = 0.5
print(vacuum.force)
del vacuum.force
print(vacuum.force)

class Person:
	def __init__(self, name):
		self._name = name

	@property
	def name(self):
		return self._name
	
	@name.setter
	def name(self, value):
		if not value:
			raise ValueError("Name can't be empty")
		self._name = value

	@name.deleter
	def name(self):
		del self._name

p1 = Person("John")
p1.name = "Peter"
print(p1.name)


class Vacuum(Robot):
	def __init__(self, name, age, enable, force, color):
		super().__init__(name, age, enable, force)
		self._color = color

class WindowCleaningBot(Vacuum):
	def __init__(self, name, age, enable, force, color, weight):
		super().__init__(name, age, enable, force, color)
		self._weight = weight

	def __str__(self):
		return f"Object belong to class {self.__class__.__name__}\nwith name {self._name}"

vacuum = Vacuum("Xiaomi", 2, True, 0.47, "white")
windowVacuum = WindowCleaningBot("Xiaomi", 2, True, 0.47, "white", 2.5)
print(windowVacuum)