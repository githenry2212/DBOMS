angular.module('omsApp')
    .controller('nestedCtrl', ["$scope","$http", function ($scope,$http) {
        $http.get('service/home/message').then(function(resp){
            $scope.message = resp.data.message;
            $scope.success = resp.data.success;
        });
    }]);