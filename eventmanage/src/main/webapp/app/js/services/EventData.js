/**
 * Created by pverma on 08-Mar-16.
 */
'use script';

eventsApp.factory('eventDataNew', function($http, $log) {
	return {

		getEventData : function(successcb) {

			$http({
				method : 'GET',
				url : 'http://localhost:8081/eventmanage/rest/getEvents'
			}).success(function(webResponse) {

				$log.info(webResponse.eventMap);
				$log.info('Ajax call was successful');
				successcb(webResponse);

			}).error(function(webResponse) {

				$log.warn('Error while making the ajax call.');

			});

		}

	}

});
