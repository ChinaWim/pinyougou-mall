var app = angular.module('pinyougou',[]);
app.controller('brandController',function ($scope, $http) {
    $scope.findAll = function () {
        $http.get("../../").success(function (data) {
            $scope.list = data;
        });
    };

});