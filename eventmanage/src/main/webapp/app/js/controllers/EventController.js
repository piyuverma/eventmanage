'use strict';

eventsApp.controller('EventController', function EventController($scope, $log,
		eventDataNew) {

	/*
	 * $scope.event = eventDataNew2.getEventData(); $scope.event.then(function
	 * (event) {
	 * 
	 * console.log(event); $scope.event = event; }), function (status) {
	 * 
	 * console.log(status); };
	 */

	eventDataNew.getEventData(function(webResponse) {
		$scope.eventMap = webResponse.eventMap;

		$scope.events = [];
		$scope.sessions = [];
		var i = 0;
		for ( var event in $scope.eventMap) {
			console.log("Inside the loop");
			$scope.sessions[i] = $scope.eventMap[event];
			if ($scope.sessions[i].length > 0) {
				$scope.events[i] = $scope.sessions[i][0].eventInfoDto;
			}
			i++;
		}
	});

	/*
	 * $scope.event = eventDataNew3.getEventData();
	 */
	$scope.upVoteSession = function(session) {
		session.usersvotes++;

	};
	/*
	 * EventDataNew.getEventData(function (event) { $scope.event = event; });
	 */

	$scope.downVoteSession = function(session) {
		session.usersvotes--;

	};

	$scope.myInterval = 5000;
	$scope.noWrapSlides = false;
	$scope.active = 0;
	var slides = $scope.slides = [];
	var currIndex = 0;

	$scope.sortOrder = 'name';

	$scope.query = '';

	$scope.sessionname = '';

});