package com.example.speccourselab3;

public class BookFactory {
	public static IBooksProvider CreateBooksProvider(String booksProviderName) throws Exception {
		if (booksProviderName == "Simple") {
			return new SimpleBooksProvider();
		} else  {
			throw new Exception("Bad provider name!");
		}
	}
}
