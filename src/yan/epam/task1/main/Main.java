package yan.epam.task1.main;
import yan.epam.task1.creation.EntityCreator;
import yan.epam.task1.entity.Point;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.DataFileException;
import yan.epam.task1.repository.impl.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main
{
    public static void main(String args[])
    {
        List<Tetragon> resultTetr;
        EntityCreator creator=new EntityCreator();
        try
        {

            ArrayList<String> coordinatesArr=creator.getPoints("points.txt");
            ArrayList<Double> validCoordinatesArr=creator.pointsParser(coordinatesArr);
            ArrayList<Point> pointsArr=creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));


            //SingletonTetragonHashMap.getInstance().addToList(newTetr1);
            //SingletonTetragonHashMap.getInstance().addToList(newTetr2);
            TetragonRepository rep=new TetragonRepository();
            TetragonSpecificationByArea specification=new TetragonSpecificationByArea(2,200);
            resultTetr=rep.query(specification);

            for (Tetragon newTetr : resultTetr)
            {System.out.println(newTetr);}



            System.out.println("----------SORT-----------");
            Collections.sort(resultTetr, new  TetragonComparatorByPerimeter());

            System.out.println("----------SORT RES-----------");
            for (Tetragon newTetr : resultTetr)
            {System.out.println(newTetr);}

            System.out.println("----------TRAPEZEEEEEE-----------");
            TetragonSpecificationTrapeze spec=new TetragonSpecificationTrapeze();
            resultTetr=rep.query(spec);
            System.out.println("----------TRAPEZEEEEEE RES-----------");
            for (Tetragon newTetr : resultTetr)
            {System.out.println(newTetr);}
        }

        catch (DataFileException ex)
        {
            System.out.println(ex.getMessage());
        }


    }
}