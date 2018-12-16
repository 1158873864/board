//需要客户端的Stub
package blService;

import PO.recordPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AccessService extends Remote{
    public boolean saveRecord(recordPO record) throws RemoteException;
    public recordPO getRecord(String fileName) throws RemoteException;
    public ArrayList<String> getRecordList() throws RemoteException;
}
