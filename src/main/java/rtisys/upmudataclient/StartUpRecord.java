/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtisys.upmudataclient;

import java.nio.ByteBuffer;

/**
 *
 * @author mcp
 */
public class StartUpRecord {
    String component;
    long sessionID;
    String deviceID;
    long timestampMsec;
    long day;
    int domainType;
    int msgType;
    ByteBuffer data;
    
    public StartUpRecord() {}
    public StartUpRecord(String component,
        long sessionID,
        String deviceID,
        long day,
        long timestampMsec,
        int domainType,
        int msgType,
        ByteBuffer data){
        
        this.component = component;
        this.sessionID = sessionID;
        this.deviceID = deviceID;
        this.day = day;
        this.timestampMsec = timestampMsec;
        this.domainType = domainType;
        this.msgType = msgType;
        this.data = data;
    }
    
}