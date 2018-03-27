package twitter.dto;

public class SearchTwitterMessageDto {

    private String searchTitle;
    private String searchMessage;
    private String searchUsername;

    public SearchTwitterMessageDto(String searchTitle, String searchMessage, String searchUsername) {
        this.searchTitle = searchTitle;
        this.searchMessage = searchMessage;
        this.searchUsername = searchUsername;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public String getSearchMessage() {
        return searchMessage;
    }

    public String getSearchUsername() {
        return searchUsername;
    }
}
