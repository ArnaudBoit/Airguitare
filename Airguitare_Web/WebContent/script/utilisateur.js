var app = angular.module('businessUtilisateur', []);
app.controller('BUConnect', function ($scope, $http) {
		
	var name = $scope.login;
	var pwd = $scope.password;
	
		$scope.connect = function (){
		
		$http.post('http://localhost:8080/Airguitare_Web/resources/clients/connect',
				{login: $scope.login ,password : $scope.password })
		.success(function(data){
			
			if (data != null){
				alert("connecté");
			}
		})
		.error(function(data){
			alert(data);
		})	
		}
});