package entities.excecptions;

public class NameException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NameException(String msg){
		super(msg);
	}
}
