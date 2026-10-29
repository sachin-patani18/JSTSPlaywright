// Map and Filters


// every vs some

// every — ALL must pass

let a = [80,90,85];
let b = [80,60,85];

console.log(a.every(i => i >=70));
console.log(b.every(i => i >=70));

// some — AT LEAST ONE must pass

console.log(a.some(s => s < 70));
console.log(b.some(s => s < 70));