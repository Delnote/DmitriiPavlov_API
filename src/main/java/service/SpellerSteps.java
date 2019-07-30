package service;

import com.google.gson.Gson;
import dto.SpellerDto;

import static service.URI.GET_CHECK_TEXT;
import static service.URI.GET_CHECK_TEXTS;

public class SpellerSteps {

	public SpellerDto[] checkText(String textToCheck) {
		return
				new Gson().fromJson(
						new SpellerService()
								.getTypeOfTextToCheck(GET_CHECK_TEXT, textToCheck)
								.getBody().asString(), SpellerDto[].class);
	}

	public SpellerDto[][] checkTexts(String textToCheck) {
		return
				new Gson().fromJson(
						new SpellerService()
								.getTypeOfTextToCheck(GET_CHECK_TEXTS, textToCheck)
								.getBody().asString(), SpellerDto[][].class);
	}
}
