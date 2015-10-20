$( document ).ready(function() {
	$("#contactbutton").click(function() {
		$("#contactdiv").css("display", "block");
	});
	$("#contact #cancel").click(function() {
		$(this).parent().parent().hide();
	});
	$("#send").click(function() {
		var name = $("#name").val();
		var email = $("#email").val();
		var message = $("#message").val();
		if (name == "" || email == "" ||  message == ""){
			alert("Please Fill All Fields");
		}
		else
		{
			if (validateEmail(email)) {
				$("#contactdiv").css("display", "none");
				$("#contact").submit();
			}
			else
			{
				alert('Invalid Email Address');
			}
			function validateEmail(email) 
			{
				var filter = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
				if (filter.test(email)) 
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
	});
	$("#contact").submit(function(e)
	{
	    var postData = $(this).serializeArray();
	    var formURL = $(this).attr("action");
	    $.ajax(
	    {
	        url : formURL,
	        type: "POST",
	        data : postData,
	        success:function(data, textStatus, jqXHR) 
	        {
	            //data: return data from server
	            alert(data);
	        },
	        error: function(jqXHR, textStatus, errorThrown) 
	        {
	            //if fails      
	            alert("Internal Error: Unable to send data.");
	        }
	    });
	    e.preventDefault(); //STOP default action
	    e.unbind(); //unbind. to stop multiple form submit.
	});
});