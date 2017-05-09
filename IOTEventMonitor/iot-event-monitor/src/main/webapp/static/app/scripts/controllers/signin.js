'use strict';

/**
 * @ngdoc function
 * @name iotClientApp.controller:SigninCtrl
 * @description
 * # SigninCtrl
 * Controller of the iotClientApp
 */
angular.module('iotClientApp')
  .controller('SigninCtrl', function (serviceCalls,$scope,$state) {
  	

  	$scope.login=function(){
  		 var user=$scope;
  		$scope.dataLoading='true';
  		var userObject = {
    "username": user.username,
    "first_name": user.firstName,
    "last_name": user.lastName,
    "email": user.username,
    "mobileno": user.mobile,
    "password": user.password,
    "updated_time": "",
    "device": [],
    "orgid": user.org
};   

//$state.go('dashboard');
                serviceCalls.login(userObject).then(function(response){

                	console.log('registered successfully');
                	$state.go('dashboard');
                }).catch(function(err){console.log('error in registration')});




  	};
    
    
  });
