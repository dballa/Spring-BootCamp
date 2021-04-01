package com.rest.demo.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.demo.dto.WeatherDto;

@Service
public class WeatherService {
	@Value("${myKeyValue}")
	private String key;

	@Value("${apiUrl}")
	private String url;
	
	private String unit = "metric";
	
	@Autowired
	RestTemplate restTemp;

	public WeatherDto getWeatherByCity(String city) {
		String rawJson =  restTemp.exchange(url+city+"&appid="+key+"&units="+unit, HttpMethod.GET, null, String.class).getBody();
		JSONObject root = new JSONObject(rawJson);
		JSONArray weather = root.getJSONArray("weather");

		JSONObject mainJson = root.getJSONObject("main");
		JSONObject windJson = root.getJSONObject("wind");
		JSONObject sysJson = root.getJSONObject("sys");
		JSONObject weatherJson = weather.getJSONObject(0);
		WeatherDto weatherDto = new WeatherDto();
		
		String description = weatherJson.getString("description");
		int tempMin = mainJson.getInt("temp_min");
		int tempMax = mainJson.getInt("temp_max");
		int windSpeed = windJson.getInt("speed");
		String country = sysJson.getString("country");
		
		weatherDto.setDescription(description);
		weatherDto.setTempMin(tempMin);
		weatherDto.setTempMax(tempMax);
		weatherDto.setWindSpeed(windSpeed);
		weatherDto.setCountry(country);
		
		return weatherDto;
	}

}
