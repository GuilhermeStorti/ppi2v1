var app = angular.module("veiculoControllers", []);

app.controller("veiculoController", function($scope, $http) {
	
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
	
	var url = "http://localhost:8080/locacao/veiculos";
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : url
	    }).then(function mySucces(response) {
	        $scope.veiculos = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.novo = function() {
		$scope.veiculo = "";
		$scope.categoriaRepresentation = "";
	};
	
	$scope.salvar = function() {
		if(!$scope.veiculo.identifier) {
			$http.post(url + "/", $scope.veiculo)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de POST!");
			});
		} else {	
			$http.put(url + "/" + $scope.veiculo.identifier, $scope.veiculo)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
	};
	
	$scope.editar = function(veiculoSelecionado) {
		$scope.veiculo = angular.copy(veiculoSelecionado);
		$scope.categoriaRepresentation = veiculoSelecionado.categoriaRepresentation;
	}
	
	$scope.deletar = function(veiculoSelecionado) {
		if(window.confirm("Tem certeza?")) {
			$http.delete(url + "/" + veiculoSelecionado.identifier, veiculoSelecionado)
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
	
	$scope.$watch('categoriaRepresentation.identifier', function() {
		$scope.veiculo.categoriaRepresentation.identifier = $scope.categoriaRepresentation.identifier;
	});
	
	$scope.listarCategorias();
	$scope.listar();

});