document.addEventListener("DOMContentLoaded", function () {
  const chatBox = document.getElementById("chatBox");
  const userInput = document.getElementById("userInput");
  const sendButton = document.getElementById("sendButton");

  sendButton.addEventListener("click", function () {
    const message = userInput.value.trim().toLowerCase();
    if (message === "") return;

    displayMessage("You: " + message, "user");
    setTimeout(() => respond(message), 500);

    userInput.value = ""; // Clear input field
  });

  function respond(message) {
    let response = "";

    if (message.includes("hello") || message.includes("hi")) {
      response = "Hello! How can I help you today? 😊";
    } else if (message.includes("how are you")) {
      response = "I'm just a bot, but I'm doing great! Thanks for asking. 😊";
    } else if (message.includes("weather")) {
      response =
        "I'm not sure, but you can check the weather at weather.com! 🌤️";
    } else if (message.includes("bye")) {
      response = "Goodbye! Have a great day! 👋";
    } else {
      response =
        "Sorry, I don't understand that. Can you ask something else? 🤔";
    }

    displayMessage("Bot: " + response, "bot");
  }

  function displayMessage(text, sender) {
    const messageDiv = document.createElement("p");
    messageDiv.textContent = text;
    messageDiv.classList.add(sender);
    chatBox.appendChild(messageDiv);
    chatBox.scrollTop = chatBox.scrollHeight; // Auto-scroll to the latest message
  }
});
