package PO;

import java.io.Serializable;
import java.util.ArrayList;

public class PointListPO implements Serializable {
    ArrayList<PointPO> pointList;

    public PointListPO(ArrayList<PointPO> pointList) {
        this.pointList = pointList;
    }

    public ArrayList<PointPO> getPointList() {
        return pointList;
    }

    public void setPointList(ArrayList<PointPO> pointList) {
        this.pointList = pointList;
    }
}
