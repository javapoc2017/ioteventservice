'use strict';

/**
 * @ngdoc function
 * @name iotClientApp.controller:DashboardCtrl
 * @description
 * # DashboardCtrl
 * Controller of the iotClientApp
 */
angular.module('iotClientApp')
  .controller('CategoriesCtrl', function ( $scope,serviceCalls) {

  	$scope.selectedAll = false;
    serviceCalls.getCategory(undefined).then(function(response){
    	$scope.categories = response.data;

    	 }).catch(function(err){console.log('error in category')});
	    
	        $scope.addNew = function(category){
	            
	            serviceCalls.addCategory(category).then(function(response){
	            	$scope.categories.push(category);

                	console.log('category successfully');
                	
                }).catch(function(err){console.log('error in category')});
	            $scope.PD = {};
	        };
	    
	        $scope.remove = function(){
	            var newDataList=[];
	            var deleteDataList=[];
	            $scope.selectedAll = false;
	            angular.forEach($scope.categories, function(category){
	                if(!category.selected){
	                    newDataList.push(category);
	                }
	                else{
	                	deleteDataList.push(category);
	                }
	            }); 

	            angular.forEach(deleteDataList, function(category){
	            	serviceCalls.deleteCategory(category.catId).then(function(response){
    	               
    	 }).catch(function(err){
    	 	$scope.categories.push(category);

    	 	console.log('error in category');
    	 });


	            });



	            $scope.categories = newDataList;
	        };
	    
	        $scope.checkAll = function () {
	           
	            angular.forEach($scope.categories, function (category) {
	                category.selected = $scope.selectedAll;
	            });
	        }; 
  });
