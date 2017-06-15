var app = angular.module("avariasPorLocacaoControllers", []);

app.controller("avariasPorLocacaoController", function($scope, $http) {
	
	$scope.listarLocacoes = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/locacoes"
	    }).then(function mySucces(response) {
	        $scope.locacoes = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.pesquisar = function(locacaoSelecionada) {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/locacoes/" + locacaoSelecionada.identifier + "/avarias"
	    }).then(function mySucces(response) {
	        $scope.avarias = response.data;
	        $scope.esconder = false;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	}
	
	$scope.ordenar = function(campo) {
        $scope.ordernarPor = campo;
    }
	
	$scope.listarLocacoes();
	$scope.esconder = true;

});