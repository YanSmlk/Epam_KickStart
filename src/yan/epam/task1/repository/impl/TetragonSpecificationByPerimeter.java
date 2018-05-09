package yan.epam.task1.repository.impl;

import yan.epam.task1.action.TetragonAction;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.IncorrectDataException;
import yan.epam.task1.repository.TetragonSpecification;

public class TetragonSpecificationByPerimeter implements TetragonSpecification
{
    private double minPerim,maxPerim;
    TetragonAction tetrAct=new TetragonAction();

    public TetragonSpecificationByPerimeter(double minPerim, double maxPerim)
    {
        this.minPerim=minPerim;
        this.maxPerim=maxPerim;
    }

    @Override
    public boolean isSpecified(Tetragon newTetr) throws IncorrectDataException
    {
        return ((tetrAct.calcPerimeter(newTetr)>=minPerim)&(tetrAct.calcPerimeter(newTetr)<=maxPerim));
    }
}
