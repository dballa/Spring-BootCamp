package com.book.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.book.dto.QuoteDto;



@Service
public class QuotesService {

	@Value("${quotes.api}")
	private String url;
	
	@Autowired
	RestTemplate restTemplate;

	public QuoteDto getRandomQuote() {
		String response =  restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
		JSONObject jsonResponse = new JSONObject(response);
		System.out.println("response nga api -> " + jsonResponse);
		
		JSONArray array = jsonResponse.getJSONArray("quotes");
		System.out.println("extract i arrayt nga fusha quotes -> " + array);
		JSONObject firstArrayObject = array.getJSONObject(0);
		System.out.println("elementi me index 0 i array -> " + firstArrayObject);
		
		QuoteDto quoteDto = new QuoteDto();
		
		quoteDto.setAuthor(firstArrayObject.getString("author"));
		quoteDto.setQuote(firstArrayObject.getString("quote"));
		quoteDto.setLanguage(firstArrayObject.getString("lang"));
		
		return quoteDto;
	}
}
