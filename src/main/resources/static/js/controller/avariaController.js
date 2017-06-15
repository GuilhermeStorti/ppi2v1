var app = angular.module("avariaControllers", []);

app.controller("avariaController", function($scope, $http) {
	
	var url = "http://localhost:8080/locacao/avarias";
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : url
	    }).then(function mySucces(response) {
	        $scope.avarias = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.novo = function() {
		$scope.avaria = "";
	};
	
	$scope.salvar = function() {
		if(!$scope.avaria.identifier) {
			$http.post(url + "/", $scope.avaria)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de POST!");
			});
		} else {	
			$http.put(url + "/" + $scope.avaria.identifier, $scope.avaria)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
	};
	
	$scope.editar = function(avariaSelecionada) {
		$scope.avaria = angular.copy(avariaSelecionada);
	}
	
	$scope.deletar = function(avariaSelecionada) {
		if(window.confirm("Tem certeza?")) {
			$http.delete(url + "/" + avariaSelecionada.identifier, avariaSelecionada)
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