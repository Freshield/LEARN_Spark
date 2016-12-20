package main.java;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by freshield on 19/12/16.
 */
public class Alter_KeySpace {

    public static void main(String[] args) {

        String query = "alter keyspace tp with replication" +
                "={'class':'NetworkTopologyStrategy','datacenter1':3}" +
                "and durable_writes=false;";

        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        Session session = cluster.connect();

        session.execute(query);

        System.out.println("keyspace altered");

    }
}
