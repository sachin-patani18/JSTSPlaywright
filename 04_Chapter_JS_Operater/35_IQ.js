let statusCode = 505;
let category =
    statusCode < 300 ? "sucess":
      statusCode < 400 ? "Redirect" :
        statusCode < 500 ? "Client error" : "Server error";

console.log(`statusCode ${statusCode}: ${category}`);