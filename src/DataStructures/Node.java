package DataStructures;

public class Node {
    Node Next;
    String Player;
    int NodeNum;
    int Count;

    public Node(int i)
    {
        Next =null;
        setNodeNum(i);
    }
    


    public Node getNext() {
        return Next;
    }

    public void setNext(Node Next) {
        this.Next = Next;
    }

    public String getPlayer() {
        return Player;
    }

    public void setPlayer(String player) {
        Player = player;
    }

    public int getNodeNum() {
        return NodeNum;
    }

    public void setNodeNum(int nodeNum) {
        NodeNum = nodeNum;
    }
}
