var app = angular.module('businessBlog', []);
app.controller('Bloglist', function ($scope, $http) {
	$scope.liste =[]
	$scope.article = {}
	$scope.nbComment = 0;

	$scope.getListe = function (){

		$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessBlog/listeArticles'})
		.success(function(data){

			$scope.liste = data;
			for(article in $scope.liste){

				var id = article.id;
				
			}	

		})
		.error(function(data){
			alert("Error");
		})

	}


	$scope.getNBComment = function(id){

		$http({method: 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessBlog/nbComment', nb : id})
		.success(function(data){
			$scope.nbComment = data;

			return data;

		})
	}
	$scope.getArticle = function(id,$scope,$localStorage) {

		$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessBlog/singleArticle/'+id})
		.success(function(data){
			$scope.article = data;
			$scope.$storage= $localStorage.$default({article:$scope.article});
		})
		.error(function(data){
			alert("Error");
		})

	}
});

