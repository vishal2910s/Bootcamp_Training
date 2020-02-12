// 4. Copy information of one object to another and log it to console.

function cpy_obj(ob){
	var key;
	var obj_cpy = {};
	for(key in ob){
		obj_cpy[key] = ob[key];
	}
	return obj_cpy;
}

var employee = {
	"name": "Vishal", "age": 22, "company": "TTN", "competancy": "BigData"	
}

var employee_copy = cpy_obj(employee);
console.log("Original Object is : "+JSON.stringify(employee));
console.log("Copied Object is : "+JSON.stringify(employee_copy));