'use strict';
 
angular.module('myApp').factory('UsuarioService', ['$http', '$q', function($http, $q){
	
	var IP = "localhost:8081"
	var REST_SERVICE_URI = IP+'/test-miriam/rest/';
		 
    var factory = {
    		findAllUsers: findAllUsers,
    		updateConceptos: updateConceptos
    	
    };
		
    return factory;
    

    function findAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'findUsers')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('[CatalogoService] Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function updateConceptos(nombre,descripcion,tipo) {
        var deferred = $q.defer();
        
        var request = REST_SERVICE_URI+'updateCatalogos/'+nombre+'/'+descripcion+'/'+tipo;
      
        console.log(request)
        $http.post(request)
            .then(
            function (response) {
               console.log(response.data)
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updateConceptos',errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	
	
}]);
