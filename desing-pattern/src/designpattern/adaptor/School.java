package designpattern.adaptor;

public class School {

	public static void main(String[] args) {
		
		AssignmentWork aw = new AssignmentWork();
		Pen pen = new AdapterPen();
		aw.setPen(pen);
		aw.writeAssignment("I am Jai, My assignment done.");
	}
}
