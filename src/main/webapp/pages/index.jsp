<!DOCTYPE html>
<html ng-app="mvrApp">
    <head>
        <title>MVR</title>
        <meta charset="UTF-8">
        <script type="text/javascript" src="./js/lib/jquery.min.js"></script>
        <script type="text/javascript" src="./js/lib/d3.js"></script>
        <script type="text/javascript" src="./js/lib/crossfilter.js"></script>
        <script type="text/javascript" src="./js/lib/dc.js"></script>
        <script type="text/javascript" src="./js/lib/colorbrewer.js"></script>
        <link rel="shortcut icon" href="./img/tabicon.ico">
        <link rel="stylesheet" type="text/css" href="./css/theme.css">
        <link rel="stylesheet" type="text/css" href="./css/settings.css">
        <link rel="stylesheet" type="text/css" href="./css/lib/jquery-ui.min.css">
    </head>
    <body ng-controller="indexController" ng-init="init()">
        <header>
            <a href="http://www.mvr.gov.mk/"><img class="header-logo" src="./img/mvrLogo.png"></a>
            <nav>
                <ul>
                    <li><a href="#/home">{{lang.home}}</a></li><li><a href="#/filter">{{lang.filter}}</a></li><li><a href="#/about">{{lang.about}}</a></li>
                </ul>
            </nav>
            <span class="settings-bar" style="width: 120px;">
                <img src="img/settings.png" class="icon clickable right" click-active="dropdown-menu" persist>
            </span>
        </header>

        <div class="right">
            <ul id="dropdown-menu">
                <li click-active="login-popup" persist>{{User.isLoggedIn?lang.logout:lang.login}}</li>
                <li onclick="javascript: location.href = '#/settings';">{{lang.settings}}</li>
            </ul>
            <form id="login-popup" action="" autocomplete="off">
                <table class="{{User.isLoggedIn?'hide':'show'}}">
                    <tr>
                        <td>
                            <label for="username">{{lang.name}}</label>
                        </td>
                        <td>
                            <input type="text" id="username" placeholder="example" ng-model="User.username"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">{{lang.password}}</label>
                        </td>
                        <td>
                            <input type="password" id="password" placeholder="password" ng-model="User.password"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="right" ng-click="User.login();" value="{{lang.login}}">
                            <img src="img/loader.gif" class="hide right" style="margin-right: 10px;" id="loader">

                            <input type="checkbox" id="remember" ng-model="User.remember" ng-init="User.remember = true"/>
                            <label for="remember">{{lang.remember}}</label>
                        </td>
                    </tr>
                </table>
                <table class="{{!User.isLoggedIn?'hide':'show'}}">
                    <tr>
                        <td>
                            {{lang.name}}: {{User.username}}
                        </td>
                        <td>
                            <input type="submit" class="right" ng-click="User.logout();" value="{{lang.logout}}">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div ng-view></div>


        <script type="text/javascript" src="./js/lib/angular.min.js"></script>
        <script type="text/javascript" src="./js/lib/angular-resource.min.js"></script>
        <script type="text/javascript" src="./js/lib/angular-route.min.js"></script>
        <script type="text/javascript" src="./js/lib/angular-animate.min.js"></script>
        <script type="text/javascript" src="./js/lib/angular-local-storage.js"></script>

        <script type="text/javascript" src="./js/ngApp.js"></script>
        <script type="text/javascript" src="./js/controllers.js"></script>
        <script type="text/javascript" src="./js/services.js"></script>
        <script type="text/javascript" src="./js/directives.js"></script>
    </body>
</html>