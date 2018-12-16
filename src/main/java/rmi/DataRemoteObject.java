package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.recordPO;
import bl.Access;
import blService.AccessService;


public class DataRemoteObject extends UnicastRemoteObject implements AccessService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private AccessService accessService;

	protected DataRemoteObject() throws RemoteException {
		accessService=new Access();
	}



	@Override
	public boolean saveRecord(recordPO record) throws RemoteException{
		return accessService.saveRecord(record);
	}

	@Override
	public recordPO getRecord(String fileName) throws RemoteException{
		return accessService.getRecord(fileName);
	}

	@Override
	public ArrayList<String> getRecordList() throws RemoteException{
		return accessService.getRecordList();
	}
}
