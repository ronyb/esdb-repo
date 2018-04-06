var skills;

$(function() {
	
	console.log('Hello from "Skills" JS Module');
	getAllSkills();
	
	$('#add_skill_form').submit(function() {
		event.preventDefault();
		postSkillToServer();
	});
	
	$('#add_skill_btn').click(addSkill);
})

function getAllSkills() {
	
	$.ajax({
        url: '/api/skills',
        type: 'GET',
        contentType: 'application/json',
        success: function(data, textStatus, jqXHR)
	    {
        	$.each(data, function() {
        	    
        		var simpleName = this.skillName.toLowerCase().replace('#', 'sharp');
        		
        		$('#skills_table > tbody').append(
        	        '<tr>' + 
        	        '<td><img src=\"skill-logos/' + simpleName + '.png\" title=\"' + simpleName + '\"></td>' +
        	        '<td>' + this.skillName + '</td>' +
        	        '<td>' + this.category + '</td>' +
        	        '<td>' + this.subcategory + '</td>' +
        	        '<td>' + this.topqRelevance + '</td>' +
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

function addSkill() {
	
	$('#add_skill_modal').css("display", "block");
	
	$('.close').click(function() {
		$('#add_skill_modal').css("display", "none");
	});
	
	$("#add_skill_modal").click(function(e) {
		if (e.target.getAttribute("id") === "add_skill_modal" ) {
			$('#add_skill_modal').css("display", "none");
		}
	});
}

function postSkillToServer() {
	
	var arr = $('#add_skill_form').serializeArray();
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