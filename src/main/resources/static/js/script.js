function addMoney() {
	var amount = prompt("Enter the amount you want to add:");
	if (amount != null) {
		document.getElementById("balance").innerHTML = amount;
		document.getElementById("totalbalance").innerHTML = amount;
	}
}

function pay() {
	var amount = document.getElementById("amount").value;
	if (amount != "") {
		document.getElementById("balance").innerHTML = (parseInt(document.getElementById("balance").innerHTML) - parseInt(amount));
		document.getElementById("totalbalance").innerHTML = (parseInt(document.getElementById("totalbalance").innerHTML) - parseInt(amount));
	}
}