var app = angular.module('businessArticle', []);
app.controller('BUarticle', function ($scope, $http, $window) {
	$scope.post;
	$scope.loadArticle = function myfunction(){
		
		var id=localStorage.getItem('item');
		$http.get('http://localhost:8080/Airguitare_Web/resources/businessProduit/produit',
				{id: id })
		.success(function(data){
			
			return $scope.post = data;
			
		})
		.error(function(data){
			
		})	
		}
	
});
