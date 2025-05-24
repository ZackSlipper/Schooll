x1 = int(input("Ivesktie kiek euru Petriukas idejo pirma savaite: "))
y1 = int(input("Ivesktie kiek centu Petriukas idejo pirma savaite: "))
x2 = int(input("Ivesktie kiek euru Petriukas idejo antra savaite: "))
y2 = int(input("Ivesktie kiek centu Petriukas idejo antra savaite: "))

total = (x1 + x2) * 100 + y1 + y2
eur = total // 100
cent = total % 100

print(f"Petriukas sutaupe {eur} eur. ir {cent} cnt.")