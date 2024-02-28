<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/register.css">
  <title>Register Page</title>
</head>

<body>
  <div class="container">
    <form action="emailverify" method="post" id="loginForm">

      <label for="email">Email*</label>
      <input type="email" id="email" name="email" pattern="[a-zA-Z0-9._%+-]+@gmail\.com$" required>
      <span id="emailError"></span>

      <button type="submit" id="submitButton">Submit</button>
    </form>
  </div>

  <script>
   document.getElementById('loginForm').addEventListener('input', function () {
            var email = document.getElementById('email').value;
           
            var emailError = document.getElementById('emailError');

            var emailRegex = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;

            if (!email || !emailRegex.test(email)) {
                event.preventDefault();
                emailError.innerText = 'incorrect entry.';
            } else {
                emailError.innerText = '';
            }
        });

  </script>

</body>

</html>