//视图的例子
var helper = {};
helper.formatDate = function(date){
	alert(date);
	alert("this is the formatDate method");
}
//控制器
/*
var Controller = {};
//使用匿名内部类来封装一个作用域
(Controller.users = function(){
	var nameClick = function(){
		
	};
})(jQuery);

*/

//向模块化进军、创建类
var Person = function(name,sex){
	this.name = name;
	this.sex = sex;
}

//创建一个类
var alice = new Person('alice','男');
//alert(alice.name);					//打印alice
//alert(alice instanceof Person);  	//打印true

//类模拟库
var Class = function(){
	var kclass = function(){
		this.init.apply(this,arguments);
	};
	kclass.prototype.init = function(){
		alert("KClass");
	};
	return kclass;
}

var Person = new Class;
Person.prototype.init = function(name,sex){
	alert(name)
	alert(sex)
}

var person = new Person('alice','sex');