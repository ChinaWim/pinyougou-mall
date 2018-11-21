 //控制层 
app.controller('indexController' ,function($scope ,loginService){

	
	//查询实体 
	$scope.showLoginName=function(){
        loginService.showLoginName().success(
			function(response){
				$scope.loginName= response.loginName;
			}
		);				
	}
	



});	
