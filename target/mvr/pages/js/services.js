// ##################################################################################################################################
// #####                                       Developed by: Vojdan Gicharovski - vGichar                                       #####
// #####                                                 Mentor: Riste Stojanov                                                 #####
// ##################################################################################################################################

// create module @services
// Dependencies :   @ngResource - native

// used to create singleton factories, services and providers
var services = angular.module('services', ['ngResource']);

// configure @Navigation service
// Dependencies :   @$resource - native

// used to get language library from @:language.json in JSON format
// @:language = ['mk' | 'en']
services.service('Navigation', [function() {
        this.visit = function(link) {
            $("nav a").parent("li").removeClass("android-active");
            $("nav a[href*='" + link.split("/")[1] + "']").parent("li").addClass("android-active");
        }
        return this;
    }]);
// configure @Languages service
// Dependencies :   @$resource - native

// used to get language library from @:language.json in JSON format
// @:language = ['mk' | 'en']
services.service('Languages', ['$resource', function($resource) {
        return $resource('lang/:language.json', {}, {
            query: {method: 'GET', params: {language: 'mk'}, isArray: true}
        });
    }]);

// configure @User service
// Dependencies :   @$resource - native

// used to get users from @user.json in JSON format
services.service('User', ['$resource', 'UserAccounts', function($resource, UserAccounts) {

        var that = this;

        // @login() - login user
        // @scope.name = "username",  @scope.password = "password"
        this.login = function(name, password) {
            UserAccounts.login({"userId": -1, "name": name, "email": name, "password": password}, function(user) {
                if (user.userId != -1) {
                    that.usertype = user['userRole']['role'];
                    that.isLoggedIn = true;
                    that.password = null;          // decoration
                    that.username = user.name; // decoration
                    that.ps = user.ps;
                    that.svr = user.svr;
                } else {
                    that.usertype = null;
                    that.isLoggedIn = false;
                    that.password = null;          // decoration
                    that.username = null;          // decoration
                    that.ps = null;
                    that.svr = null;
                    $(".message-box").trigger("showElem", ["Invalid credentials", "Invalid username or password", 5000]);
                }
            });
        }

        // @login() - logout user
        this.logout = function() {
            UserAccounts.logout(function() {
                that.isLoggedIn = false;
                that.usertype = null;
                that.password = null;          // decoration
                that.username = null;          // decoration
                that.ps = null;
                that.svr = null;
            });
        }

        // @isLoggedIn() - check if user is logged in
        this.isLoggedIn = function() {
            UserAccounts.getSessionUser(function(user) {
                if (user.userId != -1) {
                    that.usertype = user['userRole']['role'];
                    that.isLoggedIn = true;
                    that.password = null;          // decoration
                    that.username = user.name; // decoration
                    that.ps = user.ps;
                    that.svr = user.svr;
                } else {
                    that.usertype = null;
                    that.isLoggedIn = false;
                    that.password = null;          // decoration
                    that.username = null;          // decoration
                    that.ps = null;
                    that.svr = null;
                }
            });
        }

        return this;
    }]);

// configure @User service
// Dependencies :   @$resource - native

// used to get users from @user.json in JSON format
services.service('UserAccounts', ['$resource', function($resource) {

        // @getUserAccounts() - Gets user accounts
        return $resource('./User/:uri/:param/:param2', {}, {
            getById: {method: 'GET', params: {uri: "getById"}, isArray: false},
            getByName: {method: 'GET', params: {uri: "getByName"}, isArray: false},
            getByEmail: {method: 'GET', params: {uri: "getByEmail"}, isArray: false}, // ne raboti poradi '.' vo mailovite
            register: {method: 'POST', params: {uri: "register"}, isArray: false},
            getSessionUser: {method: 'GET', params: {uri: "getSessionUser"}, isArray: false},
            login: {method: 'POST', params: {uri: "login"}, isArray: false},
            logout: {method: 'GET', params: {uri: "logout"}, isArray: false},
            queryAll: {method: 'GET', params: {uri: "queryAll"}, isArray: true},
            queryAllUsertypes: {method: 'GET', params: {uri: "queryAllUserRoles"}, isArray: true},
            queryUsersByUsertype: {method: 'POST', params: {uri: "queryUsersByUserRole"}, isArray: true},
            queryUsersByPS: {method: 'GET', params: {uri: "queryUsersByPS"}, isArray: true},
            queryUsersBySVR: {method: 'GET', params: {uri: "queryUsersBySVR"}, isArray: true},
            update: {method: 'PUT', params: {uri: "update"}, isArray: false},
            delete: {method: 'DELETE', params: {uri: "delete"}, isArray: false}
        });

        return this;
    }]);

services.service('DropDownListValues', ['$resource', function($resource) {

        // @getUserAccounts() - Gets user accounts
        return $resource('./DropDownList/:uri/:param/:param2', {}, {
            getByKeyAndValue: {method: 'GET', params: {uri: "getByKeyAndValue"}, isArray: false},
            insert: {method: 'POST', params: {uri: "insert"}, isArray: false},
            queryAll: {method: 'GET', params: {uri: "queryAll"}, isArray: true},
            queryAllKeys: {method: 'GET', params: {uri: "queryAllKeys"}, isArray: true},
            queryByKey: {method: 'GET', params: {uri: "queryByKey"}, isArray: true},
            update: {method: 'PUT', params: {uri: "update"}, isArray: false},
            delete: {method: 'DELETE', params: {uri: "delete"}, isArray: false}
        });

        return this;
    }]);

// configure @Events service
// Dependencies :   @$resource - native

// used to get events from @events.json in JSON format
services.service('Events', ['$resource', function($resource) {
        return $resource('database/events.json');
    }]);