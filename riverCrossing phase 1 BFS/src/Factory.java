public class Factory {

    public static IState createState(){
        return new State();
    }

    public static INode createInitNode(){

        return new Node(new State(), null);
    }

    public static INode createChildNode(IState newSatate, INode currentNode){

        return new Node(newSatate, currentNode);
    }

    public static IChidNodeGenerator createGenerator(){

        return new ChildNodeGenerate();
    }



    public static ISearchAlgorithm createSearcher(){

        return new SearchAlgorithm();
    }
}
