// 2 uzduotis

function enterDataToMovieDB(personalMovieDB) {
	let lastMovie = prompt('Vienas is paskutiniu perziuretu filmu?');
	if (lastMovie == null || lastMovie.length > 50 || personalMovieDB.movies[lastMovie] != undefined) {
		alert('Netinkamas pavadinimas');
		enterDataToMovieDB(personalMovieDB);
		return;
	}

	let rating = prompt('Kaip jus ji vertintumete?');
	if (rating == null) {
		alert('Netinkamas ivertinimas');
		enterDataToMovieDB(personalMovieDB);
		return;
	}

	personalMovieDB.movies[lastMovie] = rating;
}

let numberOfFilms = prompt('Kiek filmu jus jau ziurejote?');
while (numberOfFilms == null || numberOfFilms == '' || isNaN(numberOfFilms)) {
	alert('Ivyko klaida');
	numberOfFilms = prompt('Kiek filmu jus jau ziurejote?');
}

let personalMovieDB = {
	count: numberOfFilms,
	movies: {},
	actors: {},
	genres: [],
	privat: false
};

for (let i = 0; i < numberOfFilms; i++)
	enterDataToMovieDB(personalMovieDB);

if (personalMovieDB.count < 10)
	alert('Jus ziurite nedaug filmu');
else if (personalMovieDB.count >= 10 && personalMovieDB.count < 30)
	alert('Jus klasikinis ziurovas');
else if (personalMovieDB.count >= 30)
	alert('Jus esate kino megejas');

console.log(personalMovieDB);
