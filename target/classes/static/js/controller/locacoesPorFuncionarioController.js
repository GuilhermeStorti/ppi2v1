var app = angular.module("locacoesPorFuncionarioControllers", []);

app.controller("locacoesPorFuncionarioController", function($scope, $http) {
	
	$scope.listarFuncionarios = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/funcionarios"
	    }).then(function mySucces(response) {
	        $scope.funcionarios = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.pesquisar = function(funcionarioSelecionado) {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/funcionarios/" + funcionarioSelecionado.identifier + "/locacoes_cad"
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
	
	$scope.listarFuncionarios();
	$scope.esconder = true;

});