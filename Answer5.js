/*
5. create a list of objects of Employee with info as follow :

    -Name, age, salary ,DOB

    -filter all employees with salary greater than 5000

    -group employee on the basis of their age
    
	-fetch employees with salary less than 1000 and age greater than 20. Then give them an increment 5 times their salary.
*/


/*
	create a list of objects of Employee with info as follow :

    -Name, age, salary ,DOB
*/
var employees=[
  {name:"Vishal", age:23, salary:8000, DOB:"March 12, 1997"},
  {name:"Prashant", age:27, salary:6500, DOB:"June 2, 1993"},
  {name:"Suraj", age:20, salary:500, DOB:"December 20, 2000"},
  {name:"Rajesh", age:17, salary:2700, DOB:"April 30, 2003"},
  {name:"Ashish", age:23, salary:7500, DOB:"May 07, 1997"},
  {name:"Pratap", age:23, salary:700, DOB:"June 18, 1997"},
  {name:"Rohan", age:30, salary:7000, DOB:"October 30, 1990"},
  {name:"Pankaj", age:17, salary:12700, DOB:"February 13, 2003"}
]

//filter all employees with salary greater than 5000

function filter_by_salary(obj){
		if(obj.salary>5000){
			return obj;
		}
}
console.log(employees.filter(filter_by_salary));

//group employee on the basis of their age

groupEmps = {}
for(var i=0;i<employees.length;i++){
    if(groupEmps.hasOwnProperty(employees[i]['age'])){
        groupEmps[employees[i]['age']].push(employees[i]);
    }
    else{
        groupEmps[employees[i]['age']] = [];
        groupEmps[employees[i]['age']].push(employees[i]);
    }
}

console.log("Grouped employees on the basis of their ages are: ")
console.log(groupEmps);

//fetch employees with salary less than 1000 and age greater than 20. Then give them an increment 5 times their salary.

function salary_and_age(obj){
		if(obj.salary<1000 && obj.age>20){
			return obj;
		}
}

var inc_salary=employees.filter(salary_and_age);
console.log("Employees with salary less than 1000 and age greater than 20 are: "+JSON.stringify(inc_salary));
var i;
for (i in inc_salary){
	inc_salary[i]["salary"]=(inc_salary[i]["salary"])*6;
}
console.log("Employees salary after the increment of 5 times in their salary is : "+JSON.stringify(inc_salary));
