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
    function($scope, $rootScope, $location, Events, Languages, Navigation, User, localStorageService) {

        // @loadLang(@language) - load language library using @Languages service based on @language variable
        // @language = ['mk' | 'en']
        $scope.loadLang = function(language) {
            $scope.lang = Languages.get({language: language});
            localStorageService.add('language', language);
        }

        // initialize application
        $scope.init = function() {

            // TEMP
            // load user functions using @User service
            $scope.User = User;
            $scope.User.isLoggedIn();

            // TEMP
            // initialize language to @'mk'
            var lang = localStorageService.get('language');
            if (lang != null) {
                $scope.loadLang(lang);
            } else {
                $scope.loadLang('mk');
            }

            // listen to path changes and use @Navigation.@visit(@current_path) to highlight active links in view @index.html header navigation
            $rootScope.$on('$locationChangeSuccess', function() {
                Navigation.visit($location.path());
            });
        }
    }
]);

// configure @homeController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native
controllers.controller('homeController', ['$scope',
    function($scope) {
    }
]);

// configure @settingsController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native
controllers.controller('settingsController', ['$scope',
    function($scope) {
    }
]);

// configure @filterController dynamically asigned via @ngApp.js route configuration
// Dependencies :   @$scope - native
controllers.controller('filterController', ['$scope', '$routeParams',
    function($scope, $routeParams) {
        $scope.eventId = $routeParams.eventId;
    }
]);

controllers.controller('administrationController', ['$scope', 'UserAccounts', "DropDownListValues",
    function($scope, UserAccounts, DropDownListValues) {
        $scope.submit = "new";
        $scope.Users = UserAccounts.queryAll();
        $scope.UserRoles = UserAccounts.queryAllUsertypes();
        $scope.SVRs = DropDownListValues.queryByKey({param: "SVR"});
        $scope.PSs = DropDownListValues.queryByKey({param: "PS"});
        $scope.Keys = DropDownListValues.queryAllKeys();
        $scope.AllDropDown = DropDownListValues.queryAll();

        $scope.ClickRegisterUser = function() {
            var user = {'userId': -1, 'name': $scope.name, 'email': $scope.email, 'password': $scope.password, 'userRole': {'role': $scope.userRole}, 'ps': $scope.PS, 'svr': $scope.SVR};
            UserAccounts.register(user, function(response) {
                if (response.userId != -1) {
                    $scope.Users.push(user);
                } else {
                    $(".message-box").trigger("showElem", ["User Already Exists!", "User already exists, plaese enter another username or email", 3000]);
                }
            });
        }

        $scope.ClickEditUser = function(name) {
            var index = null;
            for (var i = 0; i < $scope.Users.length; i++) {
                if ($scope.Users[i].name == name) {
                    index = i;
                    break;
                }
            }
            var user = {'userId': $scope.Users[index].userId, 'name': $scope.name, 'email': $scope.email, 'password': $scope.password, 'userRole': {'role': $scope.userRole}, 'ps': $scope.PS, 'svr': $scope.SVR};
            UserAccounts.update(user, function() {
                if ($scope.Users[index].name == $scope.User.username) {
                    $scope.User.logout();
                    location.href = "./invalid";
                }

                $scope.Users[index] = user;
            });
        }
        $scope.ClickPrepareEditUser = function(name) {
            var user = null;
            for (var i = 0; i < $scope.Users.length; i++) {
                if ($scope.Users[i].name == name) {
                    user = $scope.Users[i];
                    break;
                }
            }

            $scope.name = user.name;
            $scope.email = user.email;
            $scope.password = null;
            $scope.cpassword = null;
            $scope.userRole = user.userRole.role;
            $scope.PS = user.ps;
            $scope.SVR = user.svr;
            $scope.submit = name;
        }
        $scope.ClickDeleteUser = function(name) {
            var index = null;
            for (var i = 0; i < $scope.Users.length; i++) {
                if ($scope.Users[i].name == name) {
                    index = i;
                    break;
                }
            }
            UserAccounts.delete({param: $scope.Users[index].userId}, function() {
                $scope.Users.splice(index, 1);
            });
        }


        $scope.ClickRegisterAttribute = function() {
            var attr = {'key': $scope.selectedKey.key, 'value': $scope.attrValue, 'dependencyKey': $scope.selectedKey.dependency, 'dependencyValue': $scope.selectedDependencyValue};
            DropDownListValues.insert(attr, function(response) {
                if (response[0] != "f") {
                    $scope.AllDropDown.push(attr);
                } else {
                    $(".message-box").trigger("showElem", ["Attribute Already Exists!", "Attribute already exists, plaese enter another!", 3000]);
                }
            });
        }
        $scope.ClickDeleteAttribute = function(value) {
            var index = null;
            for (var i = 0; i < $scope.AllDropDown.length; i++) {
                if ($scope.AllDropDown[i].value == value) {
                    index = i;
                    break;
                }
            }
            DropDownListValues.delete({param: $scope.AllDropDown[index].key, param2: $scope.AllDropDown[index].value}, function() {
                $scope.AllDropDown.splice(index, 1);

                for (var i = 0; i < $scope.AllDropDown.length; i++) {
                    if ($scope.AllDropDown[i].dependencyKey == $scope.selectedKey.key && $scope.AllDropDown[i].dependencyValue == value) {
                        $scope.AllDropDown.splice(i, 1);
                        i--;
                    }
                }
            });
        }
    }
]);