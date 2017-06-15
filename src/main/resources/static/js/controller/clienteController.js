var app = angular.module("clienteControllers", []);

app.controller("clienteController", function($scope, $http) {
	
	var url = "http://localhost:8080/locacao/clientes";
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : url
	    }).then(function mySucces(response) {
	        $scope.clientes = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.novo = function() {
		$scope.cliente = "";
	};
	
	$scope.salvar = function() {
		if(!$scope.cliente.identifier) {
			$http.post(url + "/", $scope.cliente)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de POST!");
			});
		} else {	
			$http.put(url + "/" + $scope.cliente.identifier, $scope.cliente)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
	};
	
	$scope.editar = function(clienteSelecionado) {
		$scope.cliente = angular.copy(clienteSelecionado);
	}
	
	$scope.deletar = function(clienteSelecionado) {
		if(window.confirm("Tem certeza?")) {
			$http.delete(url + "/" + clienteSelecionado.identifier, clienteSelecionado)
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