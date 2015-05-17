public class InvalidEmailIdException extends RuntimeException
{
	public InvalidEmailIdException(String message)
	{
		super(message);
	}
	public InvalidEmailIdException()
	{
		super("Not a valid email id. Email Id has to be name@domainname e.g. example@gmail.com");
	}
}
