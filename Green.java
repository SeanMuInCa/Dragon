package game;

/**
 * Purpose:             game<br />
 * Data Submitted:      2023/11/27 <br />
 * Assignment Number:    assignment 2<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Green.java <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Green extends Dragon
{
        public String name;
        public Green(DragonSize nSize, String name)
        {
            super(nSize);
            this.name = nSize + name;
        }

        @Override
        public void defendAttack(Dragon obOther)
        {
            if(obOther instanceof Red){
                this.nHitPoints -= (int)(obOther.getAttack() * 1.2) - this.getDefense();
                System.out.println(this.name + " vs red"+"我的血量"+this.getHitPoints() + "对手血量"+obOther.getHitPoints());
            }else if (obOther instanceof Green){
                this.nHitPoints -= obOther.getAttack() - this.getDefense();
                System.out.println(this.name + " vs Green");
            }else if (obOther instanceof White)
            {
                this.nHitPoints -= (int)(obOther.getAttack() * 0.9) - this.getDefense();
                System.out.println(this.name + " vs White");
            }else{
                this.nHitPoints -= obOther.getAttack() - this.getDefense();
                System.out.println(this.name + " vs Black");
            }
        }

    @Override
    public String toString()
    {
        return "Green{" +
                "name='" + name + '\'' +
                "} " /*+ super.toString()*/;
    }
}
