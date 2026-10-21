let enviroment = "Prod";
let baseUrl = enviroment === "Prod"? "https://api.example.com": "https://staging-api.example.com";
console.log(baseUrl);