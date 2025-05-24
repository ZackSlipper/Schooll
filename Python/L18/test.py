import tkinter as tk

window = tk.Tk()
window.title("Test")
window.geometry("800x600")

input_field = tk.Entry(window)
#input_field.pack(side=tk.LEFT)
#input_field.place(x=10, y=10)
input_field.grid(row=0, column=0)

input_field2 = tk.Entry(window)
#input_field2.pack(side=tk.RIGHT)
#input_field2.place(x=10, y=100)
input_field2.grid(row=1, column=0)

button = tk.Button(window, text="Click me!", command='')
#button.pack(side=tk.TOP)
#button.place(x=250, y=10)
button.grid(row=0, column=1)

button2 = tk.Button(window, text="Click me 2!", command='')
#button2.pack(side=tk.BOTTOM)
#button2.place(x=250, y=100)
button2.grid(row=1, column=1)

window.mainloop()