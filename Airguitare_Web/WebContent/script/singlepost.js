var app = angular.module('businessBlog', []).config(function($locationProvider){
	$locationProvider.html5Mode(true);
});
app.controller('Single',function($scope, $http, $location) {
	$location.search().id;
	$scope.getArticle = function(id,$scope) {

		$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessBlog/singleArticle/'+id})
		.success(function(data){
			
			$scope.article = data;
			localeStorage.setItem('art',Json.stringify(data));
		})
		.error(function(data){
			alert("Error");
		})

	}
});