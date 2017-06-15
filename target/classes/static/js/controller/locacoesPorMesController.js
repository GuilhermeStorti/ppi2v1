var app = angular.module("locacoesPorMesControllers", []);

app.controller("locacoesPorMesController", function($scope, $http) {
	
	$scope.pesquisar = function(mes) {	
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/locacoes/mes/" + mes
	    }).then(function mySucces(response) {
	        $scope.locacoes = response.data;
	        $scope.esconder = false;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	}
	
	$scope.ordenar = function(campo) {
        $scope.ordernarPor = campo;
    }
	
	$scope.esconder = true;

});