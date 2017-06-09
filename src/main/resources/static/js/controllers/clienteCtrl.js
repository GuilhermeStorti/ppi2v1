angular.module("appLocadora").controller("clienteCtrl", function ($scope, $http) {

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

    $scope.editar = function(){
        $http.put(url + "/" + $scope.cliente.idCliente, $scope.cliente).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao salvar cliente");
            }
        );
    };

    $scope.deletar = function()	{
        $http.delete(url + "/" + $scope.cliente.idCliente).then(
            function(response) {
                $scope.mostrar();
                $scope.limpar();
            },function(error) {
                alert("erro ao deletar cliente");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function(cliente) {
        $scope.cliente = angular.copy(cliente);
    };

    $scope.limpar = function () {
        $scope.cliente = null;
    };

});