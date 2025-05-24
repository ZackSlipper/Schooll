//Tab header items
function tabHeaderItemClick(index) {
	const tabHeaderItems = document.querySelectorAll('.tabheader__item');
	const tabContentItems = document.querySelectorAll('.tabcontent');

	tabHeaderItems.forEach(function (tabHeaderItem, i) {
		tabHeaderItem.classList.remove('tabheader__item_active');
		tabContentItems[i].style.display = 'none';
		if (index == i) {
			tabHeaderItem.classList.add('tabheader__item_active');
			tabContentItems[i].style.display = 'block';
		}
	});
}

//Offer slides
const offerSlides = document.querySelectorAll('.offer__slide');

function showOfferSlide(number) {
	const index = number - 1;
	offerSlides.forEach(function (offerSlide, i) {
		offerSlide.style.display = 'none';
		if (index == i)
			offerSlide.style.display = 'block';
	});

	document.querySelector('#current').innerHTML = '0' + number;
}

function offerSliderNext() {
	const total = parseInt(document.querySelector('#total').innerHTML);
	let current = parseInt(document.querySelector('#current').innerHTML) + 1;

	if (current > total)
		current = 1;
	showOfferSlide(current);
}

function offerSliderPrev() {
	const total = parseInt(document.querySelector('#total').innerHTML);
	let current = parseInt(document.querySelector('#current').innerHTML) - 1;

	if (current < 1)
		current = total;
	showOfferSlide(current);
}

//Startup initialization
tabHeaderItemClick(0);
showOfferSlide(3);