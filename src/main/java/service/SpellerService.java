package service;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.FileUtils;

import static io.restassured.RestAssured.given;

public class SpellerService {
	private FileUtils fileUtils = new FileUtils();
	private RequestSpecification REQUEST_SPECIFICATION;

	public SpellerService() {
		fileUtils.readSpellerPropertiesFromFile();

		REQUEST_SPECIFICATION = new RequestSpecBuilder()
				.setBaseUri(fileUtils.getDomain())
				.addFilter(new RequestLoggingFilter())
				.addFilter(new ResponseLoggingFilter()).build();
	}

	public Response getTypeOfTextToCheck(String uri, String textToCheck) {
		return given(REQUEST_SPECIFICATION).param(fileUtils.getParamKey(), textToCheck).get(uri);
	}
}
