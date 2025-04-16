package com.esu.less13.homework;

import java.util.ArrayList;
import java.util.List;

public class BookShop {
	private String title;
	private List<Book> readyForSale = new ArrayList<>();
	private List<Book> soldBooks = new ArrayList<>();
	private List<Book> filteredBook = new ArrayList<>();
	private int countId;

	public BookShop() {
		title = "Книжный магазин";
	}

	public BookShop(String title, List<Book> readyForSale, List<Book> soldBooks, int countId) {
		setTitle(title);
		if (readyForSale != null) {
			this.readyForSale = readyForSale;
		}
		if (soldBooks != null) {
			this.soldBooks = soldBooks;
		}
		if (countId > 0) {
			this.countId = countId;
		}
	}

	public void setTitle(String title) {
		if (title != null) {
			this.title = title;
		} else {
			this.title = "Книжный магазин";
		}
	}

	public String getTitle() {
		return title;
	}

	public void setReadyForSale(List<Book> readyForSale) {
		this.readyForSale = readyForSale;
	}

	public List<Book> getReadyForSale() {
		return readyForSale;
	}

	public void setSoldBooks(List<Book> soldBooks) {
		this.soldBooks = soldBooks;
	}

	public List<Book> getSoldBooks() {
		return soldBooks;
	}

	public void setCountId(int countId) {
		this.countId = countId;
	}

	public int getCountId() {
		return countId;
	}
	
	//регистрация книги в магазине, присваивание цены и id
	public void regBook(Book book, int price) {
		book.setId(++countId);
		book.setPrice(price);
		readyForSale.add(book);
		System.out.printf("книга \"%s\" поступила в продажу\n", book.getTitle());
	}

	//продажа книги
	public void sellBook(int id) {
		for (int i = 0; i < readyForSale.size(); i++) {
			if (id == readyForSale.get(i).getId()) {
				soldBooks.add(readyForSale.get(i));
				System.out.printf("книга \"%s\" продана\n", readyForSale.get(i).getTitle());
				readyForSale.remove(i);
			}
		}
	}
	
	//метод для реализации фильтра
	private boolean filterByTitle(Book book, String title) {
		if (title == null) {
			return true;
		}
		if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	//метод для реализации фильтра
	private boolean filterByAuthor(Book book, String author) {
		if (author == null) {
			return true;
		}
		if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
			return true;
		}
		return false;
	}

	//метод для реализации фильтра
	private boolean filterFromYear(Book book, int year) {
		if (year == 0) {
			return true;
		}
		if (book.getYearOfPublish() >= year) {
			return true;
		}
		return false;
	}

	//метод для реализации фильтра
	private boolean filterBeforeYear(Book book, int year) {
		if (year == 0) {
			return true;
		}
		if (book.getYearOfPublish() <= year) {
			return true;
		}
		return false;
	}

	//метод для реализации фильтра
	private boolean filterByCoverType(Book book, String coverType) {
		if (coverType == null || (!coverType.equalsIgnoreCase("твердый") && !coverType.equalsIgnoreCase("мягкий"))) {
			return true;
		}
		if (book.getСoverType().equals(coverType)) {
			return true;
		}
		return false;
	}
	
	//сам фильтр
	public void generalFilter(String title, String author, String publisher, int startYear, int finishYear, String coverType) {
		for (Book book : readyForSale) {
			if (filterByTitle(book, title)
					&& filterByAuthor(book, author)
					&& filterFromYear(book, startYear)
					&& filterBeforeYear(book, finishYear)
					&& filterByCoverType(book, coverType)
					) {
				filteredBook.add(book);
			}
		}

		System.out.println("Критерии выбора:");
		if (title != null) {
			System.out.println("Название: " + title);
		}
		if (author != null) {
			System.out.println("Автор: " + author);
		}
		if (publisher != null) {
			System.out.println("Издатель: " + publisher);
		}
		if (startYear != 0) {
			System.out.println("Год издания с: " + startYear);
		}
		if (finishYear != 0) {
			System.out.println("Год издания по: " + finishYear);
		}
		if (coverType != null && (coverType.equalsIgnoreCase("твердый") || coverType.equalsIgnoreCase("мягкий"))) {
			System.out.println("Тип обложки: " + coverType);
		}
		System.out.println();
		
		if (filteredBook.size() > 0) {
			System.out.println("Список книг по данным критериям:");
			for (int i = 0; i < filteredBook.size(); i++) {
				System.out.println("---------" + (i + 1) + "---------");
				System.out.println(filteredBook.get(i));
			}
			filteredBook.clear();
		} else {
			System.out.println("по данным параметрам книг не найдено");
		}

	}
	
	//печать списка книг в наличии
	public void printReadyForSale() {
		System.out.println("Список книг для продажи:");
		for (int i = 0; i < readyForSale.size(); i++) {
			System.out.println("---------" + (i + 1) + "---------");
			System.out.println(readyForSale.get(i));
		}
	}
	
	//печать списка проданных книг
	public void printSoldBooks() {
		System.out.println("Список проданных книг:");
		for (int i = 0; i < soldBooks.size(); i++) {
			System.out.println("---------" + (i + 1) + "---------");
			System.out.println(soldBooks.get(i));
		}
	}

}
