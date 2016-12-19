var app = angular.module('businessBlog', []).config(function($locationProvider){
	$locationProvider.html5Mode(true);
});
app.controller('Bloglist', function ($scope, $http, $location) {
	$scope.liste =[]
	$scope.article = {}
	$scope.divArticle={}
	$scope.nbComment ='';
console.log($location.search().id);
	$scope.getListe = function (){

		$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessBlog/listeArticles'})
		.success(function(data){

			$scope.liste = data;

		})
		.error(function(data){
			alert("Error");
		})

		
	}

	
	$scope.getNBComment = function (nb) {
		$http.post('http://localhost:8080/Airguitare_Web/resources/commandes/byCommandeID',	{id:nb})
		.success(function(data){
			$scope.nbComment = data;
		})
	}
//	$scope.getArticle = function(id,$scope) {
//
//		$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessBlog/singleArticle/',id : localeStorage['maCle']})
//		.success(functinbon(data){
//			divArticle = data;
//			//localeStorage.setItem('art',Json.stringify(data));
//		})
//		.error(function(data){
//			alert("Error");
//		})
//
//	}
});

