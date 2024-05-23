package designpattern.factory;

public class AndroidCompany extends Factory{


	@Override
	public OS getInstances() {
		// TODO Auto-generated method stub
		return new Android();
	}
	
}
