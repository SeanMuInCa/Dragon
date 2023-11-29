package game;

/**
 * Purpose:             game<br />
 * Data Submitted:      2023/11/27 <br />
 * Assignment Number:    assignment 2<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Red.java <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Red extends Dragon
{
    public String name;
    public Red(DragonSize nSize, String name)
    {
        super(nSize);
        this.name = nSize + name;
    }

    @Override
    public void defendAttack(Dragon obOther)
    {
        if(obOther instanceof Green){
            this.nHitPoints -= (int)(obOther.getAttack() * 0.8) - this.getDefense();
        }else if (obOther instanceof Red){
            this.nHitPoints -= obOther.getAttack() - this.getDefense();
        }else if (obOther instanceof White)
        {
            this.nHitPoints -= (int)(obOther.getAttack() * 1.2) - this.getDefense();
        }else{
            this.nHitPoints -= obOther.getAttack() - this.getDefense();
        }
    }

    @Override
    public String toString()
    {
        return "Red{" +
                "name='" + name + '\'' +
                "} "/* + super.toString()*/;
    }
}
