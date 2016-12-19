var app = angular.module('businessCart', []);
app.controller('BUCart', function ($scope, $http, $window) {
	
    $scope.addOne = function myfunction(produit){
    	var nbArticles ;
		if("nbArt" in localStorage){
		    nbArticles = localStorage.getItem('nbArt'); 
		    console.log(nbArticles);
		    nbArticles++;
		    var panier = document.getElementById('recapPanier').innerHTML;
		     var add = produit.prix;
		     console.log(add);
		     console.log(panier);
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
		console.log(panier);
		
	}

});