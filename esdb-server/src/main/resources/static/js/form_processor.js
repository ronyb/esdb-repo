$(function() {
	
	console.log('Hello from "Form Processor" JS Module');
	
	// convert form to JSON and send as Ajax HTTP POST request
	$('#add_skill_form').submit(function(event) {

		event.preventDefault();
		
		var arr = $(this).serializeArray();
		
		var obj = {};
		
		$(arr).each(function () {
			
			if (this.name == 'topqRelevance') {
				obj[this.name] = parseInt(this.value);
			}
			else {
				obj[this.name] = this.value;
			}
		});
		
		
		var jsonStr = JSON.stringify(obj);
		
		console.log(jsonStr);
		
		$.ajax({
	        url: $(this).attr('action'),
	        type: $(this).attr('method'),
	        contentType: 'application/json',
	        data: jsonStr,
	        success: function(data, textStatus, jqXHR)
		    {
	        	$('#result_div').html('Success');
		    },
		    error: function (jqXHR, textStatus, errorThrown)
		    {
		    	$('#result_div').html('<span style="color: red;">ERROR</span>');
		    	console.log(jqXHR);
		    	console.log(textStatus);
		    	console.log(errorThrown);
		    }
	    });
	});
})