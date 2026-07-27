public class NodePrinter implements INodePrinter{

    public String toString(INode node){

        boolean[] states = node.getState().getPositions().clone();
        String state = "";


        for (Entity e : Entity.values()){
            if(states[e.getIndex()])
                state += e + " : right\n";
            else
                state += e + " : left\n";
        }

        return state;
    }
}
