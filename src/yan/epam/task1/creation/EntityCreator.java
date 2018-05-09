package yan.epam.task1.creation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yan.epam.task1.entity.Point;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.DataFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EntityCreator
{
    static Logger logger= LogManager.getLogger();

    public ArrayList<String> getPoints(String filePath) throws DataFileException
    {
        Scanner in = null;
        ArrayList<String> coordinatesArr = new ArrayList<>();
        File file = new File(filePath);
        if ((filePath.isEmpty()) | (filePath == null)) {throw new DataFileException("Empty file name");}
        if (!file.exists()) {throw new DataFileException("No file found: ", filePath);}
        if(file.length() == 0) {throw new DataFileException("File is empty: ", filePath);}
        try
        {
            in = new Scanner(file);
            while (in.hasNextLine())
            {
                coordinatesArr.add(in.nextLine());
        }
        }
        catch (FileNotFoundException e)
        {
            throw new DataFileException("No file found: ", filePath);
        }
        finally
        {
            if (in != null)
            {
                in.close();
            }
        }
        return coordinatesArr;
    }

    public ArrayList<Double> pointsParser(ArrayList<String> coordinatessArr)throws DataFileException
    {
        double x, y;
        String str;
        ArrayList<Double> validCoordinatesArr = new ArrayList<>();
        for (int i = 0; i < coordinatessArr.size(); i++)
        {
            str=coordinatessArr.get(i);
            String tempStr[] = str.trim().split("\\s+");
            if (tempStr.length!=2)
            {
                continue;
            }
            try
            {
                x = Double.parseDouble(tempStr[0]);
                y = Double.parseDouble(tempStr[1]);
            }
            catch (NumberFormatException e)
            {
                continue;
            }
            validCoordinatesArr.add(x);
            validCoordinatesArr.add(y);
        }
        return validCoordinatesArr;
    }

    public ArrayList<Point> pointsCreator(ArrayList<Double> validCoordinatesArr)throws DataFileException
    {
        if (validCoordinatesArr.size()<8) {throw new DataFileException("Not enought coordinates to create a tetragon");}
        ArrayList<Point> pointsArr = new ArrayList<Point>();
        for (int i = 0; i < validCoordinatesArr.size(); i += 2)
        {
            pointsArr.add(new Point(validCoordinatesArr.get(i),validCoordinatesArr.get(i + 1)));
        }
        logger.log(Level.INFO,pointsArr.size()+" Points are created");
        return pointsArr;
    }

    public Tetragon createTetragon(int id, Point point1, Point point2, Point point3, Point point4)
    {
        Tetragon newTetr= new Tetragon(id, point1,point2,point3,point4);
        logger.log(Level.INFO,"Tetragon is created");
        return newTetr;
    }

}
