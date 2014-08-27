//Se crea el modulo y se le inyecta ngRoute que nos permite tener varias vistas
var iwApp = angular.module('iwApp', []);

// URLs de los servicios REST
var URL_PATH = "http://localhost:8080/WebServices_RTF/rest/solicitud";
var URL_SERVICIO_CONSULTAR_SOLICITUD = URL_PATH + "/consultarSolicitud";
var URL_SERVICIO_CONSULTAR_POR_ESTADO = URL_PATH + "/consultarPorEstado";
var URL_SERVICIO_ASIGNAR_SOLICITUD = URL_PATH + "/asignarSolicitudAAnalista";
var URL_SERVICIO_OBTENER_SOLICITUD_POR_ANALISTA = URL_PATH
		+ "/obtenerSolicitudesPorAnalista";
var URL_SERVICIO_REALIZAR_SOLICITUD = URL_PATH + "/realizarSolicitud";

// ESTADOS DE SOLICITUD
var ABIERTO = "ABIERTO";
var RESUELTO = "RESUELTO";

// Servicio Angular encargado de llamar los Servicios Web
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
	this.realizarSolicitud = function(solicitud) {
		return $http({
			method : 'POST',
			url : URL_SERVICIO_REALIZAR_SOLICITUD,
			params : {
				// Enviar solo el parametro solicitud
				id : solicitud.id,
				producto : {
					codigo : solicitud.producto.codigo,
					sucursal : {
						codigo : solicitud.producto.sucursal.codigo,
						nombre : solicitud.producto.sucursal.nombre,
						direccion : solicitud.producto.sucursal.direccion,
						pais : solicitud.producto.sucursal.pais,
						ciudad : solicitud.producto.sucursal.ciudad
					},
					nombre : solicitud.producto.nombre,
					tipo : solicitud.producto.tipo,
					valor : solicitud.producto.valor
				},
				informacionAnalista : {
					dni : solicitud.informacionAnalista.dni,
					nombre : solicitud.informacionAnalista.nombre,
					correo : solicitud.informacionAnalista.correo,
					telefono : solicitud.informacionAnalista.telefono
				},
				tipo : tipo,
				descripcion : descripcion,
				estado : estado,
				complejidad : complejidad,
				prioridad : prioridad,
				fechaCreacion : fechaCreacion,
				fechaAtencion : fechaAtencion,
				tipoDocumento : tipoDocumento,
				nombreCliente : nombreCliente,
				emailCliente : emailCliente,
				respuestaSolicitud : respuestaSolicitud
			}
		});
	};
});

// Controlador Solicitudes
iwApp.controller('ctrlrSolicitudes', function($scope, Solicitudes) {

	$scope.solicitudRealizada = false;
	$scope.solicitudDelegada = false;
	
	$scope.consultarSolicitud = function() {
		Solicitudes.consultarSolicitud($scope.idSolicitud).success(
				function(data) {
					$scope.solicitud = data;
				});
	};

	$scope.consultarSolicitudesAbiertas = function() {
		Solicitudes.consultarSolicitudesPorEstado(ABIERTO).success(
				function(data) {
					$scope.solicitudes = data;
				});
	};

	$scope.consultarSolicitudesPorAnalista = function() {
		Solicitudes.obtenerSolicitudesPorAnalista($scope.dniAnalista).success(
				function(data) {
					$scope.solicitudesDeAnalista = data;
				});
	};

	$scope.delegarSolicitud = function() {
		Solicitudes.asignarSolicitudAAnalista($scope.idSolicitudADelegar,
				$scope.dniAnalistaDelegado).success(function(){
					$scope.solicitudDelegada = true;
				});
	};
	
	$scope.realizarSolicitud = function(){
		Solicitudes.realizarSolicitud($scope.solicitud).success(function(){
			$scope.solicitudRealizada = true;
		});
	};

});