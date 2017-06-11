angular.module("appLocadora").config(function ($routeProvider) {
    $routeProvider.when("/cliente", {
        templateUrl: "view/cliente.html",
        controller: "clienteCtrl"
    });
    $routeProvider.when("/avaria", {
        templateUrl: "view/avaria.html",
        controller: "avariaCtrl"
    });
    $routeProvider.when("/categoria", {
        templateUrl: "view/categoria.html",
        controller: "categoriaCtrl"
    });
    $routeProvider.when("/funcionario", {
        templateUrl: "view/funcionario.html",
        controller: "funcionarioCtrl"
    });
    $routeProvider.when("/locacao", {
        templateUrl: "view/locacao.html",
        controller: "locacaoCtrl"
    });
    $routeProvider.when("/veiculo", {
        templateUrl: "view/veiculo.html",
        controller: "veiculoCtrl"
    });
    $routeProvider.when("/multa", {
        templateUrl: "view/multa.html",
        controller: "multaCtrl"
    });
    $routeProvider.otherwise({redirectTo: "#"});
});