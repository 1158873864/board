package PO;

import java.io.Serializable;
import java.util.ArrayList;

public class recordPO implements Serializable {
    ArrayList<PointPO> pointList;
    String name;
    String date;

    public recordPO(ArrayList<PointPO> pointList, String name, String date) {
        this.pointList = pointList;
        this.name = name;
        this.date = date;
    }

    public ArrayList<PointPO> getPointList() {
        return pointList;
    }

    public void setPointList(ArrayList<PointPO> pointList) {
        this.pointList = pointList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
