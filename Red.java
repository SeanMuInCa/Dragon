package game;

/**
 * Purpose:             game<br />
 * Data Submitted:      2023/11/27 <br />
 * Assignment Number:    game<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          game <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Red extends Dragon
{
    public static int counter = 0;
    public String name;
    public Red(DragonSize nSize, String name)
    {
        super(nSize);
        counter++;
        this.name = nSize + name + counter;
    }

    @Override
    public void defendAttack(Dragon obOther)
    {
        if(obOther instanceof Green){
            obOther.nHitPoints -= (int)(this.getAttack() * 0.8) - obOther.getDefense();
        }else if (obOther instanceof Red){
            obOther.nHitPoints -= this.getAttack() - obOther.getDefense();
        }else if (obOther instanceof White)
        {
            obOther.nHitPoints -= (int)(this.getAttack() * 1.2) - obOther.getDefense();
        }else{
            obOther.nHitPoints -= this.getAttack() - obOther.getDefense();
        }
    }

    @Override
    public String toString()
    {
        return "Red{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
