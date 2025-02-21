// Validate a registration form with fields like
// name, email, phone number, and password.

// Ensure the email format is correct using a regular expression.

// Check that the password is strong (contains uppercase, lowercase, numbers, special
// characters).

// Show real-time validation messages using JavaScript.

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("registerForm");
  const nameInput = document.getElementById("name");
  const emailInput = document.getElementById("email");
  const phoneInput = document.getElementById("phone");
  const passwordInput = document.getElementById("password");
  const messageDiv = document.getElementById("messages");

  function showMessage(message, color) {
    messageDiv.textContent = message;
    messageDiv.style.color = color;
  }

  function validateEmail(email) {
    return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email);
  }

  function validatePhone(phone) {
    return /^\d{10}$/.test(phone);
  }

  function validatePassword(password) {
    return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,}$/.test(
      password
    );
  }

  emailInput.addEventListener("input", function () {
    if (!validateEmail(emailInput.value)) {
      showMessage("Invalid email format!", "red");
    } else {
      showMessage("Valid email ✅", "green");
    }
  });

  phoneInput.addEventListener("input", function () {
    if (!validatePhone(phoneInput.value)) {
      showMessage("Phone must be 10 digits!", "red");
    } else {
      showMessage("Valid phone ✅", "green");
    }
  });

  passwordInput.addEventListener("input", function () {
    if (!validatePassword(passwordInput.value)) {
      showMessage(
        "Weak password! Must include uppercase, lowercase, number & special character.",
        "red"
      );
    } else {
      showMessage("Strong password ✅", "green");
    }
  });

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    if (
      nameInput.value.trim() === "" ||
      emailInput.value.trim() === "" ||
      phoneInput.value.trim() === "" ||
      passwordInput.value.trim() === ""
    ) {
      showMessage("All fields are required!", "red");
      return;
    }

    if (!validateEmail(emailInput.value)) {
      showMessage("Enter a valid email!", "red");
      return;
    }

    if (!validatePhone(phoneInput.value)) {
      showMessage("Enter a valid 10-digit phone number!", "red");
      return;
    }

    if (!validatePassword(passwordInput.value)) {
      showMessage(
        "Password must include uppercase, lowercase, number & special character!",
        "red"
      );
      return;
    }

    showMessage("Registration Successful! ✅", "green");
  });
});
