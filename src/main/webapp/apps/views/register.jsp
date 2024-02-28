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
        <form action="registration" method="post" id="registrationForm">
            <h2>Register</h2>

            <label for="email">Email*</label>
            <input type="email" id="email" name="email" pattern="[a-zA-Z0-9._%+-]+@gmail\.com$" required>
            <span id="emailError"></span>

            <label for="password">Password*</label>
            <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[A-Z])(?=.*\W).{5,}" required>
            <span id="passwordMismatch1"></span>

            <label for="confirmPassword">Confirm Password*</label>
            <input type="password" id="confirmPassword" name="confirmPassword"
                pattern="(?=.*\d)(?=.*[A-Z])(?=.*\W).{5,}" required>
            <span id="passwordMismatch2"></span>

            <div id="tc">
                <input type="checkbox" id="terms" name="terms" required>
                <label for="terms">I accept the terms and conditions</label>
            </div>

            <br>
            <button type="submit" id="submitButton" disabled>Submit</button>
        </form>
    </div>

    <script>
        document.getElementById('registrationForm').addEventListener('input', function () {
            var email = document.getElementById('email').value;
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;
            var termsChecked = document.getElementById('terms').checked;

            var emailError = document.getElementById('emailError');
            var passwordMismatch = document.getElementById('passwordMismatch');
            var submitButton = document.getElementById('submitButton');

            var emailRegex = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;

            if (!email || !emailRegex.test(email)) {
                event.preventDefault();
                emailError.innerText = 'incorrect entry.';
            } else {
                emailError.innerText = '';
            }

            if (password !== confirmPassword) {
                passwordMismatch1.innerText = 'incorrect entry.';
            } else {
                passwordMismatch1.innerText = '';
            }

            if (password !== confirmPassword) {
                passwordMismatch2.innerText = 'incorrect entry.';
            } else {
                passwordMismatch2.innerText = '';
            }

            submitButton.disabled = !(password === confirmPassword && termsChecked);
        });

    </script>

</body>

</html>