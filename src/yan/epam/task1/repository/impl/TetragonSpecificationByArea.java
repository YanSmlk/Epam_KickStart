package yan.epam.task1.repository.impl;

import yan.epam.task1.action.TetragonAction;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.IncorrectDataException;
import yan.epam.task1.repository.TetragonSpecification;

public class TetragonSpecificationByArea implements TetragonSpecification
{
    private double minArea,maxArea;
    TetragonAction tetrAct=new TetragonAction();

    public TetragonSpecificationByArea(double minArea, double maxArea)
    {
        this.minArea=minArea;
        this.maxArea=maxArea;
    }

    @Override
    public boolean isSpecified(Tetragon newTetr) throws IncorrectDataException
    {
        return ((tetrAct.calcArea(newTetr)>=minArea&(tetrAct.calcArea(newTetr)<=maxArea)));
    }
}
