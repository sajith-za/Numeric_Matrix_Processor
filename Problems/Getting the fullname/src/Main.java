class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null) {
            this.lastName =  lastName;
        }
    }

    public String getFullName() {
    /*
        if (this.firstName.length() > 0 && this.lastName.length() > 0) {
            return this.firstName + " " + this.lastName;
        }

        else if (this.firstName.length() == 0 && this.lastName.length() == 0) {
            return "Unknown";
        }

        else {
            return this.firstName + this.lastName;
        }
    */
        String fullName = this.firstName.concat(" ").concat(this.lastName).trim();
        return fullName.isEmpty() ? "Unknown" : fullName;

    }
}