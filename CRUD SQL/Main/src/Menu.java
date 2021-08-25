import java.util.Scanner;

class Menu {
    public void menuall() {
        Insert i = new Insert();
        Update u = new Update();
        Delete d = new Delete();
        View v = new View();
        Scanner s = new Scanner(System.in);
        String text;
        do {
            System.out.println("************************");
            System.out.println("Student Management System");
            System.out.println("************************");
            System.out.println("1.  Insert Student Record");
            System.out.println("2.  Update Student Record");
            System.out.println("3.  Delete Student Record");
            System.out.println("4.  View all Student Record");
            System.out.println("5.  Exit ");
            System.out.print("Enter choice(1-5): ");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    i.insertrecord();
                    break;
                case 2:
                    System.out.println("Update Record");
                    u.updaterecord();
                    break;
                case 3:
                    d.deleterecord();
                    break;

                case 4:
                    v.viewrecord();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
            System.out.println();
            System.out.println("Do you want to continue (y/n)");
            text = s.next();

        } while (text.equalsIgnoreCase("y"));
        s.close();
        System.out.println("Thank you ;)");
    }
}
