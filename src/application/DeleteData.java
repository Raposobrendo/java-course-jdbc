package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] Args){

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            /* st = conn.prepareStatement(
                "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?"
            );
            st.setInt(1, 2);

            Example how to make delete*/

            st = conn.prepareStatement(
                    "DELETE FROM seller "
                    + "WHERE Name = ?"
            );

            st.setString(1, "Carl Purple");

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
