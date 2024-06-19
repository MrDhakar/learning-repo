package algo.java;

public class Codingpractive extends Thread{
     static Task task;
    private static String msg;
    
	public static void main(String[] args) {
		
			task = new Task();
			msg="hi";
			Codingpractive thread1 = new Codingpractive();
		thread1.start();
		msg="hello";
		Codingpractive thread2 = new Codingpractive();
		thread2.start();
	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized (this) {
			task.write(msg);
		}
		
	}
	
	
	

}

class Sender {
    public void send(String msg)
    {
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}


class Task{
	
	
	void read(String msg) {
		System.out.println("reading\t" + msg);
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "reading");
		
	}
	
	 void write(String msg) {
		 System.out.println("writing\t" + msg);
     try {
         Thread.sleep(1000);
     }
     catch (Exception e) {
         System.out.println("Thread  interrupted.");
     }
     System.out.println("\n" + msg + "writing");
		
	}
}
