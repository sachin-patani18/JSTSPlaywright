let tests = ["Login","checkout","search"];
console.log(tests);

for(let i = 0; i < tests.length; i++){
    console.log(i, tests[i]);
}

console.log( " ------------------------");

for(let test of tests){
  console.log(test);
}

console.log("----");


console.log( " -------forEach Below -----------------");

// forEach (no return value)
tests.forEach((test, index) => {

    console.log(`${index}: ${test}`);
});

console.log( " ------------------------");

// entries() — index + value

for (let [i, test] of tests.entries()) {
    console.log(i, test);
}


let students = ["methis", "senthil", "ajay", "rahul"];

for (let i in students) {
    console.log(i, " -> ", students[i]); // index = in
}