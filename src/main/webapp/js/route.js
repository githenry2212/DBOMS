// angular js 1.6以上版本需要配置,否则chrome中工作不正常
omsApp.config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');
}]);

omsApp.config(['$routeProvider',function($routeProvider){
    $routeProvider
    .when('/',{templateUrl:'/html/homepage.html'})
    .when('/user/index',{templateUrl:'/html/user/index.html'})
    .when('/role/index',{templateUrl:'/html/role/index.html'})
    .when('/config/index',{templateUrl:'/html/config/index.html'})
    .when('/log/index',{templateUrl:'/html/log/index.html'})
    .otherwise({redirectTo:'/'});
}]);