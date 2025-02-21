// Declare and use variables (var, let, const).
const x = 10;
let age = 20;
var z = 30;

// Write JavaScript functions to perform basic calculations
// (e.g., a BMI calculator,temperature converter).

function calculateBMI(weight, height) {
  if (weight <= 0 || height <= 0) {
    throw new Error("Invalid Weight/ Height");
  }

  let bmi = weight / height ** 2;
  return bmi.toFixed(2);
}

// Implement conditions (if-else, switch-case) to validate user input.

// Using If-Else
if (age >= 18) {
  console.log("The person can vote");
} else {
  console.log("The person cannot vote");
}

// Using switch-case
function validateUserRole(role) {
  switch (role.toLowerCase()) {
    case "admin":
      console.log("Access granted: Admin panel.");
      break;
    case "editor":
      console.log("Access granted: Edit content.");
      break;
    case "viewer":
      console.log("Access granted: View content only.");
      break;
    default:
      console.log("Invalid role. Access denied.");
  }
}

// Use loops (for, while, do-while) to generate lists dynamically
// (e.g., a dynamic table of users)

// Using a for loop
let usersFor = [];
for (let i = 1; i <= 3; i++) {
  usersFor.push(`User${i}`);
}
console.log("For loop:", usersFor);

// Using a while loop
let usersWhile = [];
let i = 1;
while (i <= 3) {
  usersWhile.push(`User${i}`);
  i++;
}
console.log("While loop:", usersWhile);

// Using a do-while loop
let usersDoWhile = [];
let j = 1;
do {
  usersDoWhile.push(`User${j}`);
  j++;
} while (j <= 3);
console.log("Do-While loop:", usersDoWhile);
