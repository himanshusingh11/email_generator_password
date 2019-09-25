
package oop;

public class User {


    private String Name;
    private String CompanyName;
    private int yearOfJoining;
    private String email;
    private String password;

    public User(String Name, String CompanyName, int yearOfJoining) {
        this.Name = Name;
        this.CompanyName = CompanyName;
        this.yearOfJoining = yearOfJoining;
        this.email = createEmail();
        this.password = createPassword();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public int getYearofJoining() {
        return yearOfJoining;
    }

    public void setYearofJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int generateRandomIntegerFromLimit(int limit) {
        return (int) (Math.random() * limit);
    }

    private char generateRandomCharacter() {
        return (char) ('a' + generateRandomIntegerFromLimit(26));
    }

    private String getFirst5CharactersFromUserName() {
        if (getName().length() < 5) {
            StringBuilder pass = new StringBuilder();
            int difference = 5 - getName().length();
            pass.append("0".repeat(Math.max(0, difference)));
            return pass.toString();
        } else {
            return getName().substring(0, 5);
        }
    }

    private char generateRandomSpecialSymbol() {
        char[] specialSymbols = {
                '!', '~', '@', '#', '$', '%', '^', '&', '*', '(', ')', '|', '/', '\'', '<', '>', '.', ','};
        int randomNumber = generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomNumber];
    }

    public String createPassword() {
        StringBuilder pass = new StringBuilder();
        pass.append(generateRandomCharacter());
        for (int i = 0; i < 4; i++) {
            pass.append(generateRandomIntegerFromLimit(generateRandomIntegerFromLimit(10)));
        }
        pass.append(getFirst5CharactersFromUserName());
        pass.append(generateRandomSpecialSymbol());
        return pass.toString();
    }

    public String createEmail() {
        return String.format("%s_%d@%s.com",
                getName().toLowerCase(),
                getYearofJoining(),
                getCompanyName().toLowerCase());

    }
}

class Solution4 {
    public static void main(String[] args) {
        User a = new User("himanshu", "gla", 2013);
        User b = new User("mahima", "gla", 2019);
        System.out.println(a.createEmail());
        System.out.println(a.createPassword());
        System.out.println(b.createEmail());
        System.out.println(b.createPassword());
    }
}




