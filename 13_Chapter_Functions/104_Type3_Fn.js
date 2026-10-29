// Type 3 =  with argument/parameter but no return type.

function greetByName(name){
    console.log("hi", name);
}

greetByName("Sachin");
greetByName("Shreyansh");
greetByName("Krishiv");
greetByName("kichu");

let name1 = greetByName("Hello there");
console.log(name1);  // Undefined because no return type present