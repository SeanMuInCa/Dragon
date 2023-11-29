package game;

/**
 * Purpose:             game<br />
 * Data Submitted:      2023/11/27 <br />
 * Assignment Number:    assignment 2<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Black.java <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Black extends Dragon
{

    public String name;
    public Black(Dragon.DragonSize nSize, String name)
    {
        super(nSize);
        this.name = nSize + name;
    }

    @Override
    public void defendAttack(Dragon obOther)
    {
        if(obOther instanceof Red){
            this.nHitPoints -= obOther.getAttack() - this.getDefense();
        }else if (obOther instanceof Green){
            this.nHitPoints -= obOther.getAttack() - this.getDefense();
        }else if (obOther instanceof White)
        {
            this.nHitPoints -= (int)(obOther.getAttack() * 0.75) - this.getDefense();
        }else{
            this.nHitPoints -= obOther.getAttack() - this.getDefense();
        }
    }

    @Override
    public String toString()
    {
        return "Black{" +
                "name='" + name + '\'' +
                "} " /*+ super.toString()*/;
    }
}
