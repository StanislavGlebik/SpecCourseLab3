package com.example.speccourselab3;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.os.Bundle;
import android.app.ListActivity;
import android.gesture.Gesture;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class BooksListActivity extends ListActivity {
	
	private IBooksProvider booksProvider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_books);
		try {
			booksProvider = BookFactory.CreateBooksProvider(getString(R.string.books_provider));
		} catch (Exception e) {
			// TODO: normal exception handling
		}
		
		JSONArray booksList = booksProvider.getBooksList();
		
		ArrayList<String> booksArray = new ArrayList<String>();
		for (int i = 0; i < booksList.length(); ++i) {
			try {
				booksArray.add(booksList.getJSONObject(i).getString(getString(R.string.book_title)));
			} catch (JSONException e) {
				// TROLOLO - add normal exception handling
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, booksArray));
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.books, menu);
		return true;
	}

}
