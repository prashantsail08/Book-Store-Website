$(document).ready(function() {
	$("#bookSubmit").click(function() {
		var bookName = $("#bookName").val();
		if (bookName == null || bookName == "") {
			$("#spBookName").text("Enter Book Name");
			$("#bookName").addClass("InputError")

			return false;
		}

		var bookAuthor = $("#bookAuthor").val();
		if (bookAuthor == null || bookAuthor == "") {
			$("#spBookAuthor").text("Enter Book Author");
			$("#bookAuthor").addClass("InputError");
			
			$("#spBookName").text("");
			$("#bookName").removeClass("InputError");
			return false;
		}
		var bookPrice = $("#bookPrice").val();
		if (bookPrice == null || bookPrice == "") {
			$("#spBookPrice").text("Enter Book Price");
			$("#bookPrice").addClass("InputError");
			
			$("#spBookAuthor").text("");
			$("#bookAuthor").removeClass("InputError");
			return false;
		}

		var bookPublisher = $("#bookPublisher").val();
		if (bookPublisher == null || bookPublisher == "select") {
			$("#spBookPublisher").text("Enter Publisher Name");
			$("#bookPublisher").addClass("InputError");
			
			$("#spBookPrice").text("");
			$("#bookPrice").removeClass("InputError");
			return false;
		}

		var bookQuantity = $("#bookQuantity").val();
		if (bookQuantity == null || bookQuantity == "") {
			$("#spBookQuantity").text("Enter Book Quantity");
			$("#bookQuantity").addClass("InputError");
			
			$("#spBookPublisher").text("");
			$("#bookPublisher").removeClass("InputError");
			return false;
		}
		var bookCategory = $("#bookCategory").val();
		if (bookCategory == null || bookCategory == "") {
			$("#spBookCategory").text("Enter Book Category");
			$("#bookCategory").addClass("InputError");
			
			$("#spBookQuantity").text("");
			$("#bookQuantity").removeClass("InputError");
			return false;
		}
		var bookDesc = $("#bookDesc").val();
		if (bookDesc == null || bookDesc == "") {
			$("#spBookDesc").text("Enter Book Desc");
			$("#bookDesc").addClass("InputError");
			
			$("#spBookCategory").text("");
			$("#bookCategory").removeClass("InputError"); 
			return false;
		}



	});
});