'use strict';
eventsApp.filter('durationFilter', function() {
	return function(duration) {

		switch (duration) {
		case 1:
			return "1:30 hr";
		case 2:
			return "2 hr";
		case 3:
			return "3 hr";
		case 4:
			return "4:30 hr";
		}
	}
});

eventsApp.filter('levelIconFilter', function() {
	return function(level) {
		switch (level) {
		case "Beginner":
			return "app/img/beginner.jpg";
		case "Intermediate":
			return "app/img/intermediate.jpg";
		case "Advanced":
			return "app/img/advanced.jpg";
		}
	}

});

eventsApp.filter('imageFilter', function() {

	return function(id) {

		var imagePath = "app/img/event" + id + ".jpg";
		return imagePath;
	}
});

