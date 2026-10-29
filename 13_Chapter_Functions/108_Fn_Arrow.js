function greet(name){
    return `Hello, ${name}`;
}

const greet1 = function(name){
    return `Hello, ${name}`;
}

// Arrow Fn :
const greet2 = (name) => `Hello, ${name}`;
// If you want to make a normal function to arrow function.
// Remove the keyword function, remove the keyword return, remove the curly braces, and use the =>

console.log(greet("Normal_FN"));
console.log(greet1("Fn_as_Expression"));
console.log(greet2("Fn_Arrow"));