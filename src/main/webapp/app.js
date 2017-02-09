var app = angular.module("httpServiceApp",[]);
app.controller("httpServiceAppController",httpServiceAppController);

function httpServiceAppController($scope,$http){	
    $http.get("http://localhost:8080/rest/todos")
    .then(function(response){
    	try{
       /* $scope.todos = [
        	{"id":1,"category":"home","todo":"Pay rent"},
        	{"id":2,"category":"home","todo":"Buy milk"},
        	{"id":3,"category":"home","todo":"Buy veggies"}
        	];*/ 
    		$scope.todos = response.data;
        $scope.todo = "Response came";
        for(var i=0;i<todos.length;i++){
            console.log("todos"+i+todos[i].id+todos[i].category+todos[i].todo);
        }
    	}catch(e){
    		console.log(e);
    	}
    
      },function(response){
    	  $scope.todos = "something went wrong"+response.data;
    	  
      }
    );

}