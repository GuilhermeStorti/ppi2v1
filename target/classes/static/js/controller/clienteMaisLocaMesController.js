var app = angular.module("clienteMaisLocaMesControllers", []);

app.controller("clienteMaisLocaMesController", function($scope, $http) {
	
	$scope.pesquisar = function(mes) {
		$scope.esconder = true;
		
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/locacoes/mes/" + mes + "/cliente"
	    }).then(function mySucces(response) {
	        $scope.cliente = response.data;
	        $scope.esconder = false;
	    });/*, function myError(response) {
	        window.alert("Erro de GET!");
	    });*/
	}
	
	$scope.esconder = true;

});