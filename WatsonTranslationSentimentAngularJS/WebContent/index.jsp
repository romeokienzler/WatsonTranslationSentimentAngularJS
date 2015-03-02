<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
</head>
<body>

	<div ng-app="" ng-controller="customersController">
		<form novalidate>
			<input type="text" ng-model="query">
			<button ng-click="submit()">Submit</button>
		</form>
		<br>
		<p>
			You: {{ query }} <br>
		<p>
			Watson: {{ message }} <br>
		<p>
			Sentiment: {{ sentiment }}<br>
		<p>
			<img ng-if="sentiment>0" src="good.png" /><img ng-if="sentiment<0"
				src="bad.png" /><img ng-if="sentiment==0" src="neutral.png" />
	</div>



	<script>
		function customersController($scope, $http) {
			$scope.submit = function() {
				$http.get(encodeURI("RestService?message=" + $scope.query))
						.success(function(response, data, status) {
							$scope.message = response.split(";")[0];
							$scope.sentiment = response.split(";")[1]
						}).error(
								function(response, data, status) {
									alert("error" + response + ":" + data + ":"
											+ status);
								});

			};

		}
	</script>
</body>
</html>