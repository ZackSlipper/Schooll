primary_scale = input("Enter the primary scale: ")
temperature = float(input("Enter the temperature: "))
secondary_scale = input("Enter the secondary scale: ")

new_temperature = 0
if primary_scale == "C" and secondary_scale == "F":
	new_temperature = temperature * 1.8 + 32
elif primary_scale == "C" and secondary_scale == "K":
	new_temperature = temperature + 273.15
elif primary_scale == "F" and secondary_scale == "C":
	new_temperature = (temperature - 32) / 1.8
elif primary_scale == "F" and secondary_scale == "K":
	new_temperature = (temperature - 32) / 1.8 + 273.15
elif primary_scale == "K" and secondary_scale == "C":
	new_temperature = temperature - 273.15
elif primary_scale == "K" and secondary_scale == "F":
	new_temperature = (temperature - 273.15) * 1.8 + 32
elif primary_scale == secondary_scale:
	new_temperature = temperature
	print("The temperature is the same in both scales.")
else:
	print("Invalid scales.")
	exit()

print(f"{new_temperature} {secondary_scale}")