<html>

<head>
	<style>
		body {
			text-align: center;
		}

		label {
			display: inline-block;
			width: 150px;
			text-align: left;
		}

		#tableResult {
			border: 1px solid black;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
	<script src="js/jquery-2.1.1.min.js"></script>
</head>

<body>
	<form>
		<h1>Trip search</h1>
		<label for="departureDate">Departure date</label><input type="text" id="departureDate" />
		<br />
		<label for="returnDate">Return date</label><input type="text" id="returnDate" />
		<br />
		<label for="originCity">Origin city</label><input type="text" id="originCity" />
		<br />
		<label for="destinyCity">Destiny city</label><input type="text" id="destinyCity" />
		<br /><br />
		<input type="button" id="searchTrip" value="Search" />
	</form>
	<div>
		<table id="tableResult" style="display:none;">
			<thead>
				<tr>
					<th>Options</th>
					<th>Departure date</th>
					<th>Return date</th>
					<th>Origin city</th>
					<th>Destiny city</th>
				</tr>
			</thead>
			<tbody id="tableResultBody">
			</tbody>
		</table>
		<span id="notFoundMessage" style="display:none;">No trips found</span>
		<br />
		<a href="http://localhost/viewCart">View cart</a>
	</div>
</body>

<script>
	$("#searchTrip").click(function () {
		$.getJSON("http://localhost/Trip"
			+ "?departureDate=" + $("#departureDate").val()
			+ "&returnDate=" + $("#returnDate").val()
			+ "&originCity=" + $("#originCity").val()
			+ "&destinyCity=" + $("#destinyCity").val())
			.success(function (data) {
				if (data.length > 0) {
					var tbody = "";
					$.each(data, function (index, trip) {
						tbody += "<tr>"
							+ "<td><input type='button' value='Add to cart' class='addToCart' />"
							+ "<input type='hidden' value='" + trip.id + "' class='tripId'/></td>"
							+ "<td>" + trip.departureDate + "</td>"
							+ "<td>" + trip.returnDate + "</td>"
							+ "<td>" + trip.originCity + "</td>"
							+ "<td>" + trip.destinyCity + "</td></tr>";
					});
					$("#tableResultBody").html(tbody);
					$("#tableResult").show();
					$("#notFoundMessage").hide();
				}
				else {
					$("#notFoundMessage").show();
					$("#tableResult").hide();
				}
			})
			.fail(function () {
				alert("Failed to search trips");
			});
	});
	$("body").on("click", "input.addToCart", function () {
		var button = $(this);
		$.ajax({
			type: "PUT",
			url: "http://localhost/Cart",
			data: $(this).parent().find(".tripId").val(),
			contentType: "application/json"
		}).success(function () {
			button.hide();
		}).fail(function () {
			alert("Failed to add item to cart");
		});
	});
</script>

</html>