package main.java;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

/**
 * Created by freshield on 19/12/16.
 */
public class Read_Data {

    public static void main(String[] args) {
        String query = "SELECT * from emp;";

        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        Session session = cluster.connect("tutorialspoint");

        ResultSet resultSet = session.execute(query);

        System.out.println(resultSet.all());
    }
}
