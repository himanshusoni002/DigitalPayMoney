<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Withdraw Page</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
    integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SYoprJopbXH70uPvzL+cuO+8CDDlWTha5M6d6P" crossorigin="anonymous">

  <link rel="stylesheet" href="css/withdraw.css">
  <link rel="stylesheet" href="css/deposit.css">

</head>

<body>

  <div class="withdraw-container">
    <div class="balance">
      Wallet Balance: 5000
    </div>

    <br>
    <br>

    <div class="withdraw-coins-label">
      Coins*(Minimum deposit amount is 250 coins)
    </div>

    <form action="deposit" method="post" >
      <input type="number" class="deposit-input" id="depositAmount" name="deposit" placeholder="Enter Deposit Coins"> <br> <br>

      <button type="submit" class="submit-button">DEPOSIT COINS</button>
    </form>
  </div>

</body>

</html>