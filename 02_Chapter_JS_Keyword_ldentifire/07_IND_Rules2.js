var name = "Sachin";
console.log(name);

var firstName = "Sachin";
console.log(firstName);

var This_is_very_long_variable_name = "Sachin";
console.log(This_is_very_long_variable_name);

var lastName = "Patani";
console.log(lastName);

// Naming Conventions (Cases)
// ============================================
// 1. camelCase (standard for JS variables and functions)
let userName = "camelCase";
console.log(userName);
let totalPrice = 99.99;
console.log(totalPrice);
let isLoggedin = true;
console.log(isLoggedin);

// 2. PascalCase (standard for JS classes and constructors)

let UserProfiles = "PascalCase";
console.log(UserProfiles);
let ShoppingCart = "PascalCase";
console.log(ShoppingCart);


// 3. snake_case (underscore separated)
let user_name = "snake_case";
console.log(user_name);
let total_price = 99.99;
console.log(total_price);
let is_logged_in = true;
console.log(is_logged_in);

// 4. SCREAMING_SNAKE_CASE (constants)
const MAX_SIZE = 100;
console.log(MAX_SIZE);
// MAX_SIZE = 200; // This will throw an error because MAX_SIZE is a constant and cannot be reassigned.
const API_KEY = "1234567890";
console.log(API_KEY);
const DATABASE_URL = "https://example.com/db";
console.log(DATABASE_URL);

// 5. Hungarian Notation (prefix with type - older style)
let strName = "string prefix";
console.log(strName);
let bActive = true;     // boolean
let nCount = 5;           // number
let arrItems = [];        // array
