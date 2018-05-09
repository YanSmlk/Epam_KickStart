package yan.epam.task1.repository.impl;

import yan.epam.task1.action.TetragonAction;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.IncorrectDataException;
import yan.epam.task1.repository.TetragonSpecification;

public class TetragonSpecificationTrapeze implements TetragonSpecification
{
    TetragonAction tetrAct=new TetragonAction();

    @Override
    public boolean isSpecified(Tetragon newTetr) throws IncorrectDataException
    {
        return (tetrAct.isTrapeze(newTetr));
    }
}
