//is palindrome string

var inp_str = prompt("Input a String: ");
var rev_str = inp_str.split("").reverse().join("")
if (inp_str == rev_str){
	alert("Entered string is PALLINDROME!");
}
else{
	alert("Entered string is not PALLINDROME!");
}