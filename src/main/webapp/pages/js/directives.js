var directives = angular.module('directives', []);

directives.directive('menu', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            element.find("li").click(function() {
                $(this).addClass("google-active");
                $(this).siblings().removeClass("google-active");

                var tabid = $(this).attr("tab-id");
                $("#" + tabid).removeClass("hide");
                $("#" + tabid).siblings().addClass("hide");
            });
            element.find("li").first().click();
        }
    };
});

directives.directive('messageBox', function() {
    return {
        restrict: 'E',
        link: function(scope, element, attrs) {
            element.addClass("message-box");
            element.html("<div id='message-box-container'><div id='message-box-title'></div><div id='message-box-text'></div></div>");

            element.click(function(){
                element.trigger("hideElem");
            });
            
            element.on("showElem", function(e, title, text, timeout) {
                element.find("#message-box-title").text(title);
                element.find("#message-box-text").text(text);

                element.css({display: "block"});
                element.animate({opacity: 1}, "fast");

                setTimeout(function() {
                    element.trigger("hideElem");
                }, timeout);
            });

            element.on("hideElem", function() {
                element.animate({opacity: 0}, "fast", function() {
                    element.css({display: "none"});
                });
            });
        }
    };
});