package com.example.speccourselab3;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.JsonReader;

public class SimpleBooksProvider implements IBooksProvider {

	@Override
	public JSONArray getBooksList() {
		JSONArray array = null;
		try {
			array = new JSONArray("[{'BookTitle': 'NightWatch'}]");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return array;
	}

}
