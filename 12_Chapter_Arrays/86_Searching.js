let results = ["Pass","Fail","Pass","Error","Fail"];
console.log(results);

let result = results.indexOf("Fail");
console.log(result);

let result1 = results.indexOf("skip"); // -1 because not found
console.log(result1);

// lastIndexOf — searches from the end
let result2 = results.lastIndexOf("Fail");
console.log(result2);

// includes — returns boolean
let result3 = results.includes("Error"); // true
console.log(result3);