package bl;

import PO.PointPO;
import PO.recordPO;
import blService.AccessService;
import data.IO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Access implements AccessService{

    @Override
    public boolean saveRecord(recordPO record) throws RemoteException {
        String toBeSave=record.getDate()+";";
        String fileName=record.getName();
        for(int i=0;i<record.getPointList().size();i++){
            toBeSave=toBeSave+record.getPointList().get(i).getX()+","+record.getPointList().get(i).getY()+","+record.getPointList().get(i).getColor()+";";
        }
        IO.getInstance().writeFile(toBeSave,fileName);
        return true;
    }

    @Override
    public recordPO getRecord(String fileName) throws RemoteException{
        String recordString=IO.getInstance().readFile(fileName);
        String temp[]=recordString.split(";");
        String date=temp[0];
        ArrayList<PointPO> pointPOArrayList=new ArrayList<>();
        for(int i=1;i<temp.length;i++){
            String[] pointArray=temp[i].split(",");
            PointPO pointPO=new PointPO(Integer.parseInt(pointArray[0]),Integer.parseInt(pointArray[1]),Integer.parseInt(pointArray[2]));
            pointPOArrayList.add(pointPO);
        }
        recordPO recordPO=new recordPO(pointPOArrayList,fileName,date);
        return recordPO;
    }

    @Override
    public ArrayList<String> getRecordList() throws RemoteException{
        String recordString=IO.getInstance().readFileList();
        String[] recordArray=recordString.split("\n");
        ArrayList<String> recordList=new ArrayList<>();
        for(int i=0;i<recordArray.length;i++){
            recordList.add(recordArray[i]);
        }
        return recordList;
    }
}
