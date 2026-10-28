let browser = ["Chrome","Firefox","Safari"];
console.log(browser.length);

browser.pop();
console.log(browser);

let Removed = browser.shift();
console.log(Removed);

console.log(browser);

for (let i = 0; i < browser.length; i++) {
    console.log(browser[i]);
    if (browser[i] === "opera") {
        console.log("Opera doesn't support Automation Now!");
    }
}
