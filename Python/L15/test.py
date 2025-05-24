import turtle

s = turtle.Screen()
t = turtle.Turtle()

s.bgcolor("black")
s.title("Window ^-^")
colors = ["red", "blue", "green", "yellow", "purple", "orange"]
t.penup()
t.goto(0, -350)
t.pendown()
sk = 0
for i in range(64):
	t.pencolor(colors[sk%len(colors)])
	sk += 1
	t.fillcolor(colors[sk%len(colors)])
	t.begin_fill()
	for j in range(i):
		t.fd(100)
		t.left(360/i)
	t.end_fill()

s.exitonclick()