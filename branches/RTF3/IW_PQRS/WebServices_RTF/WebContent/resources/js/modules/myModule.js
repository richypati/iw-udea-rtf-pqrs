//Se crea el modulo y se le inyecta ngRoute que nos permite tener varias vistas
var iwApp = angular.module('iwApp', [ 'ngRoute', 'ngCookies', 'ngDialog', ]);

// URLs de los servicios REST
var URL_PATH = "http://localhost:8080/WebServices_RTF/rest";
var URL_SERVICIO_CONSULTAR_SOLICITUD = URL_PATH
		+ "/solicitud/consultarSolicitud";
var URL_SERVICIO_CONSULTAR_POR_ESTADO = URL_PATH
		+ "/solicitud/consultarPorEstado";
var URL_SERVICIO_ASIGNAR_SOLICITUD = URL_PATH
		+ "/solicitud/asignarSolicitudAAnalista";
var URL_SERVICIO_OBTENER_SOLICITUD_POR_ANALISTA = URL_PATH
		+ "/solicitud/obtenerSolicitudesPorAnalista";
var URL_SERVICIO_REALIZAR_SOLICITUD = URL_PATH + "/solicitud/realizarSolicitud";
var URL_SERVICIO_CONSULTAR_PRODUCTOS = URL_PATH + "/producto/consultarTodos";
var URL_SERVICIO_CONSULTAR_ANALISTAS = URL_PATH + "/analista/consultarTodos";
var URL_SERVICIO_VALIDAR_CLIENTE = URL_PATH + "/cliente/validarCliente";

// ESTADOS DE SOLICITUD
var ABIERTO = "ABIERTO";
var RESUELTO = "RESUELTO";

// Factory para el login
iwApp.factory('auth', function($cookies, $location) {
	return {

		login : function(email, pws) {
			// creamos la cookie con el nombre que nos han pasado
			alert("EMAIL: " + email);

			$cookies.emailCliente = email;
			$cookies.password = pws;
			// mandamos a la lista de clientes
			//$location.url('/consultarSolicitud');
		},

		validarEstado : function() {

			alert("COOKIE: " + $cookies.emailCliente);
			if (typeof ($cookies.emailCliente) == 'undefined') {
				$location.url('/');
			}
			// en el caso de que intente acceder al login y ya haya iniciado
			// sesi�n lo mandamos a la lista de clientes
			if (typeof ($cookies.emailCliente) != 'undefined'
					&& $location.url() == '/') {
				$location.url('/consultarSolicitud');
			}
		}
	};
});

// Configura las vistas del aplicativo
iwApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'home.html', // Cuando se carga la raiz del
		// aplicativo se carga en la vista
		// la lista de clientes
		controller : 'ctrlrLogin'
	});

	$routeProvider.when('/consultarSolicitud', {
		templateUrl : 'resources/html/consultarSolicitud.html', // Cuando se
		// carga la raiz
		// del
		// aplicativo se carga en la vista
		// la lista de clientes
		controller : 'ctrlrSolicitudes'
	});
} ]);

// Servicio Angular encargado de llamar los Servicios Web de Clientes
iwApp.service('Clientes', function($http) {
	// Llama el servicio web para validar el usuario y la contrase�a
	this.validar = function(email, contrasena) {
		return $http({
			method : 'GET',
			url : URL_SERVICIO_VALIDAR_CLIENTE,
			params : {
				emailCliente : email,
				password : contrasena
			}
		});
	};

});

// Servicio Angular encargado de llamar los Servicios Web de Productos
iwApp.service('Productos', function($http) {
	// Método para consultar todos los productos
	this.consultarProductos = function() {
		return $http({
			method : 'GET',
			url : URL_SERVICIO_CONSULTAR_PRODUCTOS,
		});
	};
});

// Servicio Angular encargado de llamar los Servicios Web de Analista
iwApp.service('Analistas', function($http) {
	// Método para consultar los analistas
	this.consultarAnalistas = function() {
		return $http({
			method : 'GET',
			url : URL_SERVICIO_CONSULTAR_ANALISTAS
		});
	};
});

