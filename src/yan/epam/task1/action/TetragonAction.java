package yan.epam.task1.action;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yan.epam.task1.entity.Tetragon;
import yan.epam.task1.exception.IncorrectDataException;


public class TetragonAction
{
    static Logger logger= LogManager.getLogger();

   public boolean isTetragon(Tetragon newTetr) throws IncorrectDataException
   {
       if (newTetr!= null)
       {
           if (!IsPointsOnLine(newTetr.getPoint2().getX(), newTetr.getPoint2().getY(), newTetr.getPoint3().getX(), newTetr.getPoint3().getY(),
                   newTetr.getPoint4().getX(),newTetr.getPoint4().getY())
                   & !IsPointsOnLine(newTetr.getPoint1().getX(), newTetr.getPoint1().getY(), newTetr.getPoint3().getX(), newTetr.getPoint3().getY(),
                   newTetr.getPoint4().getX(), newTetr.getPoint4().getY())
                   & !IsPointsOnLine(newTetr.getPoint1().getX(), newTetr.getPoint1().getY(), newTetr.getPoint2().getX(),newTetr.getPoint2().getY(),
                   newTetr.getPoint4().getX(), newTetr.getPoint4().getY())
                   & !IsPointsOnLine(newTetr.getPoint1().getX(), newTetr.getPoint1().getY(), newTetr.getPoint2().getX(), newTetr.getPoint2().getY(),
                   newTetr.getPoint3().getX(), newTetr.getPoint3().getY()))
           {
               logger.log(Level.INFO,"Its a tetragon");
               return true;
           }
           logger.log(Level.INFO,"Its not a tetragon");
           return false;
       }
       else {throw new IncorrectDataException("Incorrect tetragon name");}
   }

    public boolean IsPointsOnLine(double x1, double y1, double x2, double y2, double x3, double y3)
    {
    return (x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 * y1);
    }

    public double calcArea(Tetragon newTetr) throws IncorrectDataException
    {
        if (newTetr!= null)
        {
           double area=0.5*Math.abs(newTetr.getPoint1().getX()*newTetr.getPoint2().getY()+newTetr.getPoint2().getX()*newTetr.getPoint3().getY()
                   +newTetr.getPoint3().getX()*newTetr.getPoint4().getY()+newTetr.getPoint4().getX()*newTetr.getPoint1().getY()
                   -newTetr.getPoint2().getX()*newTetr.getPoint1().getY()-newTetr.getPoint3().getX()*newTetr.getPoint2().getY()
                   -newTetr.getPoint4().getX()*newTetr.getPoint3().getY()-newTetr.getPoint1().getX()*newTetr.getPoint4().getY());
           logger.log(Level.INFO,"Area of tetragon="+area);
           return area;
        }
        else {throw new IncorrectDataException("Incorrect tetragon name");}
    }

 public double calcPerimeter(Tetragon newTetr)throws IncorrectDataException
    {
        if (newTetr!= null)
        {
           double ab=Math.sqrt(Math.pow((newTetr.getPoint1().getX()-newTetr.getPoint2().getX()),2)+
                   Math.pow((newTetr.getPoint1().getY()-newTetr.getPoint2().getY()),2));
           double bc=Math.sqrt(Math.pow((newTetr.getPoint2().getX() - newTetr.getPoint3().getX()),2) +
                   Math.pow((newTetr.getPoint2().getY() - newTetr.getPoint3().getY()),2));
           double cd=Math.sqrt(Math.pow((newTetr.getPoint3().getX() - newTetr.getPoint4().getX()),2) +
                   Math.pow((newTetr.getPoint3().getY() - newTetr.getPoint4().getY()),2));
           double da=Math.sqrt(Math.pow((newTetr.getPoint4().getX() - newTetr.getPoint1().getX()),2) +
                   Math.pow((newTetr.getPoint4().getY() - newTetr.getPoint1().getY()),2));
           double perimeter=ab+bc+cd+da;
           logger.log(Level.INFO,"Perimeter of tetragon="+perimeter);
           return perimeter;
        }
        else {throw new IncorrectDataException("Incorrect tetragon name");}
    }

    public boolean isConvex(Tetragon newTetr)throws IncorrectDataException
    {
        if (newTetr!= null)
        {
            double s1=newTetr.getPoint1().getX()*(newTetr.getPoint2().getY()-newTetr.getPoint3().getY())+newTetr.getPoint2().getX()*
                    (newTetr.getPoint3().getY()-newTetr.getPoint1().getY())+newTetr.getPoint3().getX()*(newTetr.getPoint1().getY()-newTetr.getPoint2().getY());
            double s2=newTetr.getPoint3().getX()*(newTetr.getPoint4().getY()-newTetr.getPoint1().getY())+newTetr.getPoint4().getX()*
                    (newTetr.getPoint1().getY()-newTetr.getPoint3().getY())+newTetr.getPoint1().getX()*(newTetr.getPoint3().getX()-newTetr.getPoint4().getY());
            double s3=newTetr.getPoint2().getX()*(newTetr.getPoint3().getY()-newTetr.getPoint4().getY())+newTetr.getPoint3().getX()*
                    (newTetr.getPoint4().getY()-newTetr.getPoint2().getY())+newTetr.getPoint4().getX()*(newTetr.getPoint2().getY()-newTetr.getPoint3().getY());
            double s4=newTetr.getPoint4().getX()*(newTetr.getPoint1().getY()-newTetr.getPoint2().getY())+newTetr.getPoint1().getX()*
                    (newTetr.getPoint2().getY()-newTetr.getPoint4().getY())+newTetr.getPoint2().getX()*(newTetr.getPoint4().getY()-newTetr.getPoint1().getY());
            if(((s1*s2)>0)&((s3*s4)>0))
            {
                logger.log(Level.INFO,"Selected tetragon is convex");
                return true;
            }
            else
            {logger.log(Level.INFO,"Selected tetragon is not convex");
                return false;
            }
        }
        else {throw new IncorrectDataException("Incorrect tetragon name");}
    }

