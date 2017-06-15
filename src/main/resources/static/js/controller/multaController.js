var app = angular.module("multaControllers", []);

app.controller("multaController", function($scope, $http) {
	
	var url = "http://localhost:8080/locacao/multas";
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : url
	    }).then(function mySucces(response) {
	        $scope.multas = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.novo = function() {
		$scope.multa = "";
	};
	
	$scope.salvar = function() {
		if(!$scope.multa.identifier) {
			$http.post(url + "/", $scope.multa)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de POST!");
			});
		} else {	
			$http.put(url + "/" + $scope.multa.identifier, $scope.multa)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
	};
	
	$scope.editar = function(multaSelecionada) {
		$scope.multa = angular.copy(multaSelecionada);
	}
	
	$scope.deletar = function(multaSelecionada) {
		if(window.confirm("Tem certeza?")) {
			$http.delete(url + "/" + multaSelecionada.identifier, multaSelecionada)
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