package com.company;

import java.util.Scanner;



public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Player[] player = new Player[4];
        for (int i = 0; i < player.length; i++)
        {
            int playerId = sc.nextInt();
            sc.nextLine();
            String playerName = sc.nextLine();
            int runs = sc.nextInt();
            sc.nextLine();
            String playerType = sc.nextLine();
            String matchType = sc.nextLine();
            player[i] = new Player(playerId, playerName, runs, playerType, matchType);
        }
        String pt = sc.nextLine();
        String mt = sc.nextLine();
        int ans = findPlayerWithLowestRuns(player, pt);
        if(ans == 0)
        {
            System.out.println("No such player");
        }
        else
        {
            System.out.println(ans);
        }

        Player[] playerArray = getPlayersByMatchType(player, mt);
        if(playerArray == null)
        {
            System.out.println("No player with given match Type");
        }
        else
        {
            for (int i = 0; i < playerArray.length; i++)
            {
                System.out.println(playerArray[i].getPlayerId());
            }
        }

    }


    public static int findPlayerWithLowestRuns(Player[] player, String pt)
    {
        Player[] p=new Player[4];

        int c = 0;
        for (int i = 0; i < player.length; i++)
        {
            if (player[i].getPlayerType().equals(pt))
            {
                p[c] = player[i];
                c++;
            }
        }
        if(c==0)
            return c;
        int min = p[0].getRuns(); //Integer.MAX_VALUE;
        for (int i = 0; i < c; i++)
        {
            if (p[i].getRuns() < min)
            {
                min = p[i].getRuns();
            }
        }
        return min;
    }

    public static Player[] getPlayersByMatchType(Player[] player, String mt)
    {
        Player[] playerArray = new Player[player.length];
        int count = 0;
        for (int i = 0; i < player.length; i++)
        {
            if (player[i].getMatchType().equals(mt))
            {
                playerArray[count] = player[i];
                count++;
            }
        }
        if(count == 0)
        {
            return null;
        }

        else
        {
            Player[] playerArray1 = new Player[count];
            for (int i = 0; i < count; i++)
            {
                playerArray1[i] = playerArray[i];
            }
            for (int i = 0; i < count; i++)
            {
                for (int j = i + 1; j < count; j++)
                {
                    if (playerArray1[i].getPlayerId() < playerArray1[j].getPlayerId())
                    {
                        Player temp = playerArray1[i];
                        playerArray1[i] = playerArray1[j];
                        playerArray1[j] = temp;
                    }
                }
            }
            return playerArray1;
        }
    }



}

class Player
{
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getRuns() {
        return runs;
    }

    public String getPlayerType() {
        return playerType;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

}
