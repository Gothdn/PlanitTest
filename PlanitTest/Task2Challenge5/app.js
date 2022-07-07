var app = angular.module('Challenge5', []);

app.controller('challenge5Controller', function($scope) {
	$scope.data = [
		{
			"name"			:	"John Citizen",
			"dob"			:	"14-03-1989",
			"nationality"	:	"Australian"
		},
		{
			"name"			:	"Oliver James",
			"dob"			:	"09-08-1996",
			"nationality"	:	"Australian"
		},
		{
			"name"			:	"Toan Nguyen",
			"dob"			:	"02-11-1975",
			"nationality"	:	"Vietnamese"
		},
		{
			"name"			:	"Jane Smiths",
			"dob"			:	"01-08-1945",
			"nationality"	:	"Australian"
		},
		{
			"name"			:	"John Citizen",
			"dob"			:	"14-02-2000",
			"nationality"	:	"Australian"
		},
		{
			"name"			:	"Zhen He",
			"dob"			:	"22-07-1983",
			"nationality"	:	"Chinese"
		},
		{
			"name"			:	"Janes Citizen",
			"dob"			:	"12-01-1977",
			"nationality"	:	"Australian"
		},
		{
			"name"			:	"Jack John",
			"dob"			:	"06-06-2001",
			"nationality"	:	"Italian"
		},
		{
			"name"			:	"Harry Robert",
			"dob"			:	"14-02-1989",
			"nationality"	:	"Australian"
		},
		{
			"name"			:	"Jack John",
			"dob"			:	"05-06-1995",
			"nationality"	:	"Greek"
		},
		{
			"name"			:	"Jacob Michael",
			"dob"			:	"08-02-1998",
			"nationality"	:	"Australian"
		}];
	$scope.tableStyle = function(person) {
		if (person.isShowingAge && person.isShowingDuplicate == true) {
			return "table-warning";
		}
		if (person.isShowingAge == true) {
			return "table-info";
		} else if (person.isShowingDuplicate) {
			return "table-danger";
		} else {
			return "table";
		}
	}
	
	$scope.showDuplicate = function() {
		if ($scope.isShowingDuplicate == false) {
			var seen = {};
			$scope.data.forEach(person => {
				(seen.hasOwnProperty(person.name) == true) ? (person.isShowingDuplicate = true) : (seen[person.name] = true);
			});
			$scope.isShowingDuplicate = true;
			$scope.showDuplicateText = "Hide Duplicate";
			$scope.showDuplicateStyle = "btn btn-danger btn-block";
		} else {
			$scope.data.forEach(person => {
				person.isShowingDuplicate = false;
			});
			$scope.isShowingDuplicate = false;
			$scope.showDuplicateText = "Highlight Duplicate";
			$scope.showDuplicateStyle = $scope.defaultButton;
		}
	}
	
	$scope.removeDuplicate = function() {
		var seen = {};
		$scope.data = $scope.data.filter(person => {
			return seen.hasOwnProperty(person.name) ? false : (seen[person.name] = true);
		});
		$scope.averageAge = $scope.calculateAverageAge();
	};
	
	$scope.calculateAverageAge = function() {
		var res = 0;
		var thisYear = new Date().getFullYear();
		$scope.data.forEach(person => {
			var nums = person.dob.split("-");
			res = res + thisYear - (new Date(parseInt(nums[2]), parseInt(nums[1]) - 1, parseInt(nums[0])).getFullYear());
		});
		return (res / $scope.data.length).toFixed(2);
	}
	
	$scope.showAgeLessThanN = function() {
		if ($scope.isShowingAgeLessThanN == false) {
			var thisYear = new Date().getFullYear();
			$scope.data.forEach(person => {
				var nums = person.dob.split("-");
				var age = thisYear - (new Date(parseInt(nums[2]), parseInt(nums[1]) - 1, parseInt(nums[0])).getFullYear());
				if (age < $scope.thresholdAge) {
					person.isShowingAge = true;
				};
			});
			$scope.isShowingAgeLessThanN = true;
			$scope.showingAgeLessThanNText = "Hide age highlight";
			$scope.showAgeLessThanNStyle = "btn btn-info btn-block";
		} else {
			$scope.data.forEach(person => {
				person.isShowingAge = false
			});
			$scope.isShowingAgeLessThanN = false;
			$scope.showingAgeLessThanNText = "Highlight people with age less than ";
			$scope.showAgeLessThanNStyle = $scope.defaultButton;
		}
	}
	
	$scope.showUniqueCountries = function () {
		if ($scope.isShowingUniqueCountry == false) {
			var seen = {};
			$scope.countries = [];
			$scope.data.forEach(person => {
				if (seen.hasOwnProperty(person.nationality) == true) {
					return false;
				} else {
					$scope.countries.push(person.nationality);
					seen[person.nationality] = true;
				}
			});
			$scope.isShowingUniqueCountry = true;
			$scope.showUniqueCountryText = "Hide unique countries list";
			$scope.showUniqueCountriesStyle = "btn btn-info btn-block";
		} else {
			$scope.isShowingUniqueCountry = false;
			$scope.showUniqueCountryText = "Show unique countries list";
			$scope.showUniqueCountriesStyle = $scope.defaultButton;
			$scope.countries = [];
		}
	}
	
	$scope.init = function () {
		$scope.defaultButton = "btn btn-primary btn-block";
		$scope.isShowingDuplicate = false;
		$scope.showDuplicateText = "Highlight duplicate";
		$scope.showDuplicateStyle = $scope.defaultButton;
		$scope.isShowingAgeLessThanN = false;
		$scope.showingAgeLessThanNText = "Highlight people with age less than ";
		$scope.thresholdAge = 30;
		$scope.showAgeLessThanNStyle = $scope.defaultButton;
		$scope.isShowingUniqueCountry = false;
		$scope.showUniqueCountryText = "Show unique countries list";
		$scope.countries = [];
		$scope.showUniqueCountriesStyle = $scope.defaultButton;
		$scope.data.forEach(person => {
			person.isShowingDuplicate = false;
			person.isShowingAge = false;
		});
		$scope.averageAge = $scope.calculateAverageAge();
	}
});