var skills;

$(function() {
	
	console.log('Hello from "Employees" JS Module');
	getAllEmployees();
	
	$('#add_employee_form').submit(function() {
		event.preventDefault();
		postSkillToServer();
	});
	
	$('#add_employee_btn').click(addEmployee);
})

function getAllEmployees() {
	
	$.ajax({
        url: '/api/employees',
        type: 'GET',
        contentType: 'application/json',
        success: function(data, textStatus, jqXHR)
	    {
        	$.each(data, function() {
        	    
        		$('#employees_table > tbody').append(
        	        '<tr>' + 
        	        '<td><button onClick="editEmployee(' + this.id + ')">Edit</button></td>' +
        	        '<td>' + this.matrixId + '</td>' +
        	        '<td>' + this.firstNameHe + '</td>' +
        	        '<td>' + this.firstNameEn + '</td>' +
        	        '<td>' + this.lastNameHe + '</td>' +
        	        '<td>' + this.lastNameEn + '</td>' +
        	        '<td>' + this.phone + '</td>' +
        	        '<td>' + this.email1 + '</td>' +
        	        '</tr>' 
        	    );
        	});
	    },
	    error: function (jqXHR, textStatus, errorThrown)
	    {
	    	console.log(jqXHR);
	    	console.log(textStatus);
	    	console.log(errorThrown);
	    }
    });
}

function addEmployee() {
	
	$('#add_employee_modal').css("display", "block");
	
	$('.close').click(function() {
		$('#add_employee_modal').css("display", "none");
	});
	
	$("#add_employee_modal").click(function(e) {
		if (e.target.getAttribute("id") === "add_employee_modal" ) {
			$('#add_employee_modal').css("display", "none");
		}
	});
}

function postEmployeeToServer() {
	
	var arr = $('#add_employee_form').serializeArray();
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
	
	$.ajax({
		url : 'api/skill',
		type : 'POST',
		data: jsonStr,
		contentType: "application/json"
	})
	.done(function(text) {
		location.reload();
	})
	.fail(function() {
		alert("Error adding skill");
		location.reload();							
	});
}

function editEmployee(id) {
	alert(id);
}