'use strict';
 
angular.module('myApp')
.controller('UsuarioController', ['$scope', 'UsuarioService', 
	function($scope, CatalogoService) {
	var self = this;
		
	self.catalogo = [];
	self.catalogoFinanzas = [{ codigo : 'ingreso'},{ codigo : 'egreso'}];
	
	self.catalogoSubmit;
	
	self.findAllUsers         = findAllUsers;
	self.updateConceptos         = updateConceptos;
	
	findAllUsers();
	
	function findAllUsers(){
		CatalogoService.findAllUsers()
            .then(
            function(d) {
            	console.log("[CatalogoController]  usuarios]:",d)
                self.catalogo = d;
            },
            function(errResponse){
                console.error('[CatalogoController]  Error while fetching findAllUsers()');
            }
        );
    }
	
	function updateConceptos(nombre, descripcion,tipo) {
		console.log("------------------->addTorneoGrupo]:",tipo)
		if(tipo.codigo == 'egreso'){
			tipo = 2;
		}else{
			tipo = 1;
		}
		CatalogoService
				.updateConceptos(nombre, descripcion,tipo)
				.then(
						function(d) {

							console.log("ConceptosController-updateConceptos]:",
											d)

						   findAllUsers();
							return d;
						},
						function(errResponse) {
							console
									.error('[ConceptosController] Error while fetching updateConceptos()');
						});
		return null;
	}
	
}]);