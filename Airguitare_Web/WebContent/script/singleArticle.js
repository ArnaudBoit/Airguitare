var app = angular.module('businessArticle', []);
app.controller('BUarticle', function ($scope, $http, $window) {
	$scope.post;
	$scope.article;
	$scope.loadArticle = function myfunction(){

		var id = localStorage.getItem('item');
		var path = 'http://localhost:8080/Airguitare_Web/resources/businessProduit/produit/'+id;
		console.log("load "+id+" - path: "+path);
		
<<<<<<< HEAD
		$http({method : 'GET', 
			url : path
		})
=======
		var id=localStorage.getItem('item');
		console.log('id ' + id);
		$http.post('http://localhost:8080/Airguitare_Web/resources/businessProduit/produit',
				{id: id })
>>>>>>> branch 'master' of ssh://git@github.com/ArnaudBoit/Airguitare.git
		.success(function(data){
<<<<<<< HEAD
			console.log("success: "+data)
			$scope.article = data;
		//	return $scope.post = data;
=======
			console.log('succes '+ data);
			return $scope.post = data;
>>>>>>> branch 'master' of ssh://git@github.com/ArnaudBoit/Airguitare.git
			
		})
		.error(function(data){
			console.log("error: "+data)
		})	
		}
	
	
});
