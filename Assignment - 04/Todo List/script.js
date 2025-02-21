document.addEventListener("DOMContentLoaded", function () {
  const taskInput = document.getElementById("taskInput");
  const addButton = document.getElementById("addTask");
  const taskList = document.getElementById("taskList");

  addButton.addEventListener("click", function () {
    const taskText = taskInput.value.trim();
    if (taskText === "") {
      alert("Task cannot be empty!");
      return;
    }

    const li = document.createElement("li");
    li.textContent = taskText;

    li.addEventListener("click", function () {
      li.classList.toggle("completed");
    });

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "❌";
    deleteButton.addEventListener("click", function () {
      li.remove();
    });

    li.appendChild(deleteButton);
    taskList.appendChild(li);
    taskInput.value = "";
  });
});
