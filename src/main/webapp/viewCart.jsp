<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<html>

	<head>
		<style>
			body {
				text-align: center;
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
		<h1>Cart</h1>
		<c:if test="${not empty trips}">
			<table id="tableResult">
				<thead>
					<tr>
						<th>Options</th>
						<th>Departure date</th>
						<th>Return date</th>
						<th>Origin city</th>
						<th>Destiny city</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${trips}" var="trip">
						<tr>
							<td>
								<input type='button' value='Remove' class='removeItem' />
								<input type='hidden' value='${trip.id}' class='tripId' />
							</td>
							<td>${trip.departureDate}</td>
							<td>${trip.returnDate}</td>
							<td>${trip.originCity}</td>
							<td>${trip.destinyCity}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty trips}">
			<span>There are no items on you cart</span>
		</c:if>
		<br />
		<a href="http://localhost/findTrips">Trip search</a>
	</body>

	<script>
		$("input.removeItem").click(function () {
			$.ajax({
				type: "DELETE",
				url: "http://localhost/Cart",
				data: $(this).parent().find(".tripId").val(),
				contentType: "application/json"
			}).success(function () {
				window.location.href = "http://localhost/viewCart";
			}).fail(function () {
				alert("Failed to remove item from cart");
			});
		});
	</script>

	</html>