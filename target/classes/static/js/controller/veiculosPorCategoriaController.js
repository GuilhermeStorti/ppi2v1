var app = angular.module("veiculosPorCategoriaControllers", []);

app.controller("veiculosPorCategoriaController", function($scope, $http) {
	
	$scope.listarCategorias = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/categorias"
	    }).then(function mySucces(response) {
	        $scope.categorias = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.pesquisar = function(categoriaSelecionada) {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/categorias/" + categoriaSelecionada.identifier + "/veiculos"
	    }).then(function mySucces(response) {
	        $scope.veiculos = response.data;
	        $scope.esconder = false;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	}
	
	$scope.ordenar = function(campo) {
        $scope.ordernarPor = campo;
    }
	
	$scope.listarCategorias();
	$scope.esconder = true;

});