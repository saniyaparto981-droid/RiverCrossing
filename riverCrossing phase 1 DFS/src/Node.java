public class Node implements INode{

    IState state;
    INode motherNode;

    //---Constructor--------------------------------------------
    public Node(IState state, INode motherNode){

        this.state = state;
        this.motherNode = motherNode;
    }

    //-----------------------------------------------------------
    @Override
    public IState getState() {

        return state;
    }

    @Override
    public void setState(Entity[] entities) {

        for (Entity e : entities)
            state.moveEntity(e);
    }

    @Override
    public INode clone(){

        IState copy = Factory.createState();

        for (Entity e : Entity.values())
            copy.getPositions()[e.getIndex()] = state.getPositions()[e.getIndex()];

        return Factory.createChildNode(copy, this);
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        INode other = (INode) obj;

        if(state.toNumber()!=other.getState().toNumber()) return false;

        return true;
    }

    @Override
    public int hashCode(){
        return state.toNumber();
    }

    @Override
    public INode getMotherNode() {

        return motherNode;
    }

    @Override
    public String toString(){


        String state = "";

        state += "Region 1: \n";
        for (Entity e : Entity.values()){
            if(!this.state.getPositions()[e.getIndex()] && !(e.getIndex() == 6))
                state += "              " + e + "\n";

        }

        state += "\nRegion 2: \n";
        for (Entity e : Entity.values()){
            if(this.state.getPositions()[e.getIndex()] && !(e.getIndex() == 6))
                state += "              " + e + "\n";

        }


        if (!this.state.getPositions()[Entity.Boat.getIndex()]) {
            state += "\nBoat location ---> " + "    Region 1";
        }
        else {
            state += "\nBoat location ---> " + "    Region 2";
        }

        return state;
    }

}