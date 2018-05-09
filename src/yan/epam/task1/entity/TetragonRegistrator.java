package yan.epam.task1.entity;

public class TetragonRegistrator
{
    double area;
    double perimeter;

    public TetragonRegistrator(double area, double perimeter)
    {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area)
    {
        this.area = area;
    }

    public double getPerimeter()
    {
        return perimeter;
    }

    public void setPerimeter(double perimeter)
    {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TetragonRegistrator that = (TetragonRegistrator) o;
        if (Double.compare(that.area, area) != 0) return false;
        if (Double.compare(that.perimeter, perimeter) != 0) return false;
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(area);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perimeter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Registrator{" +
                "Area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
