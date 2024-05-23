package designpattern.builder.prototype;

public class Prototype {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		BookShop shop = new BookShop();
		shop.setShopName("A");
		shop.loadData();
		
		
		BookShop shop2 = shop.clone();
		shop2.setShopName("B");
		shop.getBookList().remove(2);
		
		System.out.println(shop);
		System.out.println(shop2);
	}

}
