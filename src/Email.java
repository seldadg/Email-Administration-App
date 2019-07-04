import java.util.Scanner;

public class Email{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPassLength = 10;
    private String alternateEmail;
    private String companySuffix = "anycompany.com";

    // Constructor to recieve the firstName and lastName
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter firstName: ");
        firstName = in.nextLine();

        System.out.print("Enter lastName: ");
        lastName = in.nextLine();

        System.out.println("Email created: " + firstName + " " + lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that return a random password
        this.password = randomPassword(defaultPassLength);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment(){
        System.out.print("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){
            return "Sales";
        }else if (depChoice == 2){
            return "Development";
        }else if (depChoice == 3){
            return "Accounting";
        }else {
            return "";
        }
    }

    // Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIKLMNOPQRSTVXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
             int rand = (int)(Math.random() * passwordSet.length());
             password[i] = passwordSet.charAt(rand);  
        }
        return new String(password);
    }


    // Set the mailBox Capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    // Set the alternal email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Your Info: " + 
        "\nDepartment: " + department +
        "\nCompany email: " + email + 
        "\nYour password: " + password +
        "\nMailBox capacity: " + mailBoxCapacity + "MB";
    }
}
