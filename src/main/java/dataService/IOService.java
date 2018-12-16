//需要客户端的Stub
package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOService extends Remote{
	public boolean writeFile(String file,String fileName)throws RemoteException;
	
	public String readFile(String fileName)throws RemoteException;
	
	public String readFileList()throws RemoteException;
}
