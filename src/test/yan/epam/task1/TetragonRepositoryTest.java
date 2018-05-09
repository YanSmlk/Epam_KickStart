package test.yan.epam.task1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import yan.epam.task1.action.TetragonAction;
import yan.epam.task1.creation.EntityCreator;
import yan.epam.task1.entity.Point;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.DataFileException;
import yan.epam.task1.repository.Repository;
import yan.epam.task1.repository.impl.*;
import yan.epam.task1.storage.SingletonTetragonList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.testng.AssertJUnit.fail;

public class TetragonRepositoryTest
{
    EntityCreator creator;
    TetragonAction action;
    ArrayList<String> coordinatesArr;
    ArrayList<Double> validCoordinatesArr;
    ArrayList<Point> pointsArr;

    @BeforeClass
    public void setParam()
    {
        creator=new EntityCreator();
        action=new TetragonAction();
    }

    @AfterClass
    public void clearParam()
    {
        EntityCreator creator=null;
        TetragonAction action=null;
        ArrayList<String> coordinatesArr=null;
        ArrayList<Double> validCoordinatesArr=null;
        ArrayList<Point> pointsArr=null;
    }

    @AfterMethod
    public void singletonClear()
    {
        SingletonTetragonList.getInstance().getList().clear();
    }

    @Test
    public void areaSpecificationTest()
    {
        List<Tetragon> resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("points.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);

            Repository rep=new TetragonRepository();
            TetragonSpecificationByArea specification=new TetragonSpecificationByArea(10,200);
            resultTetr=rep.query(specification);
            Assert.assertTrue(resultTetr.size()==1);
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }

    @Test
    public void perimeterSpecificationTest()
    {
        List<Tetragon> resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("points.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);
            TetragonRepository rep=new TetragonRepository();
            TetragonSpecificationByPerimeter specification=new TetragonSpecificationByPerimeter(8,50);
            resultTetr=rep.query(specification);
            Assert.assertTrue(resultTetr.size()==2);
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }

    @Test
    public void trapezeSpecificationTest()
    {
        List<Tetragon> resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("points.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);
            TetragonRepository rep=new TetragonRepository();
            TetragonSpecificationTrapeze specification=new TetragonSpecificationTrapeze();
            resultTetr=rep.query(specification);
            Assert.assertTrue(resultTetr.size()==1);
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }

    @Test
    public void comparatorByPerimeterTest()
    {
        List<Tetragon> resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("points.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);
            resultTetr= SingletonTetragonList.getInstance().getList();
            Collections.sort(resultTetr, new TetragonComparatorByPerimeter());
            Assert.assertTrue((resultTetr.get(0).getId()==2)&(resultTetr.get(1).getId()==1));
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }
}

