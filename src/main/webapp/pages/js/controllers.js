// ##################################################################################################################################
// #####                                       Developed by: Vojdan Gicharovski - vGichar                                       #####
// #####                                                 Mentor: Riste Stojanov                                                 #####
// ##################################################################################################################################

// create module @controllers form directive @ng-controller="[a-zA-Z]*"
// in view @index.html or dynamically asigned via @ngApp.js route configuration
// Dependencies :   none

// used to configure controllers for different "Single Page Application" views
var controllers = angular.module('controllers', []);

// configure @indexController form directive @ng-controller="indexController" in view @index.html
// Dependencies :   @$scope - native,   @Events - services.js,   @Languages - services.js

// used as global scope controller
// used to initialize and fill @$scope with data which is used troughout whole application
// used to define event listeners which are used troughout whole application
// used to define functions which are used troughout whole application
controllers.controller('indexController', ['$scope', '$rootScope', '$location', 'Events', 'Languages', 'Navigation', 'User', 'localStorageService',
  function ($scope, $rootScope, $location, Events, Languages, Navigation, User, localStorageService) {
  
    // @loadLang(@language) - load language library using @Languages service based on @language variable
    // @language = ['mk' | 'en']
    $scope.loadLang = function(language){
      $scope.lang = Languages.get({language : language});
      localStorageService.add('language', language);
    }

    // initialize application
    $scope.init = function(){

      // TEMP
      // load user functions using @User service
      $scope.User = User;
      $scope.User.isLoggedIn = false;

      // TEMP
      // initialize language to @'mk'
      var lang = localStorageService.get('language');
      if(lang != null)
        $scope.loadLang(lang);
      else
        $scope.loadLang('mk'); 

      // listen to path changes and use @Navigation.@visit(@current_path) to highlight active links in view @index.html header navigation
      $rootScope.$on('$locationChangeSuccess', function () {
        Navigation.visit($location.path());
      });
    }
  }
]);
 
// configure @homeController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native
controllers.controller('homeController', ['$scope', 
  function ($scope) {
  }
]);

// configure @settingsController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native
controllers.controller('settingsController', ['$scope', 
  function ($scope) {
  }
]);

// configure @filterController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native
controllers.controller('filterController', ['$scope', 
  function ($scope) {
  }
]);

// configure @aboutController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native
controllers.controller('aboutController', ['$scope', 
  function ($scope) {
  }
]);

// configure @eventController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native,   @$routeParams - native
controllers.controller('eventController', ['$scope', '$routeParams', 
  function ($scope, $routeParams) {
    $scope.eventId = $routeParams.eventId;
  }
]);

// configure @municipalityController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native,   @$routeParams - native
controllers.controller('municipalityController', ['$scope', '$routeParams', 
  function ($scope, $routeParams) {
    $scope.municipalityId = $routeParams.municipalityId;
  }
]);

// configure @municipalityController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native,   @$routeParams - native
controllers.controller('settingsController', ['$scope', 'UserAccounts',
  function ($scope, UserAccounts) {
      $scope.btnClick = function(){
          $scope.UserAccounts = UserAccounts.queryAll();
      }
  }
]);

controllers.controller('usersAdministrationController', ['$scope', 'UserAccounts',
  function ($scope, UserAccounts) {
  }
]);