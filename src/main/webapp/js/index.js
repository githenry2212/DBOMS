var omsApp = angular.module('omsApp',['ngRoute'])

omsApp.controller('nestedCtrl', function($scope) {
    $scope.message= "Nested App Controller Displayed";
});