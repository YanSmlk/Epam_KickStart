package yan.epam.task1.storage;

import yan.epam.task1.entity.Tetragon;
import java.util.ArrayList;
import java.util.List;


public class SingletonTetragonList
{
    private static SingletonTetragonList singlL;
    private List<Tetragon> createdTetr = new ArrayList<Tetragon>();

    public static SingletonTetragonList getInstance()
    {
        if (singlL == null)
        {
            singlL = new SingletonTetragonList();
        }
        return singlL;
    }

    public List<Tetragon> getList()
    {
        return this.createdTetr;
    }

    public void addToList(Tetragon newTetr)
    {
        createdTetr.add(newTetr);
    }

}
