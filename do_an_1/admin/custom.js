$( document ).ready(function() {
	$('.choose-color input[type=color]').on('change', function() {
		$('.choose-color input[type=text]').val($(this).val());
	})
});