var app = angular.module('businessProduit', []);

app.controller('BPlist', function ($scope, $http) {
		
		//Affichage de tous les produits
		$scope.listeAllProduit =[];		
		$scope.getlisteAllProduit = function (){
			$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeAllProduits'})
			.success(function(data){
				$scope.listeAllProduit = data;
			})
			.error(function(data){
				alert("ErrorListeAllProduit");
			})
		}
		//Affichage des produits selon Marque + Specialisation
		$scope.listeMarque =[];
		$scope.getProduitByOptions = function (){
			$http({method : 'GET', 
					  url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeProduitParOptions/'
						  +$scope.listeSpecCochee+'/'
						  +$scope.listeMarqueCochee
				})
				.success(function(data){
					$scope.listeAllProduit = data;
					console.log($scope.listeAllProduit);
				})
				.error(function(data){
					alert("ErrorProduitByOptions");
				})
		}
		
		//Afficher la liste des Marques dans les catégories
		$scope.listeAllMarque =[];	
		$scope.getlisteAllMarque = function (){
			$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeAllMarques'})
			.success(function(data){
				$scope.listeAllMarque = data;
			})
			.error(function(data){
				alert("ErrorAllMarques");
			})
		}
		
		//TODO : Afficher la liste des Specs dans les catégories


		
		//Update Marque pour les checkbox
		$scope.cbxMarque = {};
		$scope.listeMarqueCochee = [];
		
		$scope.updateCbxMarque = function() {
			$scope.listeMarqueCochee = [];
			
			angular.forEach($scope.cbxMarque, function(value, id){
				console.log("La marque "+id+" est cochée : "+value);
				if(value) {
					$scope.listeMarqueCochee.push(id);
				}
			});

			console.log("listeMarque : "+$scope.listeMarqueCochee);
			console.log("-------");
			$scope.getProduitByOptions();
		}	
		

		//TODO : Update Spec pour les checkbox
		$scope.listeSpecCochee = ['guitares classiques'];
});
