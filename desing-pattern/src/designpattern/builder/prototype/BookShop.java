package designpattern.builder.prototype;

import java.util.ArrayList;

public class BookShop implements Cloneable{
	private String shopName;
	ArrayList<Book> bookList = new ArrayList<>();
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
	public void loadData() {
		BookShop shop = new BookShop();
		for (int i=0;i<10;i++) {
			Book book = new Book();
			book.setId(i);
			book.setBookname("book"+i);
			bookList.add(book);
		}
	}
	@Override
	public String toString() {
		return "BookShop [shopName=" + shopName + ", bookList=" + bookList + "]";
	}
	

	@Override
	protected BookShop clone() throws CloneNotSupportedException {
		BookShop shop = new BookShop();
		
		for(Book book :this.getBookList() ) {
			shop.getBookList().add(book);
		}
		return shop;
	}

}
