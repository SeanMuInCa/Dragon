package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
        ArrayList<Dragon> list = initDragon();
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int j = 0; j < list.size() / 2; j++)
            {
                Dragon dragon = battleRound(list.get(j),list.get(list.size() - 1 - j));
                arr[list.indexOf(dragon)]++;
            }
            for (int k = 0; k <list.size(); k++){
                list.get(k).resurrect();
            }
        }
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }
    public static ArrayList<Dragon> initDragon()
    {
        ArrayList<Dragon> list = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            //generate 4 larges
            list.add(new Red(Dragon.DragonSize.Large, "Red"));
            list.add(new Green(Dragon.DragonSize.Large, "Green"));
            list.add(new White(Dragon.DragonSize.Large, "White"));
            list.add(new Black(Dragon.DragonSize.Large, "Black"));
            //generate 4 Medium
            list.add(new Red(Dragon.DragonSize.Medium, "Red"));
            list.add(new Green(Dragon.DragonSize.Medium, "Green"));
            list.add(new White(Dragon.DragonSize.Medium, "White"));
            list.add(new Black(Dragon.DragonSize.Medium, "Black"));
            //generate 4 Small
            list.add(new Red(Dragon.DragonSize.Small, "Red"));
            list.add(new Green(Dragon.DragonSize.Small, "Green"));
            list.add(new White(Dragon.DragonSize.Small, "White"));
            list.add(new Black(Dragon.DragonSize.Small, "Black"));
        }
        return list;
    }

    public static Dragon battleRound(Dragon obDragon1, Dragon obDragon2)
    {
        while (true){
            int times1 = obDragon1.getNumAttacksPerTurn();
            int times2 = obDragon2.getNumAttacksPerTurn();
            if(obDragon1.getInitiative() > obDragon2.getInitiative()){
                for(;times1>0 || times2 > 0;times1--,times2--){
                    if(!attack(obDragon1,obDragon2,times1,times2)) break;
                }
                if(obDragon1.isDead() || obDragon2.isDead()) break;
            }else if(obDragon1.getInitiative() <= obDragon2.getInitiative()){
                for(;times1>0 || times2 > 0;times1--,times2--){
                    if(!attack(obDragon1,obDragon2,times1,times2)) break;
                }
                if(obDragon1.isDead() || obDragon2.isDead()) break;
            }else{
                int random = Math.random() < 0.5 ? 1 : 2;
                if (random == 1) {
                    System.out.println("随机选择处理对象1");
                } else {
                    System.out.println("随机选择处理对象2");
                }
            }
        }
        return obDragon1.isDead() ? obDragon2 : obDragon1;
    }
    private static boolean attack(Dragon d1, Dragon d2, int i, int j){
        for(;i>0 || j > 0;i--,j--)
        {
            if (i > 0)
            {
                if(isHit(d1)){
                    d1.defendAttack(d2);
                    System.out.println("time1");
                }
                if (d2.isDead()) return false;
            }
            if(j > 0) {
                if(isHit(d2)){
                    d2.defendAttack(d1);
                    System.out.println("time2");
                }
                if(d1.isDead()) return false;
            }
        }
        return true;
    }
    public static boolean isHit(Dragon d){
        switch (d.nSize){
            case Small ->
            {
                return Math.random() < 0.7;
            }
            case Medium -> {
                return Math.random() < 0.8;
            }
            default ->
            {
                return true;
            }
        }
    }

}

class MyComparator implements Comparator<int>
{
    @Override
    public int compare(int o1, int o2)
    {
        return 0;
    }
}