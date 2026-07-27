import java.util.Arrays;

public class State implements IState{

    boolean[] positions;

    //---constructor-----------------------------
    public State(){

        positions = new boolean[Entity.values().length];
        Arrays.fill(positions, false);
    }

    @Override
    public void moveEntity(Entity e) {

        positions[e.getIndex()] = !positions[e.getIndex()];
    }

    @Override
    public boolean[] getPositions() {

        return positions;
    }

}