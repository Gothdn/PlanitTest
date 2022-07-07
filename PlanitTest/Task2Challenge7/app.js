//	Data generated from https://extendsclass.com/csv-generator.html

var app = angular.module('Challenge7', []);

app.controller('challenge7Controller', function($scope) {
	$scope.headers = [];
	$scope.search = {};
	
	fileSelected = function(file) {
		file.text().then(t => {
			$scope.data = $scope.parseCSV(t);
			console.log($scope.headers);
			$scope.$apply();
		});
	}
	
	$scope.test = function (t) {
		console.log($scope.search);
	}
	
	$scope.parseCSV = function (s) {
		var data = [];
		var word = false;
		var delim = ',';
		var row = 0;
		var col = 0;
		for (i = 0; i < s.length; i++) {
			cc = s[i];
			nc = s[i + 1];
			if (!(data[row])) {
				data[row] = [];
			}
			if (!(data[row][col])) {
				data[row][col] = "";
			}
			
			if (cc == '"' && nc == '"' && word) {
				data[row][col] += cc;
				i++;
			} else if (cc == '"') {
				word = !word;
			} else if (cc == delim && !word) {
				col++;
			} else if (cc == '\r' && nc == '\n') {
				row++;
				col = 0;
				i++;
			} else if (cc == '\r' || cc == '\n') {
				row++;
				col = 0;
			} else {
				data[row][col] += cc;
			}
		}
		$scope.headers = data[0];
		res = [];
		for (i = 1; i < data.length; i++) {
			d = {};
			for (j = 0; j < $scope.headers.length; j++) {
				d[$scope.headers[j]] = data[i][j];
			}
			res.push(d);
		}
		
		return res;
	}
});