<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Withdrawal Details</title>
    <style>
        /* Your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        .accountContainer {
            margin-top: 20px;
            width: 100%;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }

        .accountBox {
            margin-top: 10px;
            padding: 10px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            width: 80%;
            box-sizing: border-box;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }


        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
            margin-right: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        .deleteButton {
            background-color: #f44336;
        }

        /* Centered Form Styles */
        #addFormContainer {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #f9f9f9;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 50%;
            box-sizing: border-box;
        }

        .closeButton {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
            font-size: 18px;
            color: #333;
        }
    </style>
</head>

<body>

    <h1>Withdrawal Details</h1>

    <!-- Centered Form for Adding Bank Details -->
    <div id="addFormContainer">
        <span class="closeButton" onclick="closeAddForm()">&times;</span>
        <label for="bankName">Bank Name:</label>
        <input type="text" id="bankName" name="bankName">

        <label for="ifscCode">IFSC Code:</label>
        <input type="text" id="ifscCode" name="ifscCode">

        <label for="accountType">Account Type:</label>
        <input type="text" id="accountType" name="accountType">

        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="accountNumber">

        <label for="accountHolderName">Account Holder Name:</label>
        <input type="text" id="accountHolderName" name="accountHolderName">

        <button onclick="addBankAccount()">Add</button>
        <button onclick="closeAddForm()">Cancel</button>
    </div>

    <div class="accountContainer">
        <div class="accountBox">
            <div>
                <h2>Bank Account</h2>
            </div>
            <div id="bankAccountDetails"></div>
            <div>
                <!-- Add New Button -->
                <button id="addNewButton" onclick="openAddAccountForm()">Add New</button>
            </div>
        </div>
    </div>

    <script>
        function openAddAccountForm() {
            // Show the Add Form Container
            document.getElementById('addFormContainer').style.display = 'block';
        }

        function closeAddForm() {
            // Hide the Add Form Container
            document.getElementById('addFormContainer').style.display = 'none';

            // Clear input fields
            document.getElementById('bankName').value = '';
            document.getElementById('ifscCode').value = '';
            document.getElementById('accountType').value = '';
            document.getElementById('bankAccountNumber').value = '';
            document.getElementById('bankAccountHolder').value = '';
        }

        function addBankAccount() {
            var bankName = document.getElementById('bankName').value;
            var ifscCode = document.getElementById('ifscCode').value;
            var accountType = document.getElementById('accountType').value;
            var accountNumber = document.getElementById('bankAccountNumber').value;
            var accountHolder = document.getElementById('bankAccountHolder').value;

            // Check if all required fields are provided
            if (bankName.trim() === '' || ifscCode.trim() === '' || accountType.trim() === '' || accountNumber.trim() === '' || accountHolder.trim() === '') {
                alert('Please provide all required details');
                return;
            }

            // Create a new account details box
            var accountBox = document.createElement('div');
            accountBox.className = 'accountBox';

            // Add input fields for account details
            accountBox.innerHTML = `
                <strong>Bank Name:</strong> ${bankName}<br>
                <strong>IFSC Code:</strong> ${ifscCode}<br>
                <strong>Account Type:</strong> ${accountType}<br>
                <strong>Account Number:</strong> ${accountNumber}<br>
                <strong>Account Holder:</strong> ${accountHolder}<br>
                <button class="deleteButton" onclick="deleteAccount(this)">Delete</button>
            `;

            // Append the new account box to the Bank Account Details section
            document.getElementById('bankAccountDetails').appendChild(accountBox);

            // Hide the Add Form Container after adding details
            closeAddForm();
        }

        function deleteAccount(button) {
            // Remove the parent div (accountBox) when delete button is clicked
            var accountBox = button.parentElement;
            accountBox.parentElement.removeChild(accountBox);
        }
    </script>

</body>

</html>