$(document).ready(function(e) {
		$("#email").blur(function(event) {
			$("#dupEmail").html("");
			$("#uniqueEmail").html("");
			var emailId = $("#email").val();
			$.ajax({
				url : 'validateEmail?email=' + emailId,
				success : function(abc) {
					if (abc == 'duplicate') {
						$("#dupEmail").html("Email already registered");
						$("#email").focus();
					}
					else{
						$("#uniqueEmail").html("This email id allowed..!!");
						}
				}
			});
		});
		
		
		$("#country").change(function() {
			
			$("#state").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#state");
			
			$("#city").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#city");
			
			var countryId = $("#country").val();
			$.ajax({
				type : "GET",
				url : "getStates?cid=" + countryId,
				success : function(res) {
					$.each(res, function(stateId, stateName) {
						$('<option>').val(stateId).text(stateName).appendTo("#state");
					});
				}
			});
		});
		
		
		
		$("#state").change(function() {
			
			$("#city").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#city");
			
			var stateId = $("#state").val();
			$.ajax({
				type : "GET",
				url : "getCities?sid=" + stateId,
				success : function(data) {
					$.each(data, function(cityId, cityName) {
						$('<option>').val(cityId).text(cityName).appendTo("#city");
					});
				}
			});
		});
		
		
		
		
		
		
		
		
	});