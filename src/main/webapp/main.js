
$(document).ready(function() {
	$.support.cors = true;
	function testInput(event) {
		   var value = String.fromCharCode(event.which);
		   var pattern = new RegExp(/[a-zåäö ]/i);
		   return pattern.test(value);
		}

		$('#input_term').bind('keypress', testInput);
	$('#getbutton').on('click', function(e) {
		$('#definition').text('');
		$temp = $.trim($('#input_term').val())
		if($.trim($('#input_term').val())=='')
			{
			alert("please enter a valid term");
			return;
			}
		e.preventDefault();
		$.ajax({
			type : 'POST',
			url : "http://localhost:8080/myRobot/webapi/dictionary/getTermDefinition",
			crossDomain : true,
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify({
				term : $temp
			}),
			success : function(data) {
				$('#definition').text($('#input_term').val()+"---"+data.term_definition);
			    
				
			},
			error : function(data) {
				alert("Server is not responding");
			}
		});
	});
});

