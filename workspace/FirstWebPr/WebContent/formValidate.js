function checkId()
{
	var id = document.myform.pid.value;
	var msg;
	if(id.length == 0)
	{
		msg = "<font color = 'red'>Id should not be empty </font>";
		document.getElementById("msg").innerHTML = msg;
		return false;
	}
	else
	{
		var value = parseInt(id);
		if(value <= 0)
		{
			msg = "<font color = 'red'> Id should be greater than zero";
			document.getElementById("msg").innerHTML = msg;
			return false;
		}
		else
		{
			return true;
		}
	}
		
}

function checkForEmptyValue(text, labelId)
{
	//alert(value);
	//alert(label);
	if(text.value.length == 0)
	{
		var msg = "<font color = 'red'> should not be empty </font>";
		document.getElementById(labelId).innerHTML = msg;
		return false;
	}
	return true;
}