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


    private int changeNumber(Entity e)
    {
        if(positions[e.getIndex()])
            return (int )Math.pow(2,e.getIndex());

        return 0;
    }

    @Override
    public int stateGoalNumber() {

        int number = 0;
        for (int i = 0; i < positions.length; i++)
            number += (int) Math.pow(2, i);

        return number;

    }

    @Override
    public int toNumber() {

        int number = 0;

        for(Entity e: Entity.values())
            number += changeNumber(e);

        return number;
    }


}
