package twitter.enums;

public enum Language {

    PL("PL", "Polska"),
    EN("EN", "English"),
    CN("CN", "Chiński");

    private String countryCode;
    private String description;

    Language(String countryCode, String description) {
        this.countryCode = countryCode;
        this.description = description;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDescription() {
        return description;
    }
}
