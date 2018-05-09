package yan.epam.task1.entity;

import yan.epam.task1.observer.TetragonHandler;

public class Tetragon
{
    private int id;
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    private TetragonHandler tetrHandler;

    public Tetragon(int id, Point point1,Point point2, Point point3, Point point4)
    {
        this.id=id;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public int getId() {
        return id;
    }

    public Point getPoint1()
    {
        return point1;
    }

    public Point getPoint2()
    {
        return point2;
    }

    public Point getPoint3()
    {
        return point3;
    }

    public Point getPoint4()
    {
        return point4;
    }

    public void setPoint1(Point point1)
    {
        this.point1 = point1;

        notifyObservers();
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
        notifyObservers();
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
        notifyObservers();
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
        notifyObservers();
    }

    public void addObserver(TetragonHandler tetrHandler)
    {
        this.tetrHandler = tetrHandler;
    }

    private void notifyObservers()
    {
        if(tetrHandler != null)
        {

            tetrHandler.pointChangeHandle(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Tetragon tetragon = (Tetragon) o;

        if (point1 != null ? !point1.equals(tetragon.point1) : tetragon.point1 != null)
            return false;
        if (point2 != null ? !point2.equals(tetragon.point2) : tetragon.point2 != null)
            return false;
        if (point3 != null ? !point3.equals(tetragon.point3) : tetragon.point3 != null)
            return false;
        if (point4 != null ? !point4.equals(tetragon.point4) : tetragon.point4 != null)
            return false;
        return false;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31*result + (point1 != null ? point1.hashCode() : 0);
        result = 31 * result + (point2 != null ? point2.hashCode() : 0);
        result = 31 * result + (point3 != null ? point3.hashCode() : 0);
        result = 31 * result + (point4 != null ? point4.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return  "Tetragon{"+"id=" + id +"point1=" + point1 + ", point2=" + point2 + ", point3=" + point3 + ", point4=" + point4 + "}";
    }

}
