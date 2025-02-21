// Change text, style, or images when a button is clicked.

let text = document.createElement("p");
text.textContent("Original Text");
document.body.appendChild(text);

let button = document.createElement("button");
button.textContent("Click Me!");
document.body.appendChild(button);

button.addEventListener("click", (event) => {
  text.textContent = "Text Changed!";
});

// Implement hover effects using JavaScript events (onmouseover, onmouseout).

let text2 = document.createElement("p");
text2.textContent("Hover over me!");
document.body.appendChild(text2);

text2.addEventListener("mouseover", () => {
  text.style.color = "red";
});

text2.addEventListener("mouseout", () => {
  text.style.color = "black";
});

// Create a dynamic list where users can add or remove items.

let list = document.createElement("ul");
document.body.appendChild(list);

let input = document.createElement("input");
input.placeholder = "Enter item";
document.body.appendChild(input);

let addButton = document.createElement("button");
addButton.textContent = "Add Item";
document.body.appendChild(addButton);

addButton.addEventListener("click", () => {
  if (input.value.trim() !== "") {
    let li = document.createElement("li");
    li.textContent = input.value;

    let removeButton = document.createElement("button");
    removeButton.textContent = "❌";
    removeButton.addEventListener("click", () => li.remove());

    li.appendChild(removeButton);
    list.appendChild(li);
    input.value = "";
  }
});
