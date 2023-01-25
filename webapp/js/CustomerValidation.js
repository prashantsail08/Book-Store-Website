     $(document).ready(function() {
	$("#customerSubmit").click(function() {
		var customerName = $("#customerName").val();
		if (customerName = null || customerName == "") {
			$("#spCustomerName").text("Enter Customer Name");
			$("#customerName").addClass("InputError");
			return false;
		}

		var customerAddress = $("#customerAddress").val();
		if (customerAddress = null || customerAddress == "") {
			$("#spCustomerAddress").text("");
			$("#customerAddress").addClass("InputError");

			$("#spCustomerName").text("");
			$("#customerName").removeClass("InputError");
			return false;
		}

		var customerEmailid = $("#customerEmailid").val();
		if (customerEmailid = null || customerEmailid == "") {
			$("#spCustomerEmailid").text("Enter Customer Emailid");
			$("#customerEmailid").addClass("InputError");

			$("#spCustomerAddress").text("");
			$("#customerAddress").removeClass("InputError");
			return false;
		}

		var customerContactno = $("#customerContactno").val();
		if (customerContactno = null || customerContactno == "") {
			$("#spCustomerContactno").text("Enter Customer Contactno");
			$("#customerContactno").addClass("InputError");

			$("#spCustomerEmailid").text("");
			$("#customerEmailid").removeClass("InputError");

			return false;
		}

		var customerPassword = $("#customerPassword").val();
		if (customerPassword = null || customerPassword == "") {
			$("#spCustomerPassword").text("Enter Customer Password");
			$("#customerPassword").addClass("InputError");

			$("#spCustomerContactno").text("");
			$("#customerContactno").removeClass("InputError");
			return false;
		}



	});

});

$(document).ready(function() {
		$("#customerPassword").keyup(function() {
			var len = $("#customerPassword").val().length;

			if (len == 0) {
				$("#spCustomerPassword").text("");
				$("#spCustomerPassword").removeClass("red");
			} else if (len < 4) {
				$("#spCustomerPassword").text("WEAK");
				$("#spCustomerPassword").addClass("red");
				$("#spCustomerPassword").removeClass("orange");
			} else if (len < 8) {
				$("#spCustomerPassword").text("MEDIUM");
				$("#spCustomerPassword").addClass("orange");
				$("#spCustomerPassword").removeClass("green");
			} else {
				$("#spCustomerPassword").text("STRONG");
				$("#spCustomerPassword").addClass("green");
			}
			
		});
});