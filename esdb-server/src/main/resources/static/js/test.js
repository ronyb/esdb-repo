$(function() {
	
	var obj = {};
	
	obj.str1 = "hello!";
	obj.num1 = 1;
	obj.num2 = 1.2;
	obj.bool1 = true;
	obj.boo2 = false;
	obj.str2 = "world?";
	
	var jsonStr = JSON.stringify(obj);
	
	console.log(jsonStr);
	
	
});