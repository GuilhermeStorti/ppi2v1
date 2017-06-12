angular.module("appLocadora").controller("locacaoCtrl", function ($scope, $http) {

    var url = "http://localhost:8080/ppi2v1/locacao";

    $scope.mostrar = function()	{
        $http.get(url).then(
            function sucesso(response) {
                $scope.locacoes = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get locacao");
            }
        )
    };

    $scope.salvar = function()	{
        $http.post(url, $scope.locacao).then(
            function sucesso(response) {
                $scope.mostrar();
            }, function erro(response) {
                $scope.update();
            }
        )
    };

    $scope.editar = function(){
        $http.put(url + "/" + $scope.locacao.idLocacao, $scope.locacao).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao salvar locacao");
            }
        );
    };

    $scope.deletar = function()	{
        $http.delete(url + "/" + $scope.locacao.idLocacao).then(
            function(response) {
                $scope.mostrar();
                $scope.limpar();
            },function(error) {
                alert("erro ao deletar locacao");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function(locacao) {
        $scope.locacao = angular.copy(locacao);
    };

    $scope.limpar = function () {
        $scope.locacao = null;
    };

});