'use strict';

/**
 * @ngdoc service
 * @name iotClientApp.serviceCalls
 * @description
 * # serviceCalls
 * Service in the iotClientApp.
 */
angular.module('iotClientApp')
  .service('serviceCalls', function ($q,$rootScope,$http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    var config = {
                headers : {
                    'Content-Type': 'application/json'
                }
            };

    this.registration=function (userObject){
    	var differed=$q.defer();

    	$http.post($rootScope.URL+'/customer/registerUser',userObject,config)
    .then(function(response) {
        console.log("registration service success");

        differed.resolve(response);
    }).catch(function(response){

    	differed.reject(response);
    });
    return differed.promise;

    };

    this.login=function (userObject){
    	var differed=$q.defer();

    	$http.post($rootScope.URL+'/customer/login',userObject,config)
    .then(function(response) {
        console.log("login service success");

        differed.resolve(response);
    }).catch(function(response){

    	differed.reject(response);
    });
    return differed.promise;

    };

    this.addCategory=function (category){
        var differed=$q.defer();

        $http.post($rootScope.URL+'/admin/category',category,config)
    .then(function(response) {
        console.log("category service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    this.getCategory=function (id){
        var differed=$q.defer();
        var catid="";
        if(id){
            catid="/"+id;

        }
        

        $http.get($rootScope.URL+'/admin/category'+catid,config)
    .then(function(response) {
        console.log("category service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    this.deleteCategory=function (id){
        var differed=$q.defer();
        var catid="";
        if(id){
            catid="/"+id;

        }

        $http.delete($rootScope.URL+'/admin/category'+catid,config).then(function(response) {
        console.log("category service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    ////////////////

    this.addLocation=function (location){
        var differed=$q.defer();

        $http.post($rootScope.URL+'/admin/location',location,config)
    .then(function(response) {
        console.log("location service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    this.getLocation=function (id){
        var differed=$q.defer();
        var catid="";
        if(id){
            catid="/"+id;

        }
        

        $http.get($rootScope.URL+'/admin/location'+catid,config)
    .then(function(response) {
        console.log("location service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    this.deleteLocation=function (id){
        var differed=$q.defer();
        var catid="";
        if(id){
            catid="/"+id;

        }

        $http.delete($rootScope.URL+'/admin/location'+catid,config).then(function(response) {
        console.log("location service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };
    /////////////


    this.addOrganization=function (organization){
        var differed=$q.defer();

        $http.post($rootScope.URL+'/admin/organization',organization,config)
    .then(function(response) {
        console.log("organization service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    this.getOrganization=function (id){
        var differed=$q.defer();
        var catid="";
        if(id){
            catid="/"+id;

        }
        

        $http.get($rootScope.URL+'/admin/organization'+catid,config)
    .then(function(response) {
        console.log("organization service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    this.deleteOrganization=function (id){
        var differed=$q.defer();
        var catid="";
        if(id){
            catid="/"+id;

        }

        $http.delete($rootScope.URL+'/admin/organization'+catid,config).then(function(response) {
        console.log("organization service success");

        differed.resolve(response);
    }).catch(function(response){

        differed.reject(response);
    });
    return differed.promise;

    };

    //////////



  });
