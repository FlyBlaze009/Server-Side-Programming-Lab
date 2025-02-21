// Display an alert box when the user submits a form.
document.querySelector("form").addEventListener("submit", (event) => {
  event.preventDefault();
  alert("Form Submitted Successfully!");
});

// Use a confirmation box before deleting an item from a list.
function deleteItem(item) {
  confirmDelete = confirm(`Are you sure you want to delete item${item}?`);
  if (confirmDelete) {
    console.log(`Item${item} deleted successfully!`);
  } else {
    console.log(`Item${item} was not deleted!`);
  }
}

// Implement a prompt box to ask the user for input and display it on the page.
let name = prompt("Enter you name.");
if (name) {
  document.body.innerHTML = `<h2> ${name} </h2>`;
} else {
  document.body.innerHTML = `<h2> You did not enter a name! </h2>`;
}
