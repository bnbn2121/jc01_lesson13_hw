package com.esu.less13.homework;

public class Main {

	public static void main(String[] args) {
		BookShop bookShop = new BookShop("Книги", null, null, 0);
		// Book(String title, String author, String publisher, int yearOfPublish, int numberOfPages, String coverType)
		bookShop.regBook(new Book("Маленький Принц", "Экзюпери", "Издательство 1", 1943, 50, "твердый"), 100);
		bookShop.regBook(new Book("Средний Принц", "неизвестный автор", "Издательство 2", 2000, 60, "твердый"), 10);
		bookShop.regBook(new Book("Большой Принц", "неизвестный автор", null, 2001, 61, "мягкий"), 10);
		bookShop.regBook(new Book("Огромный Принц", "неизвестный автор", "Издательство 3", 2010, 0, "твердый"), 18);
		System.out.println();

		System.out.println("*пробуем вывести весь список книг в наличии:\n");
		bookShop.printReadyForSale();

		System.out.println("*пробуем вывести список книг по нескольким фильтрам:\n");
		// generalFilter(String title, String author, String publisher, int startYear, int finishYear, String coverType)
		bookShop.generalFilter(null, "Экзюпери", null, 0, 0, "мягкий");
		System.out.println();

		bookShop.generalFilter("принц", null, null, 1950, 2005, null);
		System.out.println();

		System.out.println("*пробуем продать книгу по id = 2:");
		bookShop.sellBook(2);
		System.out.println();

		System.out.println("*пробуем посмотреть список книг оставшихся в наличии:\n");
		bookShop.printReadyForSale();

		System.out.println("*пробуем посмотреть список проданных книг:\n");
		bookShop.printSoldBooks();
	}

}
