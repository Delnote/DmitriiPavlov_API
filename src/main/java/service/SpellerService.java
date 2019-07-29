package service;


import static io.restassured.RestAssured.given;
import static service.URI.PARAM_KEY;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class SpellerService {
	private RequestSpecification REQUEST_SPECIFICATION;

	//todo speller.yandex.net почему в коде?
	public SpellerService() {
		REQUEST_SPECIFICATION = new RequestSpecBuilder()
				.setBaseUri("https://speller.yandex.net/services/spellservice.json/")
				.addFilter(new RequestLoggingFilter())
				.addFilter(new ResponseLoggingFilter()).build();
	}

	//todo название не сильно подходящее. я его с функционало п перепутала. Это низкоуровневые действия, нужно акцент сделать, что это иименно вызов GET  метода
	public Response checkText(String uri, String textToCheck) {
		return given(REQUEST_SPECIFICATION).param(PARAM_KEY, textToCheck).get(uri);
	}


	//todo удали ненужный код
//	public Response checkTexts(String uri, String textToCheck) {
//		return given(REQUEST_SPECIFICATION).param(PARAM_KEY, textToCheck).get(uri);
//	}

	public Response checkWithParams(String uri, Map<String, Object> params) {
		RequestSpecification specification = given(REQUEST_SPECIFICATION);

		for (Map.Entry<String, Object> param : params.entrySet())
			specification.param(param.getKey(), param.getValue());

		return specification.get(uri);
	}
}
