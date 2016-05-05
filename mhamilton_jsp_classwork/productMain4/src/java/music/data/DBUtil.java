package music.data;

import java.sql.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    //Adding entity manager factory to retreive data
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("productMain4PU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
    
    //Old code, not sure if still valid (update: app won't run w/o it)
    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
