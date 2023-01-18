'use strict';
 
angular.module('myApp').factory('UsuarioService', ['$http', '$q', function($http, $q){
	
	var IP = "http://localhost:8081"
	var REST_SERVICE_URI = IP+'/test-miriam/rest/';
		 
    var factory = {
    		findAllUsers: findAllUsers,
    		addUser: addUser
    	
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
    
    function addUser(usuario) {
        var deferred = $q.defer();
        
        var request = REST_SERVICE_URI+'addUser';
      
        console.log(request)
        $http.post(request,usuario)
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
