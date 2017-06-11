angular.module("appLocadora").controller("funcionarioCtrl", function ($scope, $http) {

    var url = "http://localhost:8080/ppi2v1/funcionario";

    $scope.mostrar = function()	{
        $http.get(url).then(
            function sucesso(response) {
                $scope.funcionarios = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get funcionario");
            }
        )
    };

    $scope.salvar = function()	{
        $http.post(url, $scope.funcionario).then(
            function sucesso(response) {
                $scope.mostrar();
            }, function erro(response) {
                $scope.update();
            }
        )
    };

    $scope.editar = function(){
        $http.put(url + "/" + $scope.funcionario.idFuncionario, $scope.funcionario).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao salvar funcionario");
            }
        );
    };

    $scope.deletar = function()	{
        $http.delete(url + "/" + $scope.funcionario.idfuncionario).then(
            function(response) {
                $scope.mostrar();
                $scope.limpar();
            },function(error) {
                alert("erro ao deletar funcionario");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function(funcionario) {
        $scope.funcionario = angular.copy(funcionario);
    };

    $scope.limpar = function () {
        $scope.funcionario = null;
    };

});