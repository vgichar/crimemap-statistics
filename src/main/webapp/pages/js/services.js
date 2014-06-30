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
services.service('User', ['$resource', 'UserAccounts', function($resource, UserAccounts){

    var that = this;

    // @login() - login user
    // @scope.name = "username",  @scope.password = "password"
    this.login = function(name, password){
        UserAccounts.login({"id" : -1, "name" : name, "email" : name, "password" : password}, function(user){
          if(user.id != -1){
            that.usertype = user['usertype'];
            that.isLoggedIn = true;
            that.password = null;          // decoration
            that.username = that.username; // decoration
          }else{
            that.usertype = null;
            that.isLoggedIn = false;
            that.password = null;          // decoration
            that.username = null;          // decoration
          }
        });
    }

    // @login() - logout user
    this.logout = function(){
        UserAccounts.logout(function(){
          that.isLoggedIn = false;
          that.usertype = null;
          that.password = null;          // decoration
          that.username = null;          // decoration
        });
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
      getById: {method : 'GET', params: {uri : "getById", param : "id"}, isArray : false},
      getByName: {method : 'GET', params: {uri : "getByName", param : "name"}, isArray : false},
      getByEmail: {method : 'GET', params: {uri : "getByEmail", param : "email"}, isArray : false}, // ne raboti poradi '.' vo mailovite
      register: {method : 'POST', params: {uri : "register"}, isArray : false},
      login: {method : 'POST', params: {uri : "login"}, isArray : false},
      logout: {method : 'GET', params: {uri : "logout"}, isArray : false},
      queryAll: {method : 'GET', params: {uri : "queryAll"}, isArray : true},
      queryByUsertype: {method : 'GET', params: {uri : "queryByUsertype", param : "usertype"}, isArray : true},
      update: {method : 'PUT', params: {uri : "update"}, isArray : false},
      delete: {method : 'DELETE', params: {uri : "delete", param : "id"}, isArray : false}
    });

    return this;
}]);

// configure @Events service
// Dependencies :   @$resource - native

// used to get events from @events.json in JSON format
services.service('Events', ['$resource', function($resource){
  return $resource('database/events.json');
}]);