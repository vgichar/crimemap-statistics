// ##################################################################################################################################
// #####                                       Developed by: Vojdan Gicharovski - vGichar                                       #####
// #####                                                 Mentor: Riste Stojanov                                                 #####
// ##################################################################################################################################

// create module @app form directive @ng-app="mrvApp" in view @index.html
// Dependencies :   @ngRoute - native,   @controllers - sontrollers.js,   @services - services.js

// used to configure different "Single Page Application" routes and
// bootstrap whole application by injecting custom made dependencies like
// @controllers,   @services
var app = angular.module('mvrApp', ['ngRoute', 'controllers', 'services', 'directives', 'LocalStorageModule']);

// configure "Single Page Application" routes
// Dependencies :   @$routeProvider - native
app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.
                when('/home', {// url, from root on...
                    templateUrl: 'view/home.html', // view to display when this url is visited
                    controller: 'homeController' // controller to use when this url is visited
                }).
                when('/event/:eventId', {// same as above...
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
                when('/administration', {
                    templateUrl: 'view/administration.html',
                    controller: 'administrationController'
                }).
                when('/settings', {
                    templateUrl: 'view/settings.html',
                    controller: 'settingsController'
                }).
                otherwise({// configure default url. When client visits unconfigured url redirect here; page 404
                    redirectTo: '/home'
                });
    }]);

app.config(['$httpProvider', function($httpProvider) {
        $httpProvider.interceptors.push(function($q) {
            return {
                'responseError': function(rejection) {
                    if (rejection.status == 403) {
                        // lang
                        $(".message-box").trigger("showElem", ["No permission!", "You don't have permission to do that action", 5000]);
                    }
                    return $q.reject(rejection);
                }
            };
        });
    }]);