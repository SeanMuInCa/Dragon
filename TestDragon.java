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
public class TestDragon
{
    public static void main(String[] args)
    {
        ArrayList<Dragon> list = GameTest.initDragon();
        System.out.println(GameTest.battleRound(list.get(9), list.get(0)));
    }
}
