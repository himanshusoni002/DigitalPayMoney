<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Withdraw Page</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
    integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SYoprJopbXH70uPvzL+cuO+8CDDlWTha5M6d6P" crossorigin="anonymous">

  <link rel="stylesheet" href="css/withdraw.css">

</head>

<body>

  <div class="withdraw-container">
    <div class="balance">
      Wallet Balance: 5000
    </div>

    <br>
    <br>

    <div class="withdraw-coins-label">
      Withdraw Coins*(Minimum Withdraw amount is 500 coins)
    </div>

    <form action="withdraw" method="post">
      <input type="number" class="withdraw-input" id="withdrawalAmount" name="withdraw" placeholder="Enter Withdraw Coins"> <br> <br>

      <label id="toBank"><input type="radio" name="withdrawalOption" value="bank"> Withdraw to Bank</label> <br> <br>
      <button type="submit" class="submit-button">SUBMIT</button>
    </form>
  </div>

</body>

</html>