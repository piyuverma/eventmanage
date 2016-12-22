'use strict';
eventsApp.controller('EditEventController', function EditEventController($scope) {
        $scope.event = {
            name: '',
            date: '',
            time: '',
            location: {
                address: '',
                city: '',
                province: ''
            }
        };
        $scope.saveEvent = function (event, newEventForm) {
                window.alert("Event " + event.name + " saved successfully");
        };
        $scope.cancel = function () {
            $scope.event = '';

        };
    }
);