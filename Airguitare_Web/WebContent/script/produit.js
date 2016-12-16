var app = angular.module('businessProduit', []);

app.controller('BPlist', function ($scope, $http) {
	
		$scope.listeAllProduit =[]		
		$scope.getlisteAllProduit = function (){
			$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeAllProduits'})
			.success(function(data){
				$scope.listeAllProduit = data;
			})
			.error(function(data){
				alert("ErrorListeAllProduit");
			})
		}

		$scope.listeProduitParSpec =[]
		$scope.getlisteProduitParSpec = function (){
			$http({method : 'GET', 
					  url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeProduitsParSpecialisation/'+['ga','zo','bu']
				})
				.success(function(data){
					$scope.listeProduitParSpec = data;
				})
				.error(function(data){
					alert("ErrorProduitBySpec");
				})
		}
		
		$scope.listeAllMarque =[]		
		$scope.getlisteAllMarque = function (){
			$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeAllMarques'})
			.success(function(data){
				$scope.listeAllMarque = data;
			})
			.error(function(data){
				alert("ErrorAllMarques");
			})
		}

		$scope.listeMarque =[]
		$scope.getMarqueParSpec = function (){
			$http({method : 'GET', 
					  url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeMarqueParSpecialisation/'+['ga','zo','bu']
				})
				.success(function(data){
					$scope.listeProduitParSpec = data;
				})
				.error(function(data){
					alert("ErrorMarqueBySpec");
				})
		}
	
});
