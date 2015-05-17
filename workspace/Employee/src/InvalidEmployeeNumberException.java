public class InvalidEmployeeNumberException extends RuntimeException
{
	public InvalidEmployeeNumberException(String message)
	{
		super(message);
	}
	public InvalidEmployeeNumberException()
	{
		super("Employee Number has to be 9 characters long");
	}
}
