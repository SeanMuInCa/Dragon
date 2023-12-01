package game;

import java.util.ArrayList;

/**
 * Purpose:             game<br />
 * Data Submitted:      2023/11/27 <br />
 * Assignment Number:    assignment 2<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          GameTest.java <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class GameTest
{
    public static void main(String[] args)
    {
        ArrayList<Dragon> list = initDragon();//store dragon
        int[] arr = new int[list.size()];//store wins
        int rounds = list.size() - 1;
        int matchesPerRound = list.size() / 2;
        for (int i = 0; i < rounds; i++)
        {
            for (int j = 0; j < matchesPerRound; j++)
            {
                Dragon dragon = battleRound(list.get(j), list.get(list.size() - 1 - j));
                arr[list.indexOf(dragon)]++;
            }
            for (Dragon dragon : list)
            {
                dragon.resurrect();
            }
            list.add(1, list.remove(list.size() - 1));//move the last one into 2nd
        }
/*        System.out.println(list);
        System.out.println(Arrays.toString(arr));*/
        //store the index
        int[] indexes = new int[arr.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        //sort the index based on arr
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[indexes[j]] < arr[indexes[j + 1]]) {
                    int temp = indexes[j];
                    indexes[j] = indexes[j + 1];
                    indexes[j + 1] = temp;
                }
            }
        }
//put the elements into a new arraylist based on the order of the index array
        ArrayList<Dragon> result = new ArrayList<>();
        for (int index : indexes)
        {
            result.add(list.get(index));
        }
//        System.out.println(list);
        System.out.println(result);
    }

    public static ArrayList<Dragon> initDragon()
    {
        ArrayList<Dragon> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++)
        {
            //generate 4 larges
            list.add(new Red(Dragon.DragonSize.Large, "Red" + i));
            list.add(new Green(Dragon.DragonSize.Large, "Green" + i));
            list.add(new White(Dragon.DragonSize.Large, "White" + i));
            list.add(new Black(Dragon.DragonSize.Large, "Black" + i));
            //generate 4 Medium
            list.add(new Red(Dragon.DragonSize.Medium, "Red" + i));
            list.add(new Green(Dragon.DragonSize.Medium, "Green" + i));
            list.add(new White(Dragon.DragonSize.Medium, "White" + i));
            list.add(new Black(Dragon.DragonSize.Medium, "Black" + i));
            //generate 4 Small
            list.add(new Red(Dragon.DragonSize.Small, "Red" + i));
            list.add(new Green(Dragon.DragonSize.Small, "Green" + i));
            list.add(new White(Dragon.DragonSize.Small, "White" + i));
            list.add(new Black(Dragon.DragonSize.Small, "Black" + i));
        }
        return list;
    }

    public static Dragon battleRound(Dragon obDragon1, Dragon obDragon2)
    {
        while (true)
        {
            int times1 = obDragon1.getNumAttacksPerTurn();
            int times2 = obDragon2.getNumAttacksPerTurn();
            int random = Math.random() < 0.5 ? 1 : 2;
//            System.out.println(obDragon1 + " vs " + obDragon2);
            if (obDragon1.getInitiative() > obDragon2.getInitiative())
            {
                if (attack(obDragon1, obDragon2, times1, times2)) break;
            } else if (obDragon1.getInitiative() < obDragon2.getInitiative())
            {
                if (attack(obDragon1, obDragon2, times1, times2)) break;
            } else
            {
                if (random == 1)
                {
                    if (attack(obDragon1, obDragon2, times1, times2)) break;
                } else
                {
                    if (attack(obDragon2, obDragon1, times1, times2)) break;
                }
            }
        }
        return obDragon1.isDead() ? obDragon2 : obDragon1;
    }

    private static boolean attack(Dragon d1, Dragon d2, int i, int j)
    {
        for (; i > 0 || j > 0; i--, j--)
        {
            if (i > 0)
            {
                if (isHit(d1))
                {
                    d1.defendAttack(d2);
                }
                if (d1.isDead()) return true;
            }
            if (j > 0)
            {
                if (isHit(d2))
                {
                    d2.defendAttack(d1);
                }
                if (d2.isDead()) return true;
            }
        }
        return false;
    }

    public static boolean isHit(Dragon d)
    {
        switch (d.nSize)
        {
            case Small ->
            {
                return Math.random() < 0.7;
            }
            case Medium ->
            {
                return Math.random() < 0.8;
            }
            default ->
            {
                return true;
            }
        }
    }

}

/* deal with it later
class MyComparator implements Comparator<int>
{
    @Override
    public int compare(int o1, int o2)
    {
        return 0;
    }
}*/
