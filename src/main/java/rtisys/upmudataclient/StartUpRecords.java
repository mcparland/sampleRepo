/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtisys.upmudataclient;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mcp
 */
public class StartUpRecords {
  
    List<StartUpRecord> getRecords(CassandraConnector cc) {
        List<StartUpRecord> startUpRecords = new ArrayList<StartUpRecord>();
        final ResultSet cassRecords = cc.getSession().execute(
          "SELECT * FROM upmu_devel.upmu_operations");
        List<Row> rows = cassRecords.all();
        for(Row row : rows) {
            StartUpRecord rec = new StartUpRecord(
                row.getString("COMPONENT"),
                row.getLong("SESSION_ID"),
                row.getString("DEVICE"),
                row.getLong("DAY"),
                row.getLong("TIMESTAMP_MSEC"),
                row.getInt("DOMAIN_TYPE"),
                row.getInt("MSG_TYPE"),
                row.getBytes("DATA"));
            startUpRecords.add(rec);
        }       
        return startUpRecords;
    }
}  

