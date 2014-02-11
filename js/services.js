// ##################################################################################################################################
// #####                                       Developed by: Vojdan Gicharovski - vGichar                                       #####
// #####                                                 Mentor: Riste Stojanov                                                 #####
// ##################################################################################################################################

// create module @services
// Dependencies :   @ngResource - native

// used to create singleton factories, services and providers
var services = angular.module('services', ['ngResource']);

// configure @Navigation service
// Dependencies :   none

// used to highlight active links
services.service("Navigation", function (){
	this.visit = function(link){
	    $('nav a').removeClass('active');
	    $('nav > ul > li > a[href*="' + link + '"]').addClass('active');
	}
});

// configure @Events service
// Dependencies :   @$resource - native

// used to get events from @events.json in JSON format
services.service('Events', ['$resource', function($resource){
	return $resource('database/events.json');
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