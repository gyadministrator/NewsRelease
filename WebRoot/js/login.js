
function login() {
		$("#loginBtn").click(function() {
			$('#modal').css('display', 'block');
			$('.modal-bg').fadeIn();
		});
		$('#close').click(function() {
			$('.modal-bg').fadeOut();
			$('#modal').fadeOut();
			return false;
		});
	}
	
	function reg() {
		$("#regBtn").click(function() {
			$('#modal1').css('display', 'block');
			$('.modal-bg1').fadeIn();
		});
		$('#close1').click(function() {
			$('.modal-bg1').fadeOut();
			$('#modal1').fadeOut();
			return false;
		});
	}
	
	
	