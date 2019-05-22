package entities.excecptions;

public class LastNameException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public LastNameException(String msg){
		super(msg);
	}
}
