var app = angular.module('businessProduit', []);

app.controller('BPlist', function ($scope, $http, $window) {
		
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
				console.log("ErrorListeAllProduit");
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
				console.log("ErrorAllMarques");
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
    
        $scope.addOne = function myfunction(produit){
        	var nbArticles ;
    		if("nbArt" in localStorage){
    		    nbArticles = localStorage.getItem('nbArt'); 
//    		    console.log(nbArticles);
    		    nbArticles++;
    		    var panier = document.getElementById('recapPanier').innerHTML;
    		     var add = produit.prix;
//    		     console.log(add);
//    		     console.log(panier);
    		     var somme= parseInt(panier) + add;
    		     document.getElementById('recapPanier').innerHTML = somme;
    		     localStorage.setItem('cost',somme);
    		    
    		    localStorage.setItem('nbArt',nbArticles)
    		    
    		} else {
    		   localStorage.setItem('nbArt','1');
    		   nbArticles =1; 
    		}
    		document.getElementById('nbArticle').innerHTML = nbArticles + "" + (nbArticles <=1? " article" : " articles");
    		$scope.saveItem(produit);
    	}
    	$scope.flush = function myfunction(){
    		
    		   localStorage.removeItem('nbArt');
    		   
    	}
    	
    	$scope.saveItem = function myfunction(produit){
    		var panier =[];
    		if("panier" in localStorage){
    			panier = JSON.parse(localStorage.getItem('panier'));
    		}
    		
    		panier.push({id:produit.id, quantite:1, nom:produit.intitule, prix : produit.prix});
    		localStorage.setItem('panier', JSON.stringify(panier));
//    		console.log(panier);
    		
    	}
    	
    	$scope.openSingle = function myfunction(produit){
    		localStorage.setItem('item', produit);
    		$window.location.href = 'single.html'
  
    	}
    	
});
