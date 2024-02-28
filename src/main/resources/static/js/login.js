function authenticate(event) {
    event.preventDefault();

    // Get values from the form
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // Example authentication logic (replace with your own logic)
    if (username === 'user' && password === '1234') {
        document.getElementById('loginauth').innerText = 'Login Successful !';
        window.location.href = 'wallet';
        
    } else {
        document.getElementById('error-msg').innerText = 'Invalid username or password.';
        
    }  
}