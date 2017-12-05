// angular js 1.6以上版本需要配置,否则chrome中工作不正常
omsApp.config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');
}]);

omsApp.config(['$routeProvider',function($routeProvider){
    $routeProvider
    .when('/',{templateUrl:'/HomePage.html'})
    .when('/xxx1',{templateUrl:'这是x1页面'})
    .when('/xxx/xxx2',{templateUrl:'这是x2页面'})
    .when('/xxx/xxx3',{templateUrl:'这是x3页面'})
    .when('/xxx/xxx4',{templateUrl:'这是x4页面'})
    .otherwise({redirectTo:'/'});
}]);