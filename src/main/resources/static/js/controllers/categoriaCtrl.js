angular.module("appLocadora").controller("categoriaCtrl", function ($scope, $http) {

    var url = "http://localhost:8080/ppi2v1/categoria/";

    $scope.mostrar = function()	{
        $http.get(url).then(
            function sucesso(response) {
                $scope.categorias = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get categoria");
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

    $scope.editar = function(){
        $http.put(url + "/" + $scope.categoria.idCategoria, $scope.categoria).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao salvar categoria");
            }
        );
    };

    $scope.deletar = function()	{
        $http.delete(url + "/" + $scope.categoria.idCategoria).then(
            function(response) {
                $scope.mostrar();
                $scope.limpar();
            },function(error) {
                alert("erro ao deletar categoria");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function(categoria) {
        $scope.categoria = angular.copy(categoria);
    };

    $scope.limpar = function () {
        $scope.categoria = null;
    };

});