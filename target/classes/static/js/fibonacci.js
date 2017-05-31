angular.module('fireApp')
.controller('HomeCtrl', ["$scope", "FibonacciSvc", function($scope, FibonacciSvc) {

	$scope.fibonacciSequence = [];

	$scope.printFibonacciLooping = function() {
		for(var i = 2; i <= 15; i++) {
			var num = FibonacciSvc.looping(i)
			console.info("Fibonacci: ", num)
			$scope.fibonacciSequence.push(num)
		}
	}
}])