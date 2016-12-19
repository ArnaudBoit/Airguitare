var app = angular.module('businessArticle', []);
app.controller('BUarticle', function ($scope, $http, $window) {
	$scope.post;
	$scope.article;
	$scope.nbProduit;
	$scope.loadArticle = function myfunction(){

		var id = localStorage.getItem('item');
		var path = 'http://localhost:8080/Airguitare_Web/resources/businessProduit/produit/'+id;
//		console.log("load "+id+" - path: "+path);
		
		$http({method : 'GET', 
			url : path
		})
		.success(function(data){
			console.log("success: "+data)
			$scope.article = data;
		//	return $scope.post = data;
			
		})
		.error(function(data){
			console.log("error: "+data)
		})	
		}
	
		$scope.addOne = function myfunction(produit){
	    	var nbArticles ;
			if("nbArt" in localStorage){
			    nbArticles = parseInt(localStorage.getItem('nbArt')); 
			    nbArticles += parseInt($scope.nbProduit);
			    var panier = document.getElementById('recapPanier').innerHTML;
			     var add = $scope.article.prix;
//			     console.log("produit: "+add+" - nbArticlesAjout: "+$scope.nbProduit);
//			     console.log("panier: "+panier+" - nbArticlesPanier: "+nbArticles);
//			     console.log("ajoutPrix: "+add*$scope.nbProduit);
			     var somme= parseInt(panier) + add*$scope.nbProduit;
			     document.getElementById('recapPanier').innerHTML = somme;
			     localStorage.setItem('cost',somme);
			    
			    localStorage.setItem('nbArt', nbArticles);
			    
			} else {
			   localStorage.setItem('nbArt', $scope.nbProduit);
			   nbArticles =  $scope.nbProduit; 
			}
			document.getElementById('nbArticle').innerHTML = nbArticles + "" + (nbArticles <=1? " article" : " articles");
			$scope.saveItem(add, $scope.nbProduit);
		}
		
    	$scope.saveItem = function myfunction(produit, qte){
    		var panier =[];
    		if("panier" in localStorage){
    			panier = JSON.parse(localStorage.getItem('panier'));
    		}
//    		console.log("qté:"+qte);
    		panier.push({id:produit.id, quantite:qte, nom:produit.intitule, prix : produit.prix});
    		localStorage.setItem('panier', JSON.stringify(panier));
    		console.log(panier);
    		
    	}
});
