var app = angular.module('businessProduit', []);

app.controller('BPlist', function ($scope) {
	$scope.produits = $http.get("businessProduit/listeProduits");	
});
