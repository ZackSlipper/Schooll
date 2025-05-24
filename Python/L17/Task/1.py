import turtle

s = turtle.Screen()
t = turtle.Turtle()

s.bgcolor("white")

def draw_square():
	colors = ["red", "cyan", "lime", "orange"]
	t.pendown()
	t.left(90)
	t.pensize(5)
	for i in range(4):
		t.pencolor(colors[i])
		t.forward(100)
		t.right(90)
	t.penup()
	t.right(90)
	t.forward(200)

for i in range(5):
	draw_square()

s.exitonclick()
