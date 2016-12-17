var app = angular.module('businessUtilisateur', []);
app.controller('BUConnect', function ($scope, $http) {
		console.log(localStorage)
	var name = $scope.login;
	var pwd = $scope.password;
	
		$scope.connect = function (){
		
		$http.post('http://localhost:8080/Airguitare_Web/resources/clients/connect',
				{login: $scope.login ,password : $scope.password })
		.success(function(data){
			
			if (data != null){
				alert("connecté");
				var utilisateur = JSON.stringify(data);
				localStorage.setItem('user', utilisateur);
				localStorage.setItem('IsConnected', 'true')
				
			}
		})
		.error(function(data){
			alert(data);
		})	
		}
		
		
		$scope.switchBtn = function myFunction() {
		    var x = document.getElementById('btnConnect');
		    var y = document.getElementById('btnCompte');
		    var isConnected =  localStorage.getItem('isConnected');
		    
		    if (isConnected === 'true') {
		        x.style.display = 'none';
		        y.style.display= 'inline';
		     var user = JSON.parse( localStorage.getItem('user')); 
		       y.innerHTML = "bonjour " + user.prenom;
		    } else {
		        x.style.display= 'initial';
		        y.style.display= 'initial';
		    }
		}
});