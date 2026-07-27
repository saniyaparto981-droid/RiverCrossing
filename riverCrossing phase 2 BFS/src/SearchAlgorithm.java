import java.util.HashSet;
import java.util.LinkedList;

public class SearchAlgorithm implements ISearchAlgorithm{

    private LinkedList<INode> unexpandedNodes = new LinkedList();
    private LinkedList<Integer> expandedNodes = new LinkedList();
    private INode starterNode;
    private IChidNodeGenerator generator;
    private final int truthNumber;

    //---Constructor------------------------------------
    public SearchAlgorithm(){

        starterNode = Factory.createInitNode();
        generator = Factory.createGenerator();
        truthNumber = starterNode.getState().stateGoalNumber();
    }

    //----------------------------------------------------
    @Override
    public boolean isValid(INode node) {

        boolean momPosition = node.getState().getPositions()[Entity.Mother.getIndex()];
        boolean dadPosition = node.getState().getPositions()[Entity.Father.getIndex()];
        boolean daughter1Position = node.getState().getPositions()[Entity.Girl1.getIndex()];
        boolean daughter2Position = node.getState().getPositions()[Entity.Girl2.getIndex()];
        boolean son1Position = node.getState().getPositions()[Entity.Boy1.getIndex()];
        boolean son2Position = node.getState().getPositions()[Entity.Boy2.getIndex()];
        boolean thiefPosition=node.getState().getPositions()[Entity.Thief.getIndex()];
        boolean policePosition=node.getState().getPositions()[Entity.Police.getIndex()];

        if (((momPosition == son1Position) || (momPosition == son2Position)) &&
                (momPosition != dadPosition))
            return false;

        if (((dadPosition == daughter1Position) || (dadPosition == daughter2Position)) &&
                (dadPosition != momPosition))
            return false;

        if ((policePosition != thiefPosition) && ((thiefPosition == momPosition) ||
            (thiefPosition == dadPosition) || (thiefPosition == son1Position) ||
            (thiefPosition == son2Position) || (thiefPosition == daughter1Position) ||
            (thiefPosition == daughter2Position)))
                return false;

        return true;
    }

    @Override
    public INode search() {

        unexpandedNodes.addFirst(starterNode);

        INode target = null;

        while(!unexpandedNodes.isEmpty()){


            target=unexpandedNodes.getFirst();
            unexpandedNodes.removeFirst();

            if(expandedNodes.contains(target.hashCode())) continue;

            expandedNodes.add(target.hashCode());

            if (!isValid(target))
                continue;

            if (target.getState().toNumber()==truthNumber)
                break;

            unexpandedNodes.addAll(generator.generate(target));
        }

        return target;
    }

   // private boolean isGoal(INode node){

       // boolean[] positions = node.getState().getPositions().clone();

        //for (boolean position : positions)
          //  if (!position) return false;

       // return true;
   // }
}
