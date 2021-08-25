import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Delete {
    public void deleterecord() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
            String q = "DELETE FROM table1 where id=?";
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.println("Enter ID: ");
            int sid = Integer.parseInt(br.readLine());
            PreparedStatement ps = con.prepareStatement("Select * from table1 WHERE id=?");
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PreparedStatement preparest = con.prepareStatement(q);
                preparest.setInt(1, sid);
                preparest.executeUpdate();
                System.out.println("Record Successfully DELETED: ");
                con.close();
            } else {
                System.out.println("NO Record!!!!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
