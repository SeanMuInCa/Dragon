package game;

import java.util.ArrayList;

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
public class GameTest
{


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
        while ((!obDragon1.isDead()) && (!obDragon2.isDead())){
            int times1 = obDragon1.getNumAttacksPerTurn();
            int times2 = obDragon2.getNumAttacksPerTurn();
            if(obDragon1.getInitiative() > obDragon2.getInitiative()){
                for(;times1>0 || times2 > 0;times1--,times2--){
                    if(times1 > 0) {
                        obDragon1.defendAttack(obDragon2);
                        System.out.println("time1");
                    }
                    if(times2 > 0) {
                        obDragon2.defendAttack(obDragon1);
                        System.out.println("time2");
                    }
                }
            }else if(obDragon1.getInitiative() < obDragon2.getInitiative()){
                for(;times1>0 || times2 > 0;times1--,times2--){
                    if(times2 > 0) {
                        obDragon2.defendAttack(obDragon1);
                        System.out.println("time2");
                    }
                    if(times1 > 0) {
                        obDragon1.defendAttack(obDragon2);
                        System.out.println("time1");
                    }
                }
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
    private void round(){

    }

}
