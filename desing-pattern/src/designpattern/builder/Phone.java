package designpattern.builder;

public class Phone {
	
	private String os;
	private String processor;
	private int ram;

	public Phone(String os, String processor, int ram) {
		super();
		this.os = os;
		this.processor = processor;
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Phone [os=" + os + ", processor=" + processor + ", ram=" + ram + "]";
	}
	
}
