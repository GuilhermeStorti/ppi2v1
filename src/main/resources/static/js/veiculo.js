var app = angular.module('appVeiculos', []);

var ctrlVeiculos = appVeiculos.controller('CtrlVeiculos', function($scope, $http) {
   
	var urlBase = "http://localhost:8080/ppi2v1/veiculo";
	
	$scope.mostrar = function(){
		$http.get(url).then(
				function sucesso(response) {
						$scope.veiculos = response.data;
		}, function erro(response) {
			alert("ops!! erro na chamda get");
		}
	});

});
