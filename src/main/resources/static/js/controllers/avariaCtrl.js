angular.module("appLocadora").controller("avariaCtrl", function ($scope, $http) {

    var url = "http://localhost:8080/ppi2v1/avaria";

    $scope.mostrar = function()	{
        $http.get(url).then(
            function sucesso(response) {
                $scope.avarias = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get avaria");
            }
        )
    };

    $scope.salvar = function()	{
        $http.post(url, $scope.avaria).then(
            function sucesso(response) {
                $scope.mostrar();
            }, function erro(response) {
                $scope.update();
            }
        )
    };

    $scope.editar = function(){
        $http.put(url + "/" + $scope.avaria.idAvaria, $scope.avaria).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao salvar avaria");
            }
        );
    };

    $scope.deletar = function()	{
        $http.delete(url + "/" + $scope.avaria.idAvaria).then(
            function(response) {
                $scope.mostrar();
                $scope.limpar();
            },function(error) {
                alert("erro ao deletar avaria");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function(avaria) {
        $scope.avaria = angular.copy(avaria);
    };

    $scope.limpar = function () {
        $scope.avaria = null;
    };

});