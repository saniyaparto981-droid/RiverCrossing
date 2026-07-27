import java.util.List;

public interface INode {

    INode clone();

    boolean equals(Object obj);

    INode getMotherNode();

    IState getState();

    void setState(Entity[] entities);
}