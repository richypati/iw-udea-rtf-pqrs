	var validationApp = angular.module('loginApp', []);
	validationApp.controller('loginController', function($scope) {
		$scope.submitForm = function(isValid) {
			if (isValid) {
				alert('our form is amazing');
			}

		};
		
		$scope.irA = function ( path ) {
			  $location.path( path );
			};

	});
