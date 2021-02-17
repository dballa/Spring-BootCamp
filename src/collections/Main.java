package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {
//		listTest();
//		setTest();
//		mapTest();
//		testCheckedExceptions();
//		testUncheckedExceptions();
//		testRuntimeException();
	}

	public static void listTest() {
		List<Book> books = new ArrayList<>();
		Book kafka = new Book("Kafka", 300);
		books.add(kafka);
		books.add(kafka);
		books.add(new Book("Shpella e pirateve", 150));
		books.add(new Book("Kafka", 350));
		System.out.println(books.size());
		System.out.println();

		books.add(1, new Book("Gogoli", 600));
		books.remove(3);
		System.out.println(books.remove(new Book("Kafka", 300)));
		System.out.println(books.remove(kafka));
		printList(books);

		System.out.println();
		System.out.println(books.get(1));
		System.out.println();

		Book nicja = new Book("Kur qau Nicja", 400);
		books.set(1, nicja);
		System.out.println(books.lastIndexOf(new Book("Kur qau Nicja", 400)));
		System.out.println(books.lastIndexOf(nicja));

	}

	public static void setTest() {
		Set<Book> books = new HashSet<>();
		Book kafka = new Book("Kafka", 300);
		books.add(kafka);
		books.add(kafka);
		books.add(new Book("Shpella e pirateve", 150));
		books.add(new Book("Kafka", 350));
		System.out.println(books.size());
		System.out.println();

		System.out.println(books.remove(new Book("Kafka", 300)));
		System.out.println(books.remove(kafka));
		printSet(books);

		Book nicja = new Book("Kur qau Nicja", 400);
		books.add(nicja);
		System.out.println(books.contains(new Book("Kur qau Nicja", 400)));
		System.out.println(books.contains(nicja));
		printSet(books);
	}

	public static void mapTest() {
		Map<String, Book> books = new HashMap<>();
		Book kafka = new Book("Kafka", 300);
		Book nicja = new Book("Kur qau Nicja", 400);

		books.put("klevis", kafka);
		books.put("klevis", nicja);
		books.put("beni", kafka);
		books.putIfAbsent("beni", nicja);

		System.out.println(books.get("klevis"));
		System.out.println(books.get("beni"));

		Map<String, List<Book>> booksOfUser = new HashMap<>();
		booksOfUser.put("klevis", Arrays.asList(kafka, nicja));
		booksOfUser.putIfAbsent("beni", Arrays.asList(nicja));
		System.out.println(booksOfUser.get("klevis"));
		System.out.println(booksOfUser.get("beni"));
	}

	public static void printList(List<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public static void printSet(Set<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	public static void testCheckedExceptions() throws FileNotFoundException {
		File file = new File("C://");				
		InputStream io =  new FileInputStream(file);
	}
	
	public static int testUncheckedExceptions() {
		return 7/0;
	}
	
	public static void testRuntimeException() {
		String name = "test123+";
		if(name.length() < 10) {
			throw new BadRequestException(BadRequest.WRONG_NAME_SIZE.getErrorMessage());
		}
	}
}
