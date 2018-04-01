$(function() {
	
	console.log('Hello from "UI Controller" JS Module');
	
	/***** STEPS ****/

	// add step
	$('.add_step_btn').click(function() {
		$('#job_steps').append('<fieldset class="step_fieldset"> <legend>Job Step</legend> <div class="fieldset_controller"> <button type="button" class="delete_x" title="Delete Step">X</button> <button type="button" class="arrow_up" title="Move Step Up">&#9650;</button> <button type="button" class="arrow_down" title="Move Step Down">&#9660;</button> </div> <p><label class="large_label" for="step_type">Step Type:</label> <select name="step_type" id="step_type" class="large_input"> <option value="1">Step Type 1</option> <option value="2">Step Type 2</option> <option value="3">Step Type 3</option> <option value="4">Step Type 4</option> </select> </p> <fieldset class="params_fieldset"> <legend>Step Prams</legend> <p> <label class="small_label">Name:</label><input type="text" name="name" class="small_input"> <label class="small_label">Value:</label><input type="text" name="value" class="small_input"> <label class="small_label">Value Type:</label> <select name="value_type" class="small_input"> <option value="string">String</option> <option value="int">Int</option> <option value="float">Float</option> <option value="boolean">Boolean</option> </select> <button type="button" class="param_remove_btn" title="Remove Param">X</button> </p> </fieldset> <br /> <button type="button" class="add_param_btn">+ Add Param</button> </fieldset>');
	});
	
	// delete step
	$('#job_steps').on('click', '.delete_x', function() {
		$(this).parent().parent().remove();
	});
	
	// move step up
	$('#job_steps').on('click', '.arrow_up', function() {
		var stepToMove = $(this).parent().parent();
		var stepToMoveIndex = $('.step_fieldset').index(stepToMove);
		if (stepToMoveIndex > 0) {
			var stepBefore = $('.step_fieldset:nth-child(' + stepToMoveIndex + ')'); // Because jQuery's implementation of :nth- selectors is strictly derived from the CSS specification, the value of n is "1-indexed", meaning that the counting starts at 1
			$(stepToMove).insertBefore(stepBefore);
		}
	});
	
	// move step down
	$('#job_steps').on('click', '.arrow_down', function() {
		var stepToMove = $(this).parent().parent();
		var stepToMoveIndex = $('.step_fieldset').index(stepToMove);
		
		if ((stepToMoveIndex+1) < $('.step_fieldset').length) {
			var stepAfter = $('.step_fieldset:nth-child(' + (stepToMoveIndex+2) + ')'); // Because jQuery's implementation of :nth- selectors is strictly derived from the CSS specification, the value of n is "1-indexed", meaning that the counting starts at 1
			$(stepToMove).insertAfter(stepAfter);
		}
	});

	
	/***** PARAMS *****/
	
	// add param
	$('#job_steps').on('click', '.add_param_btn', function() {
		
		$(this).parent().find('.params_fieldset').append('<p> <label class="small_label">Name:</label><input type="text" name="name" class="small_input"> <label class="small_label">Value:</label><input type="text" name="value" class="small_input"> <label class="small_label">Value Type:</label> <select name="value_type" class="small_input"> <option value="string">String</option> <option value="int">Int</option> <option value="float">Float</option> <option value="boolean">Boolean</option> </select> <button type="button" class="param_remove_btn" title="Remove Param">X</button> </p>');
		
	});
	
	// delete param
	$('#job_steps').on('click', '.param_remove_btn', function() {
		$(this).parent().remove();
	});
	
});