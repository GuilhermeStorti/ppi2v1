var app = angular.module("locacoesPorVeiculoControllers", []);

app.controller("locacoesPorVeiculoController", function($scope, $http) {
	
	$scope.listarVeiculos = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/veiculos"
	    }).then(function mySucces(response) {
	        $scope.veiculos = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.pesquisar = function(veiculoSelecionado) {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/veiculos/" + veiculoSelecionado.identifier + "/locacoes"
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
	
	$scope.listarVeiculos();
	$scope.esconder = true;

});