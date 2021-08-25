import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Insert {
    public void insertrecord() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create conn
            String url = "jdbc:mysql://localhost:3306/crud";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            // query creation
            String q = "INSERT INTO table1(id,fname,lname,address) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(q);
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.println("************************");
            System.out.print("Enter id: ");
            int s_id = Integer.parseInt(br.readLine());
            System.out.print("enter first name: ");
            String fname = br.readLine();
            System.out.print("enter last name: ");
            String lname = br.readLine();
            System.out.print("enter address: ");
            String address = br.readLine();
            // set value to db
            ps.setInt(1, s_id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, address);
            ps.executeUpdate();
            System.out.println("Inserted...");
        } catch (Exception e) {
            System.out.println("BAKAYARO");
        }
    }

}
