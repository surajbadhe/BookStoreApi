package com.suraj.bs.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.suraj.bs.book.entity.Book;

public class ReadJsonFromFile {
	public static void main(String args[]) {
		
	}
	
	public static List<Book> getBookDetailsFromJson(){
		List<Book> bookList=new ArrayList<Book>();
		JSONParser parser = new JSONParser();
        JSONArray jsonArray;
		try {
			jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/books.json"));
			 for (Object o : jsonArray) {
				    
		            JSONObject person = (JSONObject) o;
		            String strName = (String) person.get("bname");
		            String strAuthor = (String) person.get("bauthor");
		            Long strQuantity = (Long)person.get("quantity");
		            Long strPrice = (Long) person.get("bprice");
		            String strDesc = (String) person.get("description");
		            
		            
		        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		return bookList;
	}
}
