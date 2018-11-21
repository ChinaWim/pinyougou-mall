//服务层
app.service('loginService',function($http){
	    	
	//查询登录名
	this.showLoginName=function(id){
		return $http.get('../login/name.do');
	}

});
