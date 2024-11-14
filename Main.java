import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Dictionary<String, Integer> dict = new Hashtable<>();

        dict.put("Sally", 343634367);
        dict.put("Barry", 724925379);
        dict.put("Hank", 614914618);

        System.out.println("***");
        System.out.println("Welcome to your phonebook!");
        System.out.println("Please choose an action:");
        System.out.println("1. Show contacts \n2. Add new contact \n3. Update contact \n4. Remove contact \n5. Exit");
        System.out.println("***");
        System.out.print("Choice: ");

        boolean loop = true;

        while(loop) {
            String choice = scan.nextLine();
            switch(choice) {

                case "1":
                    for (Enumeration k = dict.keys(); k.hasMoreElements();) {
                        Object key = k.nextElement();
                        System.out.println("Name: " + key + ", Phone: " + dict.get(key));
                    }
                    System.out.println();
                    System.out.print("Choice: ");
                    break;

                case "2":
                    System.out.println("Adding new contact:");
                    System.out.print("Name: ");
                    String newName = scan.nextLine();
                    System.out.print("Phone: ");
                    int newPhone = scan.nextInt(); scan.nextLine();
                    dict.put(newName, newPhone);
                    System.out.println("Contact added!");
                    System.out.println();
                    System.out.print("Choice: ");
                    break;

                case "3":
                    System.out.println("Update a contact:");
                    System.out.print("Name: ");
                    String name = scan.nextLine();
                    System.out.println("1. Name \n2. Number \n3. Both");
                    System.out.print("What would you like to update? - ");
                    String update = scan.nextLine();
                    System.out.println();
                    switch(update) {
                        case "1":
                            System.out.print("New name: ");
                            String updateName = scan.nextLine();
                            dict.put(updateName, dict.get(name));
                            dict.remove(name);
                            break;
                        case "2":
                            System.out.print("New number: ");
                            int updateNum = scan.nextInt(); scan.nextLine();
                            dict.put(name, updateNum);
                            break;
                        case "3":
                            System.out.print("Name: ");
                            String updateName1 = scan.nextLine();
                            System.out.print("Phone: ");
                            int updateNum1 = scan.nextInt(); scan.nextLine();
                            dict.put(updateName1, updateNum1);
                            dict.remove(name);
                            break;
                        default:
                            System.out.println("Please choose a number from above. Referring back to menu.");
                    }
                    System.out.println("Contact updated!");
                    System.out.println();
                    System.out.print("Choice: ");
                    break;

                case "4":
                    System.out.println("Remove a contact:");
                    System.out.print("Name: ");
                    String removeName = scan.nextLine();
                    dict.remove(removeName);
                    System.out.println("Contact removed!");
                    System.out.println();
                    System.out.print("Choice: ");
                    break;

                case "5":
                    loop = false;
                    break;

                default:
                    System.out.println("Please choose a number from above.");
                    break;
            }
        }
    }
}