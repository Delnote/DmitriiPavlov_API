package service;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.FileUtils;

import static io.restassured.RestAssured.given;

public class SpellerService {
	FileUtils fileUtils = new FileUtils();
	private RequestSpecification REQUEST_SPECIFICATION;

	//todo speller.yandex.net почему в коде?
	// fixed
	public SpellerService() {
		fileUtils.readSpellerPropertiesFromFile();
		REQUEST_SPECIFICATION = new RequestSpecBuilder()
				.setBaseUri(fileUtils.getDomain())
				.addFilter(new RequestLoggingFilter())
				.addFilter(new ResponseLoggingFilter()).build();
	}

	//todo название не сильно подходящее. я его с функционало п перепутала. Это низкоуровневые действия, нужно акцент сделать, что это иименно вызов GET  метода
	// fixed
	public Response getTypeOfTextToCheck(String uri, String textToCheck) {
		return given(REQUEST_SPECIFICATION).param(fileUtils.getParamKey(), textToCheck).get(uri);
	}


	//todo удали ненужный код
	// fixed
}
