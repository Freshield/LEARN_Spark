package main.java;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by freshield on 19/12/16.
 */
public class Test {

    public static void main(String[] args) {
        String query = "create keyspace tp with replication"
                + "={'class':'SimpleStrategy','replication_factor':1};";

        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        Session session = cluster.connect();

        session.execute(query);

        session.execute("use tp");

        System.out.println("keyspace created");;
    }

}
