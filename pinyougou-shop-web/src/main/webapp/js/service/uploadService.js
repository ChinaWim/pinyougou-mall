//文件上传服务层
app.service("uploadService", function ($http) {

    this.uploadFile = function () {
        var formData = new FormData();
        formData.append("file", file.files[0]);

        /*anjularjs对于post和get请求默认的Content-Type header 是application/json。
        通过设置‘Content-Type’: undefined，这样浏览器会帮我们把Content-Type
        设置为 multipart/form-data.*/

        /*通过设置 transformRequest: angular.identity ，anjularjs
        transformRequest function 将序列化我们的formdata object.*/

        return $http({
            method: "POST",
            url: "../upload.do",
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        });
    };

});