    public boolean isRhomb(Tetragon newTetr)throws IncorrectDataException
    {
        if (newTetr!= null)
        {
            double ab=Math.sqrt(Math.pow((newTetr.getPoint1().getX() - newTetr.getPoint2().getX()),2) +
                    Math.pow((newTetr.getPoint1().getY() - newTetr.getPoint2().getY()),2));
            double bc=Math.sqrt(Math.pow((newTetr.getPoint2().getX() - newTetr.getPoint3().getX()),2) +
                    Math.pow((newTetr.getPoint2().getY() - newTetr.getPoint3().getY()),2));
            double cd=Math.sqrt(Math.pow((newTetr.getPoint3().getX() - newTetr.getPoint4().getX()),2) +
                    Math.pow((newTetr.getPoint3().getY() - newTetr.getPoint4().getY()),2));
            double da=Math.sqrt(Math.pow((newTetr.getPoint4().getX() - newTetr.getPoint1().getX()),2) +
                    Math.pow((newTetr.getPoint4().getY() - newTetr.getPoint1().getY()),2));
            if ((((newTetr.getPoint4().getY()-newTetr.getPoint1().getY())*(newTetr.getPoint4().getX()-newTetr.getPoint1().getX()))==
                    ((newTetr.getPoint3().getY()-newTetr.getPoint2().getY())*(newTetr.getPoint3().getX()-newTetr.getPoint2().getX())))&
              ((newTetr.getPoint2().getY()-newTetr.getPoint1().getY())*(newTetr.getPoint2().getX()-newTetr.getPoint1().getX()))==
                      ((newTetr.getPoint3().getY()-newTetr.getPoint4().getY())*(newTetr.getPoint3().getX()-newTetr.getPoint4().getY())))
            {
                if ((ab==bc)&(bc==cd)&(cd==da))
                {
                    logger.log(Level.INFO, "Selected tetragon is a rhomb");
                    return true;
                }
            }
            logger.log(Level.INFO,"Selected tetragon is not a rhomb");
            return false;
        }
        else {throw new IncorrectDataException("Incorrect tetragon name");}
    }

    public boolean isSquare(Tetragon newTetr)throws IncorrectDataException
    {
        if (newTetr!= null)
        {
            boolean isRhomb = isRhomb(newTetr);
            if (isRhomb)
            {
                double ac = Math.sqrt(Math.pow((newTetr.getPoint1().getX() - newTetr.getPoint3().getX()), 2) +
                        Math.pow((newTetr.getPoint1().getY() - newTetr.getPoint3().getY()), 2));
                double db = Math.sqrt(Math.pow((newTetr.getPoint2().getX() - newTetr.getPoint4().getX()), 2) +
                        Math.pow((newTetr.getPoint2().getY() - newTetr.getPoint4().getY()), 2));
                if (ac==db)
                {
                    logger.log(Level.INFO, "Selected tetragon is a square");
                    return true;
                }
            }
            logger.log(Level.INFO, "Selected tetragon is not a square");
            return false;
        }
        else {throw new IncorrectDataException("Incorrect tetragon name");}
    }

       public boolean isTrapeze(Tetragon newTetr)throws IncorrectDataException
    {
        if (newTetr!= null)
        {
            if ((((newTetr.getPoint4().getY()-newTetr.getPoint1().getY())*(newTetr.getPoint4().getX()-newTetr.getPoint1().getX()))==
                    ((newTetr.getPoint3().getY()-newTetr.getPoint2().getY())*(newTetr.getPoint3().getX()-newTetr.getPoint2().getX())))|
                    ((newTetr.getPoint2().getY()-newTetr.getPoint1().getY())*(newTetr.getPoint2().getX()-newTetr.getPoint1().getX()))==
                            ((newTetr.getPoint3().getY()-newTetr.getPoint4().getY())*(newTetr.getPoint3().getX()-newTetr.getPoint4().getX())))
            {
                if (!((((newTetr.getPoint4().getY()-newTetr.getPoint1().getY())*(newTetr.getPoint4().getX()-newTetr.getPoint1().getX()))==
                        ((newTetr.getPoint3().getY()-newTetr.getPoint2().getY())*(newTetr.getPoint3().getX()-newTetr.getPoint2().getX())))&
                        ((newTetr.getPoint2().getY()-newTetr.getPoint1().getY())*(newTetr.getPoint2().getX()-newTetr.getPoint1().getX()))==
                                ((newTetr.getPoint3().getY()-newTetr.getPoint4().getY())*(newTetr.getPoint3().getX()-newTetr.getPoint4().getX()))))
                {
                    logger.log(Level.INFO,"Selected tetragon is a trapeze");
                    return true;
                }
            }
            logger.log(Level.INFO,"Selected tetragon is not a trapeze");
            return false;
        }
        else {throw new IncorrectDataException("Incorrect tetragon name");}
    }

}
