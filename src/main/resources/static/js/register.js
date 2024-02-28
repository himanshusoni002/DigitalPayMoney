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

function authenticate(event) {
    // Your existing registration logic here

    // If registration is successful, show the OTP entry form
    document.getElementById('registrationForm').style.display = 'none';
    document.getElementById('otpForm').style.display = 'block';

    event.preventDefault(); // Prevent the form from submitting (you can remove this if needed)


}


function validateOTP(event) {
    // Your OTP validation logic here

    // After successful OTP validation, you can redirect to a new page or perform other actions

    event.preventDefault(); // Prevent the form from submitting (you can remove this if needed)
}

function goBack() {
    document.getElementById('registrationForm').style.display = 'block';
    document.getElementById('otpForm').style.display = 'none';
}