var app = angular.module('businessUtilisateur', []);
app.controller('BUConnect', function ($scope, $http, $window) {
		
	var name = $scope.login;
	var pwd = $scope.password;
	
		$scope.connect = function (){
		
		$http.post('http://localhost:8080/Airguitare_Web/resources/clients/connect',
				{login: $scope.login ,password : $scope.password })
		.success(function(data){
			
			if (data != null){
				
				var utilisateur = JSON.stringify(data);
				localStorage.setItem('user', utilisateur);
				localStorage.setItem('IsConnected', 'true')
				$scope.switchBtn();
				$window.location.href = 'compteclient.html';
			}
		})
		.error(function(data){
			
		})	
		}
		
		
		$scope.switchBtn = function myFunction() {
			
		    var x = document.getElementById('btnConnect');
		    var y = document.getElementById('btnCompte');
		    var isConnected = localStorage.getItem('IsConnected');
		    
		    if (isConnected == 'true') {
		    	console.log('isConnected');
		        x.style.display = 'none';
		        y.style.display= 'inline';
		     var user = JSON.parse( localStorage.getItem('user')); 
		       y.innerHTML = "bonjour " + user.prenom;
		      
		    } else {
		    	console.log('isDisConnected');
		        x.style.display= 'initial';
		        y.style.display= 'none';
		    }
		}
		
		$scope.disconnect = function myFunction() {
			localStorage.setItem('IsConnected', 'false');
			localStorage.removeItem('user');
			console.log(localStorage);
			$scope.switchBtn();
			var y = document.getElementById('btnDeco');
			y.style.display= 'none';
			localStorage.removeItem('panier');
			localStorage.setItem('nbArt',0);
			localStorage.setItem('cost',0);
			$window.location.href = 'index.html';
			
		}
		
		
		$scope.deco = function myFunction(){
			
			document.getElementById('btnDeco').style.display="inherit";
		}
	
		$scope.unDeco = function myFunction(){
			
			document.getElementById('btnDeco').style.display="none";
		}
		
		$scope.loadCost = function myFunction(){
			if("cost" in localStorage){
				var cost = localStorage.getItem('cost');
				document.getElementById('recapPanier').innerHTML = cost;
			}
		}
		
		$scope.loadArt = function myFunction(){
			
    		if("panier" in localStorage){
    			var art = localStorage.getItem('nbArt');
    			document.getElementById('nbArticle').innerHTML = art + "" + (art <=1? " article" : " articles");
    		}
    		
		}
});
angular.bootstrap(document.getElementById("new-header"), ['businessUtilisateur']);