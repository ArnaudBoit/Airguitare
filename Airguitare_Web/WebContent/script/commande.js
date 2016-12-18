var app = angular.module('businessCommande', []);
app.controller('BUCommand', function ($scope, $http, $window) {
	console.log('dans le controller');
	$scope.listCommand = [];
	$scope.message = '';
	
	var isConnected = localStorage.getItem('IsConnected');
	
	if(isConnected != 'true'){
		$window.location.href = 'account.html';
	}
	
	
	$scope.displayCommand = function myFunction(){
		
		 var user = JSON.parse( localStorage.getItem('user'));
		
		$http.post('http://localhost:8080/Airguitare_Web/resources/commandes/byUserID',
				{id: user.id })
				.success(function(data){
					console.log(data);
					$scope.listCommand = data;	
					
				})
				.error(function(data){
					$scope.message=data;
				})	
				
	}
});
angular.bootstrap(document.getElementById("compteClient"), ['businessCommande']);