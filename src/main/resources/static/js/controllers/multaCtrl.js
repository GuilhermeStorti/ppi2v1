angular.module("appLocadora").controller("multaCtrl", function ($scope, $http) {

    var url = "http://localhost:8080/ppi2v1/multa";

    $scope.mostrar = function()	{
        $http.get(url).then(
            function sucesso(response) {
                $scope.multas = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get multa");
            }
        )
    };

    $scope.salvar = function()	{
        $http.post(url, $scope.multa).then(
            function sucesso(response) {
                $scope.mostrar();
            }, function erro(response) {
                $scope.update();
            }
        )
    };

    $scope.editar = function(){
        $http.put(url + "/" + $scope.multa.idMulta, $scope.multa).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao salvar multa");
            }
        );
    };

    $scope.deletar = function()	{
        $http.delete(url + "/" + $scope.multa.idMulta).then(
            function(response) {
                $scope.mostrar();
                $scope.limpar();
            },function(error) {
                alert("erro ao deletar multa");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function(multa) {
        $scope.multa = angular.copy(multa);
    };

    $scope.limpar = function () {
        $scope.multa = null;
    };

});