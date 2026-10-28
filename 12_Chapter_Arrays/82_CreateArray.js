let browser = ["Chrome","Firefox","Safari"];

let score = new Array(5); // Empty array creation
score[0] = "1";  // Assign to value into empty array
score[1] = "Hello";
console.log(score[0]);
console.log(score[1]);
console.log(score);

let score2 = new Array(1,2,3,4);
console.log(score2.length);

let numbers = new Array(100, 200, 300, 400);

let test = Array.of(10, 20, 30, 40, 50);
console.log(test.length);

// Array.from()
let chars = Array.from("hello"); // Each element will take one characters and created the array
console.log(chars.length);
// ["h", "e", "l", "l", "o"]