var app = angular.module('Challenge6', []);

app.controller('challenge6Controller', function($scope, $http) {
	$scope.init = function () {
		url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
		$scope.loadingText = "Loading..."
		$http.get(url).then(function(res) {
			pets = res.data;
			$scope.loadingText = "Loading done!";
			$scope.numPet = pets.length;
		});
	}
});