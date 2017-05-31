var appCategorias = angular.module('appCategoria', []);

var ctrlCategorias = appCategorias.controller('ctrlCategorias', function($scope, $http) {
	
	var url = "http://localhost:8080/ppi2v1/categoria";
	
	$scope.mostrar = function()	{
		$http.get(url).then(
				function sucesso(response) {
					$scope.categorias = response.data;
				}, function erro(response) {
					alert("ops!! erro na chamda get");					
				}
			)		
	};

	$scope.salvar = function()	{
		$http.post(url, $scope.categoria).then(
			function sucesso(response) {
				$scope.mostrar();
			}, function erro(response) {
				$scope.update();
			}
		)
	};



	$scope.update = function(){
		$http.put(url, $scope.categoria).then(
			function sucesso(response) {
				$scope.mostrar();
			},function erro(response) {
					alert("erro ao salvar");
			}
		);
	};			



	$scope.deletar = function()	{
		$http(url + "/" + $scope.categoria.idCategoria).then(
			function(response) {
				$scope.mostrar();
				$scope.novo();
			},function(error) {
				alert("erro ao deletar categoria");
			}
		);
	};	
			
	$scope.novo = function(){
		$scope.categoria = "";
	};		

	$scope.mostrar();

	$scope.seleciona = function(categoria) {
		$scope.categoria = angular.copy(categoria);	
	};

});
	


	
		

			
	
   