// Servicio Angular encargado de llamar los Servicios Web de Solicitud
iwApp.service('Solicitudes', function($http) {

	// Método para consultar una solicitud por ID
	this.consultarSolicitud = function(id) {
		return $http({
			method : 'GET',
			url : URL_SERVICIO_CONSULTAR_SOLICITUD,
			params : {
				id : id
			}
		});
	};

	// Método para consultar solicitudes por Estado
	this.consultarSolicitudesPorEstado = function(estado) {
		return $http({
			method : 'GET',
			url : URL_SERVICIO_CONSULTAR_POR_ESTADO,
			params : {
				estado : estado
			}
		});
	};

	// Método para consultar solicitudes por Analista
	this.obtenerSolicitudesPorAnalista = function(dni) {
		return $http({
			method : 'GET',
			url : URL_SERVICIO_OBTENER_SOLICITUD_POR_ANALISTA,
			params : {
				dni : dni
			}
		});
	};

	// Método para asignar cierta solicitud a un analista
	this.asignarSolicitudAAnalista = function(idSolicitud, dniAnalista) {
		return $http({
			method : 'GET',
			url : URL_SERVICIO_ASIGNAR_SOLICITUD,
			params : {
				idSolicitud : idSolicitud,
				dniAnalista : dniAnalista
			}
		});
	};

	// Método para realizar una solicitud
	this.realizarSolicitud = function(solicitudWS) {
		return $http({
			method : 'POST',
			url : URL_SERVICIO_REALIZAR_SOLICITUD,
			data : {
				codigoProducto : solicitudWS.codigoProducto,
				dniAnalista : solicitudWS.dniAnalista,
				tipo : solicitudWS.tipo,
				descripcion : solicitudWS.descripcion,
				tipoDocumento : solicitudWS.tipoDocumento,
				nombreCliente : solicitudWS.nombreCliente,
				emailCliente : solicitudWS.emailCliente,
			}
		});
	};
});

// Controlador Productos
iwApp.controller('ctrlrProductos', function($scope, Productos) {

	$scope.consultarProductos = function() {
		Productos.consultarProductos().success(function(data) {
			$scope.productos = data;
		});
	}
});

// Controlador Analistas
iwApp.controller('ctrlrAnalistas', function($scope, Analistas, ngDialog) {

	$scope.consultarAnalistas = function() {
		Analistas.consultarAnalistas().success(function(data) {
			$scope.analistas = data;
			ngDialog.open({ template: 'enviar',
				closeByEscape: false});
		}).error(function(data, status) {
            $scope.data = data || "Peticion fallida";
            $scope.status = status;
            ngDialog.open({ template: 'enviarError',
            				closeByEscape: false});
		});
	}
});


// Controlador Solicitudes
iwApp.controller('ctrlrSolicitudes', function($scope, Solicitudes, ngDialog) {

	$scope.solicitudRealizada = false;
	$scope.solicitudDelegada = false;
	$scope.solicitudWS = {
		codigoProducto : '',
		dniAnalista : '',
		tipo : '',
		descripcion : '',
		tipoDocumento : '',
		nombreCliente : '',
		emailCliente : '',
	};

	// CONSULTAR SOLICITUD
	$scope.consultarSolicitud = function() {
		Solicitudes.consultarSolicitud($scope.idSolicitud).success(
				function(data) {
					$scope.solicitud = data;
				});
	};

	// CONSULTAR SOLICITUDES ABIERTAS
	$scope.consultarSolicitudesAbiertas = function() {
		Solicitudes.consultarSolicitudesPorEstado(ABIERTO).success(
				function(data) {
					$scope.solicitudes = data;
				});
	};

	// CONSULTAR SOLICITUDESvalidarEstado POR ANALISTA
	$scope.consultarSolicitudesPorAnalista = function() {
		Solicitudes.obtenerSolicitudesPorAnalista($scope.dniAnalista).success(
				function(data) {
					$scope.solicitudesDeAnalista = data;
				});
	};

	// DELEGAR SOLICITUD
	$scope.delegarSolicitud = function() {
		Solicitudes.asignarSolicitudAAnalista($scope.idSolicitudADelegar,
				$scope.dniAnalistaDelegado).success(function() {
			$scope.solicitudDelegada = true;
			//$scope.analistas = data;
			ngDialog.open({ template: 'enviar',
				closeByEscape: false});
		}).error(function() {
            ngDialog.open({ template: 'enviarError',
            				closeByEscape: false});
		});
	};

	// REALIZAR SOLICITUD
	$scope.realizarSolicitud = function() {
		Solicitudes.realizarSolicitud($scope.solicitudWS).success(
				function(data) {
					$scope.solicitudRealizada = true;
					$scope.idSolicitudRealizada = data;
				});
	};
});

// Controlador Login
iwApp.controller('ctrlrLogin', function($scope, $location, auth, Clientes) {
	// la funci�n login que llamamos en la vista llama a la funci�n
	// login de la factoria auth pasando lo que contiene el campo
	// de texto del formularvalidarEstadoio
	$scope.login = function() {

		Clientes.validar($scope.emailCliente, $scope.password).success(
				function(data) {
					if (data == "ok") {
						auth.login($scope.emailCliente, $scope.password);
						alert(data);
						$scope.emailCliente = '';
						$scope.password = '';
						$location.url('/consultarSolicitud');
						return;
					}
				});
	};

});

// se ejecuta cuando se inicia el modulo angular
iwApp.run(function($rootScope, auth) {
	// Se ejecuta cada vez que cambia la ruta
	$rootScope.$on('$routeChangeStart', function() {
		// llamamos a checkStatus, el cual lo hemos definido en la factoria auth
		// la cu�l hemos inyectado en la acci�n run de la aplicaci�n
		auth.validarEstado();
	});
});