// Type 1 - No param / argument, No Return -> final retunr undefined.


// Fn Define
function greet(){
    console.log("Hello, The javascript world is here");
}
// Fn Calling
greet();

greet()
greet()
greet()

function openbrowser(){
    console.log("Open the browser");
}

openbrowser();

let msg = greet(); // undefined there is not return.
console.log(msg);