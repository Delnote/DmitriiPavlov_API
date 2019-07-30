package Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PropSettings {

    SPELLER_PROPERTY_PATH("src/test/resources/properties/speller.properties");

    final String name;

}
