'use strict';
 
angular.module('myApp')
.controller('UsuarioController', ['$scope', 'UsuarioService', 
	function($scope, CatalogoService) {
	var self = this;
		
	self.catalogo = [];
	self.usuario ;
	
	
	
	self.findAllUsers         = findAllUsers;
	self.addUser         = addUser;
	
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
	
	function addUser() {
		console.log("------------------->add]:",self.usuario)
		
		CatalogoService
				.addUser(self.usuario)
				.then(
						function(d) {

							console.log("addUser]:",
											d)

						   findAllUsers();
							return d;
						},
						function(errResponse) {
							console
									.error('[addUser] Error while fetching updateConceptos()');
						});
		return null;
	}
	
}]);