package yan.epam.task1.repository;

import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.IncorrectDataException;

public interface TetragonSpecification
{
    boolean isSpecified(Tetragon newTetr) throws IncorrectDataException;
}
