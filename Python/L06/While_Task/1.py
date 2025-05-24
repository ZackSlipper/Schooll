coffeePrice = float(input("Enter the price of a coffee: "))
realCoinCount = 0
fakeCoinCount = 0

remainingPrice = int(coffeePrice * 100)
while remainingPrice > 0:
	coin = int(input("Enter a coin: "))
	if coin == 1 or coin == 2:
		coin *= 100
	elif coin != 10 and coin != 20 and coin != 50:
		print("Netinkama moneta. Meskite dar karta")
		fakeCoinCount += 1
		continue

	remainingPrice -= coin
	realCoinCount += 1
	if remainingPrice > 0:
		print(f"Remaining price: {remainingPrice/100} eur")

print()
if remainingPrice < 0:
	remainingPrice *= -1
	if remainingPrice >= 100:
		remainingPrice /= 100
		print(f"Graza: {remainingPrice} eur")
	else:
		print(f"Graza: {remainingPrice} ct")

print()
print("Skanios kavos")
print()
print("Real coins: ", realCoinCount)
print("Fake coins: ", fakeCoinCount)