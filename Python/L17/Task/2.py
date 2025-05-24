import turtle

s = turtle.Screen()
t = turtle.Turtle()

s.bgcolor("yellow")

t.pensize(2)

def draw_hexagon(fillColor):
	t.pendown()
	t.pencolor("black")
	t.fillcolor(fillColor)
	t.begin_fill()
	for i in range(6):
		t.forward(100)
		t.left(60)
	t.end_fill()
	t.penup()

#Hex 1
draw_hexagon("red")

#Hex 2
t.right(120)
t.forward(100)
t.right(60)
t.forward(100)
t.right(180)
draw_hexagon("cyan")

#Hex 3
t.right(120)
t.forward(100)
t.left(60)
t.forward(100)
t.left(60)
draw_hexagon("magenta")

#Hex 4
t.forward(100)
t.right(60)
t.forward(100)
t.left(60)
draw_hexagon("green")

#Hex 5
t.forward(100)
t.left(60)
t.forward(100)
t.right(60)
draw_hexagon("red")

#Hex 6
t.left(120)
t.forward(100)
t.right(60)
t.forward(100)
t.right(60)
draw_hexagon("cyan")

s.exitonclick()