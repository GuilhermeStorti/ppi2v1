var app = angular.module("categoriaControllers", []);

app.controller("categoriaController", function($scope, $http) {
	
	var url = "http://localhost:8080/locacao/categorias";
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : url
	    }).then(function mySucces(response) {
	        $scope.categorias = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.novo = function() {
		$scope.categoria = "";
	};
	
	$scope.salvar = function() {
		if(!$scope.categoria.identifier) {
			$http.post(url + "/", $scope.categoria)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de POST!");
			});
		} else {	
			$http.put(url + "/" + $scope.categoria.identifier, $scope.categoria)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
	};
	
	$scope.editar = function(categoriaSelecionada) {
		$scope.categoria = angular.copy(categoriaSelecionada);
	}
	
	$scope.deletar = function(categoriaSelecionada) {
		if(window.confirm("Tem certeza?")) {
			$http.delete(url + "/" + categoriaSelecionada.identifier, categoriaSelecionada)
				.then(function(response) {
				$scope.listar();
			}, function(response) {
				window.alert("Erro de DELETE!");
			});
		}
		
	};
	
	$scope.ordenar = function(campo) {
        $scope.ordernarPor = campo;
    }
	
	$scope.listar();

});