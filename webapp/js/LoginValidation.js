$(document).ready(function() {
	$("#loginSubmit").click(function() {
		var userName = $("#userName").val();
		if (userName == null || userName == "") {
			$("#spUserName").text("Enter UserName");
			$("#userName").addClass("InputError");
			return false;
		}
		var userPass = $("#userPass").val().length;
		if (userPass == null || userPass == "") {
			$("#spUserPass").text("Enter UserPassword");
			$("#userPass").addClass("InputError");

			$("#spUserName").text("");
			$("#userName").removeClass("InputError");

			return false;
		}
	});
	});

	