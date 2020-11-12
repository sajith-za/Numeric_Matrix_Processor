class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String text) {
        this.title = text;
    }

    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }

    public void setYearOfPublishing(int val) {
        this.yearOfPublishing = val;
    }

    public String[] getAuthors() {
        return this.authors.clone();
    }

    public void setAuthors(String[] arr1) {
        this.authors = java.util.Arrays.copyOf(arr1, arr1.length);
    }
}

