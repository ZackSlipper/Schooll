import turtle

s = turtle.Screen()
t = turtle.Turtle()

s.bgcolor("white")

t.pensize(2)
t.speed(0)
t.penup()
t.goto(-300, 900)

def draw_window():
	t.pendown()
	t.pencolor("black")
	t.fillcolor("white")
	t.begin_fill()
	
	t.pensize(5)
	t.forward(100)
	t.right(90)
	t.forward(150)
	t.right(90)
	t.forward(100)
	t.right(90)
	t.forward(150)

	t.end_fill()
	t.penup()

	t.pensize(2)
	t.right(180)
	t.forward(50)
	t.left(90)

	t.pendown()
	t.forward(100)
	t.penup()

	t.left(180)
	t.forward(50)
	t.left(90)
	t.pendown()
	t.forward(100)
	t.penup()

	t.right(90)
	t.forward(50)
	t.right(90)
	t.forward(150)
	t.right(90)

def draw_windows(count):
	for i in range(count):
		draw_window()
		t.forward(175)

	t.right(180)
	t.forward(175*count)
	t.right(180)
	
def draw_window_array(rows, columns):
	for i in range(rows):
		draw_windows(columns)
		t.right(90)
		t.forward(200)
		t.left(90)

	t.left(90)
	t.forward(200*rows)
	t.right(90)


t.goto(-300-35, 900+25)
t.pendown()
t.pencolor("blue")
t.fillcolor("lightblue")
t.begin_fill()

t.forward(175 * 6)
t.right(90)
t.forward(200 * 9)
t.right(90)
t.forward(175 * 6)
t.right(90)
t.forward(200 * 9)
t.right(90)

t.end_fill()
t.penup()

t.goto(-300, 900)
draw_window_array(9, 6)

s.exitonclick()