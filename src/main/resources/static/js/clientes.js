var appClientes = angular.module('appClientes', []);

var ctrlClientes = appClientes.controller('ctrlClientes', function($scope, $http) {
	
	var url = "http://localhost:8080/ppi2v1/cliente";
	
	$scope.mostrar = function()	{
		$http.get(url).then(
				function sucesso(response) {
					$scope.clientes = response.data;
				}, function erro(response) {
					alert("ops!! erro na chamada get cliente");					
				}
			)		
	};

	$scope.salvar = function()	{
		$http.post(url, $scope.cliente).then(
			function sucesso(response) {
				$scope.mostrar();
			}, function erro(response) {
				$scope.update();
			}
		)
	};

	$scope.update = function(){
		$http.put(url, $scope.cliente).then(
			function sucesso(response) {
				$scope.mostrar();
			},function erro(response) {
					alert("erro ao salvar cliente");
			}
		);
	};

	$scope.deletar = function()	{
		$http(url + "/" + $scope.cliente.idCliente).then(
			function(response) {
				$scope.mostrar();
				$scope.novo();
			},function(error) {
				alert("erro ao deletar cliente");
			}
		);
	};	
			
	$scope.novo = function(){
		$scope.cliente = "";
	};		

	$scope.mostrar();

	$scope.seleciona = function(cliente) {
		$scope.cliente = angular.copy(cliente);	
	};

});
	


	
		

			
	
   

