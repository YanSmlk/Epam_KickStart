package yan.epam.task1.observer;

import yan.epam.task1.entity.Tetragon;

public interface OperationObserver
{
    void pointChangeHandle(Tetragon tetragon);
}
