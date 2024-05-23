package designpattern.builder;

public class PhoneBuilder {
		
	private String os;
	private String processor;
	private int ram;
	
	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}
	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}
	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}
	
	Phone getPhone() {
		return new Phone(os, processor, ram);
		
	}
	
}
