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
services.service('Navigation', [ function(){
	this.visit = function(link){
		$("nav a").removeClass("active");
		$("nav a[href*='" + link + "']").addClass("active");
	}
	return this;
}]);
// configure @Languages service
// Dependencies :   @$resource - native

// used to get language library from @:language.json in JSON format
// @:language = ['mk' | 'en']
services.service('Languages', ['$resource', function($resource){
	return $resource('lang/:language.json', {}, {
      query: {method : 'GET', params : {language : 'mk'}, isArray : true}
    });
}]);

// configure @User service
// Dependencies :   @$resource - native

// used to get users from @user.json in JSON format
services.service('User', ['$resource', function($resource){
    
    // @login() - login user
    // @scope.name = "username",  @scope.password = "password"
    this.login = function(){
        this.isLoggedIn = true;
        this.usertype = "admin";
        this.password = null;
    }

    // @login() - logout user
    this.logout = function(){
        this.isLoggedIn = false;
        this.usertype = null;
    }

    // @isLoggedIn() - check if user is logged in
    this.isLoggedIn = function(){
        return this.isLoggedIn;
    }

    return this;
}]);

// configure @User service
// Dependencies :   @$resource - native

// used to get users from @user.json in JSON format
services.service('UserAccounts', ['$resource', function($resource){
    
    // @getUserAccounts() - Gets user accounts
    return $resource('./User/:uri/:param', {}, {
      queryAll: {method : 'GET', params: {uri : "all", param : ""}, isArray : true},
      getById: {method : 'GET', params: {uri : "id", param : "@Id"}, isArray : false},
      getByName: {method : 'GET', params: {uri : "name", param : "@Name"}, isArray : false},
      getByEmail: {method : 'GET', params: {uri : "email", param : "@Email"}, isArray : false},
      register: {method : 'POST', params: {uri : "register"}, isArray : false},
      login: {method : 'POST', params: {uri : "login"}, isArray : false},
      queryByUsertype: {method : 'POST', params: {uri : "usertype"}, isArray : true},
      update: {method : 'PUT', params: {uri : "update"}, isArray : false},
      delete: {method : 'DELETE', params: {uri : "delete", param : "@Id"}, isArray : false}
    });

    return this;
}]);

// configure @Events service
// Dependencies :   @$resource - native

// used to get events from @events.json in JSON format
services.service('Events', ['$resource', function($resource){
	return $resource('database/events.json');
}]);