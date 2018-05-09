package yan.epam.task1.repository.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yan.epam.task1.action.TetragonAction;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.IncorrectDataException;
import java.util.Comparator;

public class TetragonComparatorByPerimeter implements Comparator<Tetragon>
{
    static Logger logger= LogManager.getLogger();
    TetragonAction tetrAct= new TetragonAction();

    public int compare(Tetragon newTetr1, Tetragon newTetr2)
    {
        try
        {
            double perim1= tetrAct.calcPerimeter(newTetr1);
            double perim2= tetrAct.calcPerimeter(newTetr2);
            if(perim1 > perim2)
            {
                return 1;
            }
            else if(perim1 < perim2)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        catch (IncorrectDataException ex)
        {
            logger.log(Level.ERROR,ex.getMessage());
            return 0;
        }
    }
}
