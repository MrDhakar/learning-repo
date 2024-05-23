package designpattern.adaptor;

public class AdapterPen implements Pen {
	
	private IPilotPen pilotPen = new PilotPen() ;
	
	public IPilotPen getPilotPen() {
		return pilotPen;
	}

	public void setPilotPen(IPilotPen pilotPen) {
		this.pilotPen = pilotPen;
	}

	@Override
	public void write(String str) {
		
		pilotPen.mark(str);
	}

}
