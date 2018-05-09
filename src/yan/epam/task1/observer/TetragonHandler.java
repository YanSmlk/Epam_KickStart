package yan.epam.task1.observer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yan.epam.task1.action.TetragonAction;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.entity.TetragonRegistrator;
import yan.epam.task1.exception.IncorrectDataException;
import yan.epam.task1.storage.SingletonTetragonHashMap;
import java.util.HashMap;

public class TetragonHandler implements OperationObserver
{
    static Logger logger= LogManager.getLogger();

    @Override
    public void pointChangeHandle(Tetragon newTetr)
    {
        HashMap<Integer, TetragonRegistrator> hashMap= SingletonTetragonHashMap.getInstance().getMap();
        TetragonRegistrator tetrReg=hashMap.get(newTetr.getId());
        TetragonAction tetragonAct=new TetragonAction();
        try
        {
            tetrReg.setArea(tetragonAct.calcArea(newTetr));
            tetrReg.setPerimeter(tetragonAct.calcPerimeter(newTetr));
        }
        catch (IncorrectDataException ex)
        {
           logger.log(Level.ERROR,ex.getMessage());
        }
    }
}


