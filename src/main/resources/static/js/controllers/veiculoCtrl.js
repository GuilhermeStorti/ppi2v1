angular.module("appLocadora").controller("veiculoCtrl", function ($scope, $http) {

    var url = "http://localhost:8080/ppi2v1/veiculo";

    $scope.mostrar = function()	{
        $http.get(url).then(
            function sucesso(response) {
                $scope.veiculos = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get veiculo");
            }
        )
    };

    $scope.salvar = function()	{
        $http.post(url, $scope.veiculo).then(
            function sucesso(response) {
                $scope.mostrar();
            }, function erro(response) {
                $scope.update();
            }
        )
    };

    $scope.editar = function(){
        $http.put(url + "/" + $scope.veiculo.idVeiculo, $scope.veiculo).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao salvar veiculo");
            }
        );
    };

    $scope.deletar = function()	{
        $http.delete(url + "/" + $scope.veiculo.idVeiculo).then(
            function(response) {
                $scope.mostrar();
                $scope.limpar();
            },function(error) {
                alert("erro ao deletar veiculo");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function(veiculo) {
        $scope.veiculo = angular.copy(veiculo);
    };

    $scope.limpar = function () {
        $scope.veiculo = null;
    };

});