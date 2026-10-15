// ============================================
// JavaScript Identifier Rules - IQ
// ============================================

let validName = "starts with letter";
console.log(validName);
let _private = "starts with underscore";
console.log(_private);
let $jquery = "starts with dollar sign";
console.log($jquery);

let item1 = "letter then digit";
console.log(item1);
let _temp2 = "underscore then digit";
console.log(_temp2);
let $var123 = "dollar then digits";
console.log($var123);
let a1_b2 = "mixed letters digits underscore";
console.log(a1_b2);

//  let 1stPlace = "invalid"; // This will throw error because variable name cannot start with digit
//  let 2ndItem = "invalid"; // This will also throw an error for the same reason

// let Function = "invalid"; 
// let Function = "invalid"; but it actually works. Function is a built-in name, not a reserved word

let MyVar = "uppercase M";
console.log(MyVar);
let myvar = "lowercase v";
console.log(myvar);

let café = "Unicode letter é";
console.log(café);
let 变量 = "Chinese characters";
console.log(变量);
let \u0041 = "Unicode escape for A";
console.log(\u0041);
let \u005f = "Unicode escape for _";
console.log(\u005f);

// let my-name = "invalid";
// let my name = "invalid";      // SyntaxError: Unexpected identifier
// let my@name = "invalid";      // SyntaxError: Unexpected token '@'
// let my#name = "invalid";      // SyntaxError: Unexpected token '#'
// let my!name = "invalid";      // SyntaxError: Unexpected token '!'

// 1. camelCase (standard for JS variables and functions)
let userName = "camelCase";
console.log(userName);
let totalPrice = 99.99;
console.log(totalPrice);
let isLoggedIn = true;
console.log(isLoggedIn);

// 2. PascalCase (standard for JS classes and constructors)
let UserProfile = "PascalCase";
console.log(UserProfile);
let ShoppingCart = "class name style";
console.log(ShoppingCart);
function Person() { 
    return "constructor"; 
}

// 3. snake_case (underscore separated)
let user_name = "snake_case";
console.log(user_name);
let total_price = 49.99;
console.log(total_price);
let is_logged_in = false;
console.log(is_logged_in);

// 4. SCREAMING_SNAKE_CASE (constants)
const MAX_SIZE = 100;
console.log(MAX_SIZE);
const API_KEY = "abc123";
console.log(API_KEY);
const DATABASE_URL = "localhost";
console.log(DATABASE_URL);