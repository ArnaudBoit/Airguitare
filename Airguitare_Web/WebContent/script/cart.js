var app = angular.module('businessCart', []);
app.controller('BUCart', function ($scope, $http, $window) {
	$scope.Panier=[];
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
		   localStorage.removeItem('panier');
		   localStorage.setItem('cost',0);
		   
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
	
	$scope.displayPanier = function myfunction(){
	
	
		$scope.Panier= JSON.parse(localStorage.getItem('panier'));
		
	}
	
	$scope.confirmer = function myfunction(){
		var idUser= angular.fromJson(localStorage.getItem('user'));
		var panier = angular.fromJson(localStorage.getItem('panier'));
		
		console.log(idUser);
		
		$http.put('http://localhost:8080/Airguitare_Web/resources/commandes/order',
				{idPers: idUser.id , Panier : panier })
		.success(function(data){
			
			
		})
		.error(function(data){
			
		})
		}
		
	
});