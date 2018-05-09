package yan.epam.task1.repository;

import java.util.List;

public interface Repository
{
    List query(TetragonSpecification specification);
}
