var app = angular.module('businessProduit', []);

app.controller('BPlist', function ($scope,$http) {
	
	$scope.liste=[]
	$scope.getListe = function() {
		$http({method : 'GET', url :'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeProduits'}).success(function(data){
			$scope.liste=data;
		}).error(function(data){
			alert("Error");
		})
	}
});
