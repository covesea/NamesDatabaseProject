package one.digitalinnovation.namesapi.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    BUSINESS("Business");

    private final String description;
}
