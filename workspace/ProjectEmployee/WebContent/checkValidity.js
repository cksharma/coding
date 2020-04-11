function startTimer() 
{
		setInterval("sendRequest()", 1000);
}
	
var validated;
	
function checkForEmptyValue(text, labelId) 
{
	if (text.value.length == 0) {
		var msg = "<font color='red'>Should not be empty</font>";
		document.getElementById(labelId).innerHTML = msg;
		validated = false;
	} else 
	{
		document.getElementById(labelId).innerHTML = "";
			
	}
}
	
function resetValidated() 
{
	validated=true;

}
	
function valid() 
{
	return validated;
}
	
function formReset() 
{
	document.getElementById("form1").reset();
}
	
function checkForIntegerValue(text, labelId) 
{
	var msg;
	if (text.value.length == 0) 
	{
		msg = "<font color='red'>Should not be empty</font>";
		document.getElementById(labelId).innerHTML = msg;
		validated = false;
	} 
	else 
	{
		if (isNaN(text.value)) 
		{
			msg = "<font color='red'>It should have numeric value</font>";
			document.getElementById(labelId).innerHTML = msg;
			validated = false;
		} 
		else 
		{
			if (parseInt(text.value) > 0) 
			{
				document.getElementById(labelId).innerHTML = "";
					
			} 
			else 
			{
				msg = "<font color='red'>It's value cannot be negative</font>";
				document.getElementById(labelId).innerHTML = msg;
				validated = false;
			}
		}
	}
}