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
			msg = "<font color='red'>enter a non-string number</font>";
			document.getElementById(labelId).innerHTML = msg;
			validated = false;
		} 
		else 
		{
			if (parseInt(text.value) > 0) 
			{
				document.getElementById(labelId).innerHTML = "";
				valdated = true;
			} 
			else 
			{
				msg = "<font color='red'>enter a natural number</font>";
				document.getElementById(labelId).innerHTML = msg;
				validated = false;
			}
		}
	}
}

