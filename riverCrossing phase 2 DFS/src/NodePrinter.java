public class NodePrinter implements INodePrinter{

    public String toString(INode node){

        String state = "";

        state += "Region 1: \n";
        for (Entity e : Entity.values()){
            if(!node.getState().getPositions()[e.getIndex()] && !(e.getIndex() == 6))
                state += "              " + e + "\n";

        }

        state += "\nRegion 2: \n";
        for (Entity e : Entity.values()){
            if(node.getState().getPositions()[e.getIndex()] && !(e.getIndex() == 6))
                state += "              " + e + "\n";

        }


        if (!node.getState().getPositions()[Entity.Boat.getIndex()]) {
            state += "\nBoat location ---> " + "    Region 1";
        }
        else {
            state += "\nBoat location ---> " + "    Region 2";
        }

        return state;
    }


}
