'use strict';

/**
 * @ngdoc overview
 * @name iotClientApp
 * @description
 * # iotClientApp
 *
 * Main module of the application.
 */
angular
  .module('iotClientApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.router'

  ])
  .config(function ($locationProvider,$stateProvider, $urlRouterProvider) {

    
    $locationProvider.hashPrefix('');
     $urlRouterProvider.otherwise('/signin');
      $stateProvider.state('signin', {
              url: '/signin',
              templateUrl: 'views/signin.html' ,
              controller:'SigninCtrl'
              
            
                   
        }).state('dashboard', {
              url: '/dashboard',
              templateUrl: 'views/dashboard.html' ,
              controller:'dashboardCtrl',
              
          
          
        }).state('register', {
              url: '/register',
              templateUrl: 'views/registration.html' ,
              controller:'RegistrationCtrl',
              
          
        }).state('Categories', {
              url: '/Categories',
              templateUrl: 'views/Categories.html' ,
              controller:'CategoriesCtrl',
              
          
        }).state('organisations', {
              url: '/organisations',
              templateUrl: 'views/organisations.html' ,
              controller:'organisations',
              
          
        }).state('locations', {
              url: '/locations',
              templateUrl: 'views/locations.html' ,
              controller:'locations',
              
          
        }).state('gateways', {
              url: '/gateways',
              templateUrl: 'views/gateways.html' ,
              controller:'gateways',
              
          
        }).state('devices', {
              url: '/devices',
              templateUrl: 'views/devices.html' ,
              controller:'devices',
              
          
        });
        
  }).run(function ($rootScope,$http) {
    $rootScope.URL='http://localhost:8080';
    // $http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
  // Send this header only in post requests. Specifies you are sending a JSON object
 // $http.defaults.headers.post['dataType'] = 'json';
  });
