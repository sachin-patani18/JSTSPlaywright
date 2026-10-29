let score = [45,82,91,60,73];

// Map Taranform the whole array values
let grade = score.map(i => i >=70 ? "pass":"fail");
console.log(grade);

let passing = score.filter(s => s <=70);
console.log(passing);