angular.module('fireApp')
.controller('HomeCtrl', ["$scope", "FibonacciSvc", function($scope, FibonacciSvc) {

	// Array to push numbers into
	$scope.fibonacciSequence = [];

	// Function that creates Fibonacci numbers with looping
	$scope.printFibonacciLooping = function() {
		for(var i = 2; i <= 15; i++) {
			var num = FibonacciSvc.looping(i)
			console.info("Fibonacci: ", num)
			$scope.fibonacciSequence.push(num)
		}
	}


}])