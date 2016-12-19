var app = angular.module('businessCommande', []);
app.controller('BUCommand', function ($scope, $http, $window) {
	console.log('dans le controller');
	$scope.listCommand = [];
	$scope.message = '';
	$scope.prix = '';
	$scope.listLigne= [];
	$scope.command= {};
	var isConnected = localStorage.getItem('IsConnected');

	if(isConnected != 'true'){
		$window.location.href = 'account.html';
	}


	$scope.displayCommand = function myFunction(){
		console.log('premiere methode')
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
	$scope.getPrice = function myfunction(idCommande){
		console.log(idCommande);
		//alert('dans la methode');
		$http.post('http://localhost:8080/Airguitare_Web/resources/commandes/byCommandeID',	{id:idCommande})
		.success(function(data){
			$scope.prix=data;
			console.log(data);
			return data;
		})
	}
	
	
});
angular.bootstrap(document.getElementById("compteClient"), ['businessCommande']);