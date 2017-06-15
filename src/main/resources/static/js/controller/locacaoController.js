var app = angular.module("locacaoControllers", []);

app.controller("locacaoController", function($scope, $http) {
	
	$scope.listarMultas = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/multas"
	    }).then(function mySucces(response) {
	        $scope.multas = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
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
	
	$scope.listarClientes = function() {
		$http({
	        method : "GET",
	        url : "http://localhost:8080/locacao/clientes"
	    }).then(function mySucces(response) {
	        $scope.clientes = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
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
	
	var url = "http://localhost:8080/locacao/locacoes";
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : url
	    }).then(function mySucces(response) {
	        $scope.locacoes = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.novo = function() {
		$scope.locacao = "";
		$scope.veiculoRepresentation = "";
		$scope.clienteRepresentation = "";
		$scope.funcionarioRepresentationCad = "";
		$scope.funcionarioRepresentationRec = "";
	};
	
	$scope.salvar = function() {
		if(!$scope.locacao.identifier) {
			$http.post(url + "/", $scope.locacao)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de POST!");
			});
		} else {	
			$http.put(url + "/" + $scope.locacao.identifier, $scope.locacao)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
		
		if ($scope.multa.identifier != null) {
			// /{id}/multas/{id2}
			// /2/multas/1
			$http.put(url + "/" + $scope.locacao.identifier + "/multas/" + $scope.multa.identifier, $scope.locacao)
				.then(function(response) {
				//$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
	};
	
	$scope.editarMulta = function() {
		$scope.listarMultas();
	}
	
	$scope.editar = function(locacaoSelecionada) {
		$scope.locacao = angular.copy(locacaoSelecionada);
		$scope.veiculoRepresentation = locacaoSelecionada.veiculoRepresentation;
		$scope.clienteRepresentation = locacaoSelecionada.clienteRepresentation;
		$scope.funcionarioRepresentationCad = locacaoSelecionada.funcionarioRepresentationCad;
		$scope.funcionarioRepresentationRec = locacaoSelecionada.funcionarioRepresentationRec;
	}
	
	$scope.deletar = function(locacaoSelecionada) {
		if(window.confirm("Tem certeza?")) {
			$http.delete(url + "/" + locacaoSelecionada.identifier, locacaoSelecionada)
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
	
	$scope.$watch('veiculoRepresentation.identifier', function() {
		$scope.locacao.veiculoRepresentation.identifier = $scope.veiculoRepresentation.identifier;
	});
	
	$scope.$watch('clienteRepresentation.identifier', function() {
		$scope.locacao.clienteRepresentation.identifier = $scope.clienteRepresentation.identifier;
	});
	
	$scope.$watch('funcionarioRepresentationCad.identifier', function() {
		$scope.locacao.funcionarioRepresentationCad.identifier = $scope.funcionarioRepresentationCad.identifier;
	});
	
	$scope.$watch('funcionarioRepresentationRec.identifier', function() {
		$scope.locacao.funcionarioRepresentationRec.identifier = $scope.funcionarioRepresentationRec.identifier;
	});
	
	$scope.listarVeiculos();
	$scope.listarClientes();
	$scope.listarFuncionarios();
	$scope.listar();

});