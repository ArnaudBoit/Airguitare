var app = angular.module('businessCart', []);
app.controller('BUCart', function ($scope, $http, $window) {
	
	$scope.addOne = function myfunction(){
		if("nbArt" in localStorage){
		    var nbArticles = localStorage.getItem('nbArt'); 
		    console.log(nbArticles);
		    nbArticles++;
		    var panier = document.getElementById('recapPanier').innerHTML;
		     var add = parseInt(document.getElementById('prix').innerHTML);
		     console.log(add);
		     console.log(panier);
		     if(panier==""){
		    	 document.getElementById('recapPanier').innerHTML =	add;
		     }else{
		     document.getElementById('recapPanier').innerHTML = parseInt(panier) + add;
		     }
		    document.getElementById('nbArticle').innerHTML = nbArticles + "" + (nbArticles <=1? " article" : " articles");
		    localStorage.setItem('nbArt',nbArticles)
		    
		} else {
		   localStorage.setItem('nbArt','1');
		}
	}
	$scope.flush = function myfunction(){
		
		   localStorage.removeItem('nbArt');
		
	}
	
	$scope.flush = function myfunction(){
		
		   localStorage.removeItem('nbArt');
		
	}

});