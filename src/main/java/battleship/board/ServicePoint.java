package battleship.board;

import java.util.ArrayList;

public class ServicePoint {

    private ArrayList<Point> listPoints = new ArrayList<>();

    public void addPointToList(Point point){
        listPoints.add(point);
    }

    public ArrayList<Point> getListPoints() {
        return listPoints;
    }

    public void showList(){
        for(Point point : listPoints){
            System.out.println(point.getX() + " : " + point.getY());
        }
    }
}
