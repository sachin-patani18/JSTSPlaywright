let Original = [1,2,3,4];

let copy1 = [...Original];
console.log(Original);
console.log(copy1);

let copy2 = Original.slice();
copy2.push(92);
copy1.push(93);
console.log(Original);
console.log(copy1);
console.log(copy2);


// Deep COPY
let deep_copy_array = Original;
// Deep copy

deep_copy_array.push(91);

console.log(Original);
console.log(deep_copy_array);
