package com.guet.graduationdesign.util;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
* @Description:    串口工具类
* @Author:         TJX
* @CreateDate:     2019-05-13 19:34
* @UpdateUser:
* @UpdateDate:     2019-05-13 19:34
* @UpdateRemark:
* @Version:        1.0
*/
public class SerialPortUtil {

    static Enumeration<CommPortIdentifier> portList;
    static CommPortIdentifier portId;

    public static void serialPortList(){
        /**
        * @Description: 列出所有串口
        * @Author:      TJX
         * @param
        * @Return      void
        * @Exception
        * @Date        2019-05-13 19:36
        */
        portList = CommPortIdentifier.getPortIdentifiers();
        while(portList.hasMoreElements()){
            portId = (CommPortIdentifier)portList.nextElement();
            if(portId.getPortType() == CommPortIdentifier.PORT_SERIAL){
                System.out.println(portId.getName());
            }
        }
    }

}
