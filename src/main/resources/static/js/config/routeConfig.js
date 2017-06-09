angular.module("appLocadora").config(function ($routeProvider) {
    $routeProvider.when("/cliente", {
        templateUrl: "view/cliente.html",
        controller: "clienteCtrl"
    });
    $routeProvider.when("/categoria", {
        templateUrl: "view/categoria.html",
    });
    $routeProvider.otherwise({redirectTo: "#"});
});