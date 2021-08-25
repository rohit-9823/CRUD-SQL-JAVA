import java.sql.DriverManager;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Update {
    public void updaterecord() {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
            String q = "UPDATE table1 SET fname=?,lname=?,address=? where id=?";
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.println("Enter ID: ");
            int sid = Integer.parseInt(br.readLine());
            PreparedStatement ps = con.prepareStatement("Select * from table1 WHERE id=?");
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("enter first name");
                String fname = br.readLine();
                System.out.println("enter last name");
                String lname = br.readLine();
                System.out.println("enter address");
                String address = br.readLine();
                PreparedStatement preparest = con.prepareStatement(q);
                preparest.setString(1, fname);
                preparest.setString(2, lname);
                preparest.setString(3, address);
                preparest.setInt(4, sid);
                preparest.executeUpdate();
                System.out.println("Record Successfully Updated: ");
                con.close();

            } else {
                System.out.println("NO Record!!!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}