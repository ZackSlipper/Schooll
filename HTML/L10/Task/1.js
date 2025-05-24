// 0 uzduotis

// Task 1
console.log("Task 1");
for (let i = 5; i <= 10; i++) {
	console.log(i);
}

//Task 2
console.log("Task 2");
for (let i = 20; i >= 10; i--) {
	if (i == 13)
		continue;
	console.log(i);
}

//Task 3
console.log("Task 3");
for (let i = 2; i <= 10; i++) {
	if (i % 2 == 0)
		console.log(i);
}

//Task 4
console.log("Task 4");
let i = 2;
while (i <= 16)
{
	if (i % 2 == 0) {
		i++;
		continue;
	}
	else
		console.log(i);
	i++;
}

//Task 5
console.log("Task 5");
let user = prompt("Kas bando prisijungti: (admin/cancel/[other text])");
if (user == "admin") {
	let passwd = prompt("Iveskite slaptazodi:");
	if (passwd == "Slapta123")
		alert("Sveikiname jus prisijungete");
	else if (passwd == "cancel")
		alert("Operacija atsaukta");
	else
		alert("Neteisingas slaptazodis");
} else if (user == "cancel")
	alert("Operacija atsaukta");
else
	alert("Vartotjas nenustatytas");