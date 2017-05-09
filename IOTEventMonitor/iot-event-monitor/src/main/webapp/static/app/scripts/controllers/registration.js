'use strict';

/**
 * @ngdoc function
 * @name iotClientApp.controller:RegistrationCtrl
 * @description
 * # RegistrationCtrl
 * Controller of the iotClientApp
 */
angular.module('iotClientApp')
  .controller('RegistrationCtrl', function (serviceCalls,$scope,$state) {
    

  	$scope.register=function(){
  		 var user=$scope.user;
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
                serviceCalls.registration(userObject).then(function(response){

                	console.log('registered successfully');
                	$state.go('signin');
                }).catch(function(err){console.log('error in registration')});




  	};

  	
  
  });
