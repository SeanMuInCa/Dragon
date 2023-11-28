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
public abstract class Dragon
{
    private int nAttackRank;
    private int nDefenseRank;
    public int nHitPoints;
    private int nInitiative;
    public  DragonSize nSize;
    private int originalHitPoints;

    public enum DragonSize
    {
        Large,
        Medium,
        Small
    }

    public Dragon(DragonSize nSize)
    {
        this.nSize = nSize;
        switch (nSize)
        {
            case Large ->
            {
                this.nHitPoints = getRandomNumber(86, 100);
                this.nInitiative = getRandomNumber(0, 10);
                this.nAttackRank = getRandomNumber(61, 70);
                this.nDefenseRank = getRandomNumber(29, 35);
            }
            case Medium ->
            {
                this.nHitPoints = getRandomNumber(71, 85);
                this.nInitiative = getRandomNumber(20, 40);
                this.nAttackRank = getRandomNumber(51, 60);
                this.nDefenseRank = getRandomNumber(20, 29);
            }
            case Small ->
            {
                this.nHitPoints = getRandomNumber(51, 70);
                this.nInitiative = getRandomNumber(40, 60);
                this.nAttackRank = getRandomNumber(36, 50);
                this.nDefenseRank = getRandomNumber(10, 19);
            }
        }
        originalHitPoints = this.nHitPoints;
    }

    private static int getRandomNumber(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public int getAttack()
    {
        return nAttackRank;
    }

    public int getDefense()
    {
        return nDefenseRank;
    }

    public int getNumAttacksPerTurn()
    {
        switch (this.nSize)
        {
            case Large ->
            {
                return 1;
            }
            case Medium ->
            {
                return 2;
            }
            default ->
            {
                return 3;
            }
        }
    }

    public int getInitiative()
    {
        return nInitiative;
    }

    public boolean isDead()
    {
        return this.nHitPoints <= 0;
    }
    public void resurrect(){
        this.nHitPoints = originalHitPoints;
    }

    public void setHitPoints(int nHitPoints)
    {
        this.nHitPoints = nHitPoints;
    }

    public int getHitPoints()
    {
        return nHitPoints;
    }

    @Override
    public String toString()
    {
        return "Dragon{" +
                "nAttackRank=" + nAttackRank +
                ", nDefenseRank=" + nDefenseRank +
                ", nHitPoints=" + nHitPoints +
                ", nInitiative=" + nInitiative +
                ", nSize=" + nSize +
                '}';
    }
    public abstract void defendAttack(Dragon obOther);
}
