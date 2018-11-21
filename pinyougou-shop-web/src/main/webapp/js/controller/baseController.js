app.controller("baseController",function ($scope) {
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [5, 20, 30, 40, 50],
        onChange: function () {
            //这个加载完页面会自动加载
            $scope.reloadList();//重新加载
        }
    };

    $scope.reloadList = function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };


    //定义选中的ID集合
    $scope.selectIds = [];
    //更新复选
    $scope.updateSelection = function ($event, id) {
        //如果是被选中，则添加到数组
        //$event.target获取这个document对象
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            //删除
            $scope.selectIds.splice(idx, 1);
        }
    };

    // 我们需要将一个json字符串中某个属性的值提取出来，用逗号拼接成一个新的字符串。

    $scope.jsonToString = function (jsonString,key) {
        var string = "";
        var jsonObject = JSON.parse(jsonString);
        for(var i = 0; i < jsonObject.length; i++) {
            if(i != jsonObject.length - 1){
                string += jsonObject[i][key] + ",";
            }else {
                string += jsonObject[i][key];
            }
        }
        return string;
    }
    



});

