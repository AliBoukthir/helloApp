
var routeApp = angular.module('routeApp', [
    // Dépendances du "module"
    'ngRoute'
]);

routeApp.config(['$routeProvider',
    function($routeProvider) { 
        
        // Système de routage
        $routeProvider
        .when("/", {
        templateUrl : "hom.jsp"
        })
        .when("/profile", {
            templateUrl : "profile.jsp"
            });
        
    }
]);



routeApp.controller('myCtrl', function ($scope, $http){

	$scope.init = function() {
		$http.get("./getposts")
	.success(function(response) {$scope.names = response;});
	}
	
	$scope.show = function() {
		 $http.get("./getposts")
	     	.success(function(response) {$scope.names = response;});
	 }

	 $scope.send = function()
     {
		 
         $http({
                 url: "./post",
                 method: "POST",
                 headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                 params: {poste: $scope.poste, id: document.getElementById("idUser").value}
             });
         $scope.poste = "";
         
         
         
     }
	 
	 
	 
	 $scope.runBoth = function () {
		 $scope.show();
		 $scope.send();
		 
		}
	 
	

});


routeApp.filter('orderObjectBy', function(){
	 return function(input, attribute) {
	    if (!angular.isObject(input)) return input;

	    var array = [];
	    for(var objectKey in input) {
	        array.push(input[objectKey]);
	    }

	    array.sort(function(a, b){
	        a = parseInt(a[attribute]);
	        b = parseInt(b[attribute]);
	        return b - a;
	    });
	    return array;
	 }
	});


