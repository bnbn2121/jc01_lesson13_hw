package com.esu.less13.homework;

/*
 * Создать класс Book, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */
public class Book {
	private int id;
	private String title;
	private String author;
	private String publisher;
	private int yearOfPublish;
	private int numberOfPages;
	private int price;
	private String coverType;

	private final String ND = "нет данных";

	public Book() {
		
	}

	public Book(String title, String author, String publisher, int yearOfPublish, int numberOfPages, String coverType) {
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setYearOfPublish(yearOfPublish);
		setNumberOfPages(numberOfPages);
		setСoverType(coverType);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id > 0) {
			this.id = id;
		} else {
			this.id = 0;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null) {
			this.title = title;
			return;
		}
		this.title = ND;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (author != null) {
			this.author = author;
			return;
		}
		this.author = ND;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if (publisher != null) {
			this.publisher = publisher;
			return;
		}
		this.publisher = ND;
	}

	public int getYearOfPublish() {
		return yearOfPublish;
	}

	public void setYearOfPublish(int yearOfPublish) {
		if (yearOfPublish > 0) {
			this.yearOfPublish = yearOfPublish;
		} else {
			this.yearOfPublish = 0;
		}
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		if (numberOfPages > 0) {
			this.numberOfPages = numberOfPages;
		} else {
			this.numberOfPages = 0;
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price > 0) {
			this.price = price;
		} else {
			this.price = 0;
		}
	}

	public String getСoverType() {
		return coverType;
	}

	public void setСoverType(String coverType) {
		if (coverType != null) {
			if (coverType.equalsIgnoreCase("твердый") || coverType.equalsIgnoreCase("мягкий")) {
				this.coverType = coverType.toLowerCase();
				return;
			}
		}
		this.coverType = ND;
	}

	@Override
	public String toString() {
		return String.format("Инвентарный номер: %d%n"
		+ "Название: %s%n"
		+ "Автор: %s%n" 
		+ "Издательство: %s%n"
		+ "Год издания: %d%n"
		+ "Количество страниц: %d%n"
		+ "Цена: %d%n"
		+ "Тип переплета: %s%n", 
		id, title, author, publisher, yearOfPublish, numberOfPages, price, coverType);
	}

}
