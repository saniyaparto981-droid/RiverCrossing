import java.util.LinkedList;

public class SearchAlgorithm implements ISearchAlgorithm{

    private LinkedList<INode> unexpandedNodes = new LinkedList<>();
    private LinkedList<INode> expandedNodes = new LinkedList<>();
    private INode starterNode;
    private IChidNodeGenerator generator;

    //---Constructor------------------------------------
    public SearchAlgorithm(){

        starterNode = Factory.createInitNode();
        generator = Factory.createGenerator();
    }

    //----------------------------------------------------
    @Override
    public boolean isValid(INode node) {

        boolean momPosition = node.getState().getPositions()[Entity.Mother.getIndex()];
        boolean dadPosition = node.getState().getPositions()[Entity.Father.getIndex()];
        boolean daughter1Position = node.getState().getPositions()[Entity.Daughter1.getIndex()];
        boolean daughter2Position = node.getState().getPositions()[Entity.Daughter2.getIndex()];
        boolean son1Position = node.getState().getPositions()[Entity.Son1.getIndex()];
        boolean son2Position = node.getState().getPositions()[Entity.Son2.getIndex()];

        if (((momPosition == son1Position) || (momPosition == son2Position)) &&
             (momPosition != dadPosition))
                return false;

        if (((dadPosition == daughter1Position) || (dadPosition == daughter2Position)) &&
             (dadPosition != momPosition) )
                return false;

        return true;
    }

    @Override
    public INode search() {

        unexpandedNodes.addLast(starterNode);

        INode target = null;

        while(!unexpandedNodes.isEmpty()){

            target = unexpandedNodes.getLast();

            unexpandedNodes.removeLast();

            boolean toContinue = false;

            for (INode node : expandedNodes){

                if (target.equals(node)){
                    toContinue = true;
                    break;
                }

            }

            if (toContinue || !isValid(target))
                continue;

            if (isGoal(target))
                break;

            expandedNodes.addLast(target);

            unexpandedNodes.addAll(generator.generate(target));
        }

        return target;
    }

    private boolean isGoal(INode node){

        boolean[] positions = node.getState().getPositions().clone();

        for (boolean position : positions)
            if (!position) return false;

        return true;
    }
}
