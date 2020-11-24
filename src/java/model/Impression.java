package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Impression {

    private int id;
    private String username;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static String allImpresions() {

        StringBuilder all_impressions = new StringBuilder();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Caoooooooo" + ex);;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/impression?autoReconnect=true&useSSL=false", "root", "vidak146");) {
            Statement st = conn.createStatement();
            st.executeQuery("select imp.username, imp.text from impressions as imp");
            ResultSet result = st.getResultSet();
            while (result.next()) {

                all_impressions.append(result.getString("username"));
                all_impressions.append(":");
                all_impressions.append(result.getString("text"));
                all_impressions.append("\n");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Impression.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all_impressions.toString();
    }

    public void insertImpression() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/impression?autoReconnect=true&useSSL=false", "root", "vidak146");) {

                if (username != null && !(username.isEmpty()) && text != null && !(text.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("insert into impressions(username,text) values ('" + username + "', '" + text + "') ");

                }
            } catch (SQLException ex) {
                System.err.print(ex.toString());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
}
