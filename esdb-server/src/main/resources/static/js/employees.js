var employees;
var selected_id;
$(function() {
	
	console.log('Hello from "Employees" JS Module');
	getAllEmployees();
	
	$('#add_employee_form').submit(function() {
		event.preventDefault();
		postEmployeeToServer();
	});

	$('#update_employee_form').submit(function() {
    		event.preventDefault();
    		putEmployee();
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
        	        '<td><button class="edit" data-id="'+ this.id+ '">Edit</button></td>' +
        	        '<td name="matrixId">' + this.matrixId + '</td>' +
        	        '<td name="firstNameHe">' + this.firstNameHe + '</td>' +
        	        '<td name="firstNameEn">' + this.firstNameEn + '</td>' +
        	        '<td name="lastNameHe">' + this.lastNameHe + '</td>' +
        	        '<td name="lastNameEn">' + this.lastNameEn + '</td>' +
        	        '<td name="phone">' + this.phone + '</td>' +
        	        '<td name="email">' + this.email1 + '</td>' +
//        	        '<td style="display:none;">' + this.id + '</td>'
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


$(document).on('click', '.edit', function(event){
   selected_id = $(this).attr('data-id');
   children = $(this).closest('td').siblings()
   console.log(children)
   $('#update_employee_modal').css("display", "block");

   $('.close').click(function() {
        $('#update_employee_modal').css("display", "none");
   });

   $("#MatrixIdUpdate").val(children[0].innerHTML);

   $("#FirstNameHeUpdate").val(children[1].innerHTML);

   $("#FirstNameEngUpdate").val(children[2].innerHTML);

   $("#LastNameHeUpdate").val(children[3].innerHTML);

   $("#LastNameEngUpdate").val(children[4].innerHTML);

   $("#PhoneUpdate").val(children[5].innerHTML);

   $("#EmailUpdate").val(children[6].innerHTML);

   $("#update_employee_modal").click(function(e) {
        if (e.target.getAttribute("id") === "update_employee_modal" ) {
            $('#update_employee_modal').css("display", "none");
        }
   });

 //code - you need to do
})

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
		url : 'api/employee',
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


function editEmployee(d) {
    	$('#update_employee_modal').css("display", "block");

    	$('.close').click(function() {
    		$('#update_employee_modal').css("display", "none");
    	});


         $("#MatrixIdUpdate").text(d.matrixId);

         $("#FirstNameHeUpdate").text(d.firstNameHe);

         $("#FirstNameEngUpdate").text(d.firstNameEn);

         $("#LastNameHeUpdate").text(d.lastNameHe);

         $("#LastNameEngUpdate").text(d.lastNameEn);

         $("#PhoneUpdate").text(d.phone);

         $("#EmailUpdate").text(d.email1);


    	$("#update_employee_modal").click(function(e) {
    		if (e.target.getAttribute("id") === "update_employee_modal" ) {
    			$('#update_employee_modal').css("display", "none");
    		}
    	});
}

function putEmployee() {
	var arr = $('#update_employee_form').serializeArray();
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
    		url : 'api/employee/'+selected_id,
    		type : 'PUT',
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