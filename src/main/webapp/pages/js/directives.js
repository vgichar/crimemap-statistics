var directives = angular.module('directives', []);

directives.directive('clickActive', function() {
  return {
    restrict: 'A',
    link : function(scope, element, attrs){
      var children = [];

      if(typeof attrs.clickActive !== "undefined"){
        children = attrs.clickActive.split(";");
      }

      $(document).click(function(){
        element.removeClass("click-active");

        for(var i = 0; i < children.length; i++){
          $("#" + children[i]).removeClass("click-active");
        }
      });

      if(typeof attrs.persist !== "undefined"){
        for(var i = 0; i < children.length; i++){
          $("#" + children[i]).click(function(e){
            e.stopPropagation();
          });
        }
      }

      element.click(function(e){
        if(!$(this).hasClass("click-active")){
          e.stopPropagation();
          $(this).addClass("click-active");

          for(var i = 0; i < children.length; i++){
            $("#" + children[i]).addClass("click-active");
          }
        }
      });
    }
  };
});

directives.directive('menu', function() {
  return {
    restrict: 'A',
    link : function(scope, element, attrs){
      element.find("li").click(function(){
        $(this).addClass("active");
        $(this).siblings().removeClass("active");

        var tabid = $(this).attr("tab-id");
        $("#" + tabid).removeClass("hide");
        $("#" + tabid).siblings().addClass("hide");
      });
      element.find("li").first().click();
    }
  };
});