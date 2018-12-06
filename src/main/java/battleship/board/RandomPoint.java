package battleship.board;

import battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Random;

public class RandomPoint {
    private Ship ship;
    private Random random = new Random();


    public RandomPoint(Ship ship){
        this.ship = ship;
    }

    public int generateNumber(){
        return random.nextInt(10);
    }

    public Point generatePoint(){
        return new Point(generateNumber() , generateNumber());
    }

    @SuppressWarnings("Duplicates")
    public ArrayList randomListPoints(){

        CheckerPoint checkerPoint = new CheckerPoint();
        ArrayList<Point> pointsList = new ArrayList();

        if(ship.getLength().equals("4")){
            pointsList.add(generatePoint());
        }
        else if(ship.getLength().equals("3")){
            int i= 0;

            while(i!=2){

                while(checkerPoint.checkPointsDuplicateInList(generatePoint())){
                    pointsList = checkerPoint.getNoDuplicateListPoints();
                }
                i++;
            }


        }
        else if(ship.getLength().equals("2")){
            int i=0;

            while(i!=3){
                pointsList.add(generatePoint());
                i++;
            }

        }
        else if(ship.getLength().equals("1")){
            int i=0;
            while(i!=4){
                pointsList.add(generatePoint());
                i++;
            }


        }else{
            System.out.println("Pustoo");
        }

        return pointsList;
    }

}
