package DataStructures;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LinkedList {

    Node root;
    List<String> winWays = Arrays.asList(new String[]{"123","345","678","036","147","258","048","246"});
    public LinkedList()
    {
        InitializeList();
    }

    private void InitializeList()
    {
        root.setNodeNum(0);
        Node current = root;

        int num = 1;
        while(current!=null&&num<9)
        {
            if(current.getNext()==null) {
                Node newNode = new Node(num);
                current.setNext(newNode);
                num++;
            }
            current = current.getNext();
        }
    }

    private String Winner()
    {
        String PlayerX = "";
        String PlayerO = "";
        Node current = root;
        while(current!=null)
        {
            if(current.getPlayer().equals("X"))
                PlayerX += current.getNodeNum();
            else if(current.getPlayer().equals("O"))
                PlayerO += current.getNodeNum();

            current = current.getNext();
        }
        for(int i=0;i<9;i++)
        {
            if(PlayerX.contains(winWays.get(i)))
                return "X";
            if(PlayerO.contains(winWays.get(i)))
                return  "O";
        }

        return "NoWinner";
    }

    public Boolean GameOver()
    {
        Node current = root;
        while(current!=null)
        {
            if(current.getPlayer().equals(null))
                return false;

            current = current.getNext();
        }
        return  true;
    }

    public boolean PlayerTurn(String Player,int nodeNum)
    {
        Node current = root;
        int currentNodeNum = 0;
        while(current!=null)
        {
            if(currentNodeNum==nodeNum) {
                if(current.getPlayer()==null) {
                    current.setPlayer(Player);
                    return true;
                }
            }

            currentNodeNum++;

            current = current.getNext();
        }
        return false;
    }
}
