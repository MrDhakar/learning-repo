package designpattern.builder;

public class Shop {
  public static void main (String[] args) {
	  Phone phone = new PhoneBuilder().setOs("Iphone").setProcessor("17").getPhone();
	  System.out.println(phone);
  }
  
  
}
