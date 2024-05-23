package designpattern.factory;

public abstract class Factory {
	public OS getSpec() {
		OS os= getInstances();
		os.spec();
		return os;
		
	}
	public abstract OS getInstances() ;
}
