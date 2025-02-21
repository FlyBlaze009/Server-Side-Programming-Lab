// Use Date Object to display the current date & time
let now = new Date();
console.log(now.toLocaleString());

// Work with Math Object (e.g., generate a random number).
let randomNum = Math.floor(Math.random() * 100) + 1; // Random number between 1 and 100
console.log(randomNum);

// Implement AJAX to fetch data from an API
// (e.g., fetch weather data from OpenWeather API and display it on the webpage).

fetch(
  "https://api.openweathermap.org/data/2.5/weather?q=London&appid=YOUR_API_KEY&units=metric"
)
  .then((response) => response.json())
  .then((data) => {
    console.log(`Weather in ${data.name}: ${data.main.temp}°C`);
  })
  .catch((error) => console.error("Error fetching data:", error));
