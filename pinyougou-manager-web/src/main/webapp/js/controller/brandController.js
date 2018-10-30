
app.controller('brandController', function ($scope,$controller,brandService) {

    //定义搜索对象,之所以这里要先声明(html中有用ng-model),因为这个controller会当html加载前调用，
    //并且这个分页方法根据插件的原因调用，所以ng-model还未初始化到scope所以要先声明
    $scope.searchEntity = {};
    //这个可以省略
    $scope.entity = {};


    //$controller也是angular提供的一个服务，可以实现伪继承，
    // 实际上就是与BaseController共享$scope

    //继承
    $controller("baseController",{$scope:$scope});


    //保存
    $scope.save = function () {
        //方法名称
        var obj = null;
        if ($scope.entity.id != null) {
            obj = brandService.update($scope.entity);
        }else {
            obj = brandService.add($scope.entity);
        }
        obj.success(function (data) {
            if (data.success) {
                $scope.reloadList();
            } else {
                alert(data.message);
            }
        });
    };
    //获取单个
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (data) {
            $scope.entity = data;
        });
    };


    //批量删除
    $scope.dele = function () {
        if (confirm('确定?')) {
            brandService.dele($scope.selectIds).success(function (data) {
                if (data.success) {
                    $scope.reloadList();
                    $scope.selectIds = [];
                } else {
                    alert(data.message);
                }
            });
        }

    };

    //页面条件查找加显示
    $scope.search = function (page, rows) {
        brandService.search(page,rows,$scope.searchEntity).success(function (data) {
            $scope.list = data.rows;
            $scope.paginationConf.totalItems = data.total;//更新总记录数
        });
    };

});