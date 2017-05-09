'use strict';

/**
 * @ngdoc function
 * @name iotClientApp.controller:DashboardCtrl
 * @description
 * # DashboardCtrl
 * Controller of the iotClientApp
 */
angular.module('iotClientApp')
  .controller('locations', function ( $scope,serviceCalls) { 
  	$scope.selectedAll = false;
    serviceCalls.getLocation(undefined).then(function(response){
    	$scope.locations = response.data;

    	 }).catch(function(err){console.log('error in location')});
	    
	        $scope.addNew = function(location){
	            
	            serviceCalls.addLocation(location).then(function(response){
	            	$scope.locations.push(location);

                	console.log('location successfully');
                	
                }).catch(function(err){console.log('error in location')});
	            $scope.PD = {};
	        };
	    
	        $scope.remove = function(){
	            var newDataList=[];
	            var deleteDataList=[];
	            $scope.selectedAll = false;
	            angular.forEach($scope.locations, function(location){
	                if(!location.selected){
	                    newDataList.push(location);
	                }
	                else{
	                	deleteDataList.push(location);
	                }
	            }); 

	            angular.forEach(deleteDataList, function(location){
	            	serviceCalls.deleteLocation(location.locId).then(function(response){
    	               
    	 }).catch(function(err){
    	 	$scope.locations.push(location);

    	 	console.log('error in location');
    	 });


	            });



	            $scope.locations = newDataList;
	        };
	    
	        $scope.checkAll = function () {
	           
	            angular.forEach($scope.locations, function (location) {
	                location.selected = $scope.selectedAll;
	            });
	        }; 
  });
