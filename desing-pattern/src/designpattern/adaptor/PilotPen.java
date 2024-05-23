package designpattern.adaptor;

public class PilotPen implements IPilotPen{

	@Override
	public void mark(String str) {
		System.out.println(str);
		
	}

}
