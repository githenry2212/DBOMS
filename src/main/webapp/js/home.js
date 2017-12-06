angular.module('omsApp', [])
    .controller('nestedCtrl', ["$scope", function ($scope) {
        $scope.message = "Nested App Controller Displayed";
        $scope.sayHello = function () {
            return "hello world";
        }
    }]);