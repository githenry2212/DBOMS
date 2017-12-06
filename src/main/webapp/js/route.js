angular.module("omsApp", ["ui.router", "oc.lazyLoad"])
    .config(function ($stateProvider, $urlRouterProvider) {
        var homeState = {
            name: "home",
            url: "/",
            templateUrl: "/page/home.html",
            resolve: {
                scriptLoader: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('/js/home.js');
                }]
            }
        };
        var userState = {
            name: "user",
            url: "/user/index",
            templateUrl: "/page/user/index.html"
        };
        var roleState = {
            name: "role",
            url: "/role/index",
            templateUrl: "/page/role/index.html"
        };
        var configState = {
            name: "config",
            url: "/config/index",
            templateUrl: "/page/config/index.html"
        };
        var logState = {
            name: "log",
            url: "/log/index",
            templateUrl: "/page/log/index.html"
        };
        $stateProvider.state(homeState);
        $stateProvider.state(userState);
        $stateProvider.state(roleState);
        $stateProvider.state(configState);
        $stateProvider.state(logState);
        //二级路由跳转
        //$urlRouterProvider.when('/sale', '/sale/unexecuted');
        $urlRouterProvider.otherwise("/home");
    });
