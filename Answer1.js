//Prompt for amount, interest rate and no. of years and calculate simple interest.

var principle = prompt("Enter Principle Amount: ");
var rate = prompt("Enter Interest rate: ");
var time = prompt("Enter time in years: ");
var SI = (principle*rate*time)/100;
alert("Your Simple Interest is : "+SI);