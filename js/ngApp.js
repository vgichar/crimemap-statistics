// ##################################################################################################################################
// #####                                       Developed by: Vojdan Gicharovski - vGichar                                       #####
// #####                                                 Mentor: Riste Stojanov                                                 #####
// ##################################################################################################################################

// create module @app form directive @ng-app="mrvApp" in view @index.html
// Dependencies :   @ngRoute - native,   @controllers - sontrollers.js,   @services - services.js

// used to configure different "Single Page Application" routes and
// bootstrap whole application by injecting custom made dependencies like
// @controllers,   @services
var app = angular.module('mvrApp', ['ngRoute', 'controllers', 'services']);

// configure "Single Page Application" routes
// Dependencies :   @$routeProvider - native
app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/home', { // url, from root on...
      templateUrl: 'view/home.html', // view to display when this url is visited
      controller: 'homeController' // controller to use when this url is visited
    }).
    when('/event/:eventId', { // same as above...
      templateUrl: 'view/event-detail.html', // ...
      controller: 'eventController'
    }).
    when('/municipality/:municipalityId', {
      templateUrl: 'view/municipality-detail.html',
      controller: 'municipalityController'
    }).
    when('/filter', {
      templateUrl: 'view/filter.html',
      controller: 'filterController'
    }).
    when('/about', {
      templateUrl: 'view/about.html',
      controller: 'aboutController'
    }).
    otherwise({ // configure default url. When client visits unconfigured url redirect here
      redirectTo: '/home'
    });
}]);