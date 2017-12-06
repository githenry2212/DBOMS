// angular js 1.6以上版本需要配置,否则chrome中工作不正常
omsApp.config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');
}]);

omsApp.config(['$routeProvider',function($routeProvider){
    $routeProvider.when('/',{
        templateUrl: '/page/home.html'
    }).when('/user/index',{
        templateUrl: '/page/user/index.html'
    }).when('/role/index',{
        templateUrl:'/page/role/index.html'
    }).when('/config/index',{
        templateUrl:'/page/config/index.html'
    }).when('/log/index',{
        templateUrl:'/page/log/index.html'
    }).otherwise({redirectTo:'/'});
}]);
