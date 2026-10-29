// If we use this we sort the element normally
let num = [1,10,21,2];
num.sort((a,b) => (a-b));
console.log(num);

// if we use this we sort the element accending - desending
num.sort((a,b) => (b-a));
console.log(num);

let fruits = ["banana","Apple","Cherry"];
fruits.sort((a,b) => a.localeCompare(b));
console.log(fruits);