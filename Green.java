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
public class Green extends Dragon
{
        public static int counter = 0;
        public String name;
        public Green(DragonSize nSize, String name)
        {
            super(nSize);
            counter++;
            this.name = nSize + name + counter;
        }

        @Override
        public void defendAttack(Dragon obOther)
        {
            if(obOther instanceof Red){
                obOther.nHitPoints -= (int)(this.getAttack() * 1.2) - obOther.getDefense();
                System.out.println(this.name + " vs red");
            }else if (obOther instanceof Green){
                obOther.nHitPoints -= this.getAttack() - obOther.getDefense();
                System.out.println(this.name + " vs Green");
            }else if (obOther instanceof White)
            {
                obOther.nHitPoints -= (int)(this.getAttack() * 0.9) - obOther.getDefense();
                System.out.println(this.name + " vs White");
            }else{
                obOther.nHitPoints -= this.getAttack() - obOther.getDefense();
                System.out.println(this.name + " vs Black");
            }
        }

    @Override
    public String toString()
    {
        return "Green{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
