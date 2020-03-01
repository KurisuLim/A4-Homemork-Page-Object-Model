package pages;

public class Users {
    protected String firstName,
            lastName,
            businessName,
            phone,
            email,
            password;

    public Users emptySignUp() {
        firstName = "";
        lastName = "";
        businessName = "";
        phone = "";
        email = "";
        password = "";
        return this;
    }

    public Users wrongSignUp() {
        firstName = "John";
        lastName = "Doe";
        businessName = "Testing Program";
        phone = "1";
        email = "1";
        password = "12345678";
        return this;
    }

}
