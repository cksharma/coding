function checkForEmptyValue(text, labelId)
{
	if(text.value.length == 0)
	{
		var msg = "<font color = 'red'> should not be empty </font>";
		document.getElementById(labelId).innerHTML = msg;
		return false;
	}
	return true;
}

function formReset()
{
	document.getElementById("form1").reset();
}