angular.module('app', [ 'ui.router', 'app.controllers' ])

.config(function($stateProvider, $urlRouterProvider) {
	
	$urlRouterProvider.otherwise("/home0");
	
	$stateProvider
	.state('home', {
		url: "/home",
		templateUrl: "home.html"
	})
	.state('sobre', {
		url: "/sobre",
		templateUrl: "sobre.html"
	})
	.state('avaria', {
		url: "/avaria",
		templateUrl: "avaria.html",
		controller: "avariaController"
	})
	.state('multa', {
		url: "/multa",
		templateUrl: "multa.html",
		controller: "multaController"
	})
	.state('categoria', {
		url: "/categoria",
		templateUrl: "categoria.html",
		controller: "categoriaController"
	})
	.state('funcionario', {
		url: "/funcionario",
		templateUrl: "funcionario.html",
		controller: "funcionarioController"
	})
	.state('cliente', {
		url: "/cliente",
		templateUrl: "cliente.html",
		controller: "clienteController"
	})
	.state('veiculo', {
		url: "/veiculo",
		templateUrl: "veiculo.html",
		controller: "veiculoController"
	})
	.state('locacao', {
		url: "/locacao",
		templateUrl: "locacao.html",
		controller: "locacaoController"
	})
	.state('veiculosPorCategoria', {
		url: "/veiculosPorCategoria",
		templateUrl: "veiculosPorCategoria.html",
		controller: "veiculosPorCategoriaController"
	})
	.state('locacoesPorFuncionario', {
		url: "/locacoesPorFuncionario",
		templateUrl: "locacoesPorFuncionario.html",
		controller: "locacoesPorFuncionarioController"
	})
	.state('locacoesPorVeiculo', {
		url: "/locacoesPorVeiculo",
		templateUrl: "locacoesPorVeiculo.html",
		controller: "locacoesPorVeiculoController"
	})
	.state('locacoesPorMes', {
		url: "/locacoesPorMes",
		templateUrl: "locacoesPorMes.html",
		controller: "locacoesPorMesController"
	})
	.state('clienteMaisLocaMes', {
		url: "/clienteMaisLocaMes",
		templateUrl: "clienteMaisLocaMes.html",
		controller: "clienteMaisLocaMesController"
	})
	.state('multasPorLocacao', {
		url: "/multasPorLocacao",
		templateUrl: "multasPorLocacao.html",
		controller: "multasPorLocacaoController"
	})
	.state('avariasPorLocacao', {
		url: "/avariasPorLocacao",
		templateUrl: "avariasPorLocacao.html",
		controller: "avariasPorLocacaoController"
	})

});