package battleship.board;

import java.util.ArrayList;

public class CheckerPoint {

    private ArrayList<Point> points = new ArrayList<>();

    public boolean checkPointsDuplicate(Point point){
        points.add(point);

            if(points.contains(point)) {
                points.remove(point);
                return false;
            }


         return  true;
    }

    public ArrayList getNoDuplicatePoints() {
            return points;

    }

}
