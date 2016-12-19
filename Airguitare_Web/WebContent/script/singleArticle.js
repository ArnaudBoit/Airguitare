var app = angular.module('businessArticle', []);
app.controller('BUarticle', function ($scope, $http, $window) {
	$scope.post;
	$scope.article;
	$scope.loadArticle = function myfunction(){

		var id = localStorage.getItem('item');
		var path = 'http://localhost:8080/Airguitare_Web/resources/businessProduit/produit/'+id;
		console.log("load "+id+" - path: "+path);
		
		$http({method : 'GET', 
			url : path
		})
		.success(function(data){
			console.log("success: "+data)
			$scope.article = data;
		//	return $scope.post = data;
			
		})
		.error(function(data){
			console.log("error: "+data)
		})	
		}
	
	
});
