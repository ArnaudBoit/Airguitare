var app = angular.module('businessProduit', []);

app.controller('BPlist', function ($scope, $http) {
		
		//INIT PRODUCTS.HTML
		$scope.listeAllProduit =[];	
		$scope.listeAllMarque =[];	
		$scope.listeAllSpecs =[];	
		
		$scope.getlisteAllProduit = function (){
			
			$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeAllProduits'})
			.success(function(data){
				$scope.listeAllProduit = data;
			})
			.error(function(data){
				alert("ErrorListeAllProduit");
			})
			
	        $scope.cbxSpecAll = true;
	        $scope.cbxMarqueAll = true;

		}
		//Affichage des produits selon Marque + Specialisation
		$scope.listeMarque =[];
		$scope.getProduitByOptions = function (){
			//Création de l'url
			var path = 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeProduitParOptions/';
			if( $scope.listeSpecCochee != null){
				path +=  $scope.listeSpecCochee;
			}
			if($scope.listeSpecCochee != null && $scope.listeMarqueCochee != null) {
				path += '/';
			}
			if($scope.listeMarqueCochee != null) {
				path += $scope.listeMarqueCochee;
			}
			console.log("path: "+path);		
			
			
			$http({method : 'GET', 
					  url : path
				})
				.success(function(data){
					$scope.listeAllProduit = data;
					console.log("AFFICHAGE PRODUITS "+data);
				})
				.error(function(data){
					$scope.listeAllProduit = [];
					console.log("erreurProduitByOptions");
					
				})
		}
		//Afficher la liste des Marques dans les catégories
		$scope.getlisteAllMarque = function (){
			$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeAllMarques'})
			.success(function(data){
				$scope.listeAllMarque = data;
				angular.forEach($scope.listeAllMarque, function (m) {
		        	$scope.cbxMarque[m.intitule] = true;
		        });
			})
			.error(function(data){
				alert("ErrorAllMarques");
			})
		}
		
		//Afficher la liste des Specs dans les catégories
		$scope.getlisteAllSpecs = function (){
			$http({method : 'GET', url : 'http://localhost:8080/Airguitare_Web/resources/businessProduit/listeAllSpecs'})
			.success(function(data){
				$scope.listeAllSpecs = data;
		        angular.forEach($scope.listeAllSpecs, function (m) {
		        	$scope.cbxSpec[m.intitule] = true;
		        });
			})
			.error(function(data){
				alert("ErrorAllSpecs");
			})
		}

		
		//Update Marque pour les checkbox
		$scope.cbxMarque = {};
		$scope.listeMarqueCochee = [];
		
		$scope.updateCbxMarque = function() {
			$scope.listeMarqueCochee = [];
			
          //  $scope.cbxMarqueAll = false;
			
			angular.forEach($scope.cbxMarque, function(value, id){
				if(value) {
					$scope.listeMarqueCochee.push(id);
				}
			});
			$scope.getProduitByOptions();
		};


		//Update Spec pour les checkbox
		$scope.cbxSpec = {};
		$scope.listeSpecCochee = [];
		
		$scope.updateCbxSpec = function() {
			$scope.listeSpecCochee = [];
			
           // $scope.cbxSpecAll = false;
			
			angular.forEach($scope.cbxSpec, function(value, id){
				if(value) {
					$scope.listeSpecCochee.push(id);
				}
			});
			$scope.getProduitByOptions();
		};
		

		//Check/uncheck All Marques
		$scope.changeAllCbxMarque = function () {
	        if ($scope.cbxMarqueAll) {
	            $scope.cbxMarqueAll = true;
	        } else {
	            $scope.cbxMarqueAll = false;
	        }
	        angular.forEach($scope.listeAllMarque, function (m) {
	        	$scope.cbxMarque[m.intitule] = $scope.cbxMarqueAll;
	        });
			$scope.updateCbxSpec();
			$scope.updateCbxMarque();
        };
		
		//Check/uncheck All Specs
		$scope.changeAllCbxSpec = function () {
	        if ($scope.cbxSpecAll) {
	            $scope.cbxSpecAll = true;
	        } else {
	            $scope.cbxSpecAll = false;
	        }
	        angular.forEach($scope.listeAllSpecs, function (m) {
	        	$scope.cbxSpec[m.intitule] = $scope.cbxSpecAll;
	        });
			$scope.updateCbxSpec();
			$scope.updateCbxMarque();
        };
    

        

});
