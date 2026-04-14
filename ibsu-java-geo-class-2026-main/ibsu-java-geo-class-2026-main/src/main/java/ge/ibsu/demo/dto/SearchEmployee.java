package ge.ibsu.demo.dto;

public class SearchEmployee {
    private String searchText;
    private String searchByPhone;
    private String setEmail;

    public String getSetEmail() {
        return setEmail;
    }

    public void setSetEmail(String setEmail) {
        this.setEmail = setEmail;
    }

    public String getSearchByPhone() {
        return searchByPhone;
    }

    public void setSearchByPhone(String searchByPhone) {
        this.searchByPhone = searchByPhone;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
