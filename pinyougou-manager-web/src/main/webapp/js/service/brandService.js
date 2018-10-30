//service层
app.service("brandService", function ($http) {
    //根据id查找单个品牌
    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id=" + id);
    };
    //分页＋搜索显示数据
    this.search = function (page,rows,searchEntity) {
        return $http.post("../brand/search.do?page=" + page + "&rows=" + rows, searchEntity);
    };

    //批量删除
    this.dele = function (ids) {
        return $http.get("../brand/delete.do?ids=" + ids);

    };

    this.add = function (entity) {
        return $http.post("../brand/add.do", entity);
    };

    this.update = function (entity) {
        return $http.post("../brand/update.do", entity);
    };
    this.selectOptionList=function(){
        return $http.get('../brand/selectOptionList.do');
    };
});