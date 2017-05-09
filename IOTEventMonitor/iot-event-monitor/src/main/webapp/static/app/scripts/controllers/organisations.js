'use strict';

/**
 * @ngdoc function
 * @name iotClientApp.controller:DashboardCtrl
 * @description
 * # DashboardCtrl
 * Controller of the iotClientApp
 */
angular.module('iotClientApp')
  .controller('organisations', function ( $scope,serviceCalls) { 
  	$scope.selectedAll = false;
    serviceCalls.getOrganization(undefined).then(function(response){
    	$scope.organizations = response.data;

    	 }).catch(function(err){console.log('error in organization')});
	    
	        $scope.addNew = function(organization){
	            
	            serviceCalls.addOrganization(organization).then(function(response){
	            	$scope.organizations.push(location);

                	console.log('organization successfully');
                	
                }).catch(function(err){console.log('error in organization')});
	            $scope.PD = {};
	        };
	    
	        $scope.remove = function(){
	            var newDataList=[];
	            var deleteDataList=[];
	            $scope.selectedAll = false;
	            angular.forEach($scope.organizations, function(organization){
	                if(!organization.selected){
	                    newDataList.push(organization);
	                }
	                else{
	                	deleteDataList.push(organization);
	                }
	            }); 

	            angular.forEach(deleteDataList, function(organization){
	            	serviceCalls.deleteOrganization(organization.orgId).then(function(response){
    	               
    	 }).catch(function(err){
    	 	$scope.organizations.push(organization);

    	 	console.log('error in organization');
    	 });


	            });



	            $scope.organizations = newDataList;
	        };
	    
	        $scope.checkAll = function () {
	           
	            angular.forEach($scope.organizations, function (organization) {
	                organization.selected = $scope.selectedAll;
	            });
	        }; 
  });
