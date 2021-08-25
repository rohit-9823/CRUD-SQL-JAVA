import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class View {
    public void viewrecord() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
            Statement smt = con.createStatement();
            String q = "Select * from table1";
            ResultSet rs = smt.executeQuery(q);
            if (rs.next()) {
                System.out.println("ID" + "\t" + "FName" + "\t" + "\t" + "LName" + "\t" + "\t" + "Address");
                System.out.println();
                do {

                    System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + "\t" + rs.getString(3) + "\t"
                            + "\t" + rs.getString(4));
                } while (rs.next());
            } else {
                System.out.println("Record Not Found...");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
