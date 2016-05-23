/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtisys.upmudataclient;

import static java.lang.System.out;
import java.nio.ByteBuffer;
import java.util.List;
import serviceCommon.UpmuStructKeyValueListProtobuf.upmuStructKeyValueList;

/**
 *
 * @author mcp
 */
public class Main {

    public static void main(final String[] args)
    {
       final CassandraConnector client = new CassandraConnector();
       final String ipAddress = args.length > 0 ? args[0] : "localhost";
       final int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
       final StartUpRecords recordList = new StartUpRecords();
       out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
       client.connect(ipAddress, port);
       
       List<StartUpRecord> records = recordList.getRecords(client);
       for(StartUpRecord record : records) {
           ByteBuffer data = record.data;
           try {
               System.out.println("Session: " + record.sessionID);
               System.out.println("Component: " + record.component);
               upmuStructKeyValueList kvl = upmuStructKeyValueList.parseFrom(data.array());
               System.out.println(kvl);
           }
           catch (Exception ex) {
               int k=0;
           }
       }
       
       client.close();
    }
}
