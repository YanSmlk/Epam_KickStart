package yan.epam.task1.repository.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.IncorrectDataException;
import yan.epam.task1.repository.Repository;
import yan.epam.task1.repository.TetragonSpecification;
import yan.epam.task1.storage.SingletonTetragonList;
import java.util.ArrayList;
import java.util.List;

public class TetragonRepository implements Repository
{
    static Logger logger= LogManager.getLogger();

    @Override
    public List<Tetragon> query(TetragonSpecification specification)
    {
        List<Tetragon> createdTetr= SingletonTetragonList.getInstance().getList();
        List<Tetragon> resultTetr=new ArrayList<>();
        try
        {
            for (Tetragon tetr : createdTetr)
            {
                if (specification.isSpecified(tetr))
                {
                    resultTetr.add(tetr);
                }
            }
            return resultTetr;
        }
        catch (IncorrectDataException ex)
        {
            logger.log(Level.ERROR,ex.getMessage());
            return null;
        }
    }
}

