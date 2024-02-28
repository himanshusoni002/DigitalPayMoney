<!DOCTYPE html>
<html>
<head>
	<title>Paytm Wallet</title>
	<link rel="stylesheet" type="text/css" href="css/walletStyle.css">
</head>
<body>
	<div class="container">
		<h1>Paytm<span style="color:#f00;">UPI</span> WALLET</h1>
		<h2>₹<span id="balance">0</span></h2>
		<button onclick="addMoney()">Add Money</button>
		<input type="number" id="amount" placeholder="Enter Amount">
		<button onclick="pay()">Pay</button>
		<h3>Have a Promocode?</h3>
		<input type="text" id="promocode" placeholder="Enter Promocode">
		<h3>GIFT VOUCHER</h3>
		<h4>₹<span id="giftvoucher">0</span></h4>
		<h4>No Paytm cash transactions associated with your account.</h4>
		<h3>Home &gt; Passbook</h3>
		<h3>Company</h3>
		<h3>Career</h3>
		<h4>Hi, <span id="phone">9256324353</span></h4>
		<h3>TOTAL BALANCE</h3>
		<h2>₹<span id="totalbalance">0</span></h2>
		<h4>Powered by paytm Bank</h4>
		<h3>Payments</h3>
	</div>
	<script src="js/script.js"></script>
</body>
</html>