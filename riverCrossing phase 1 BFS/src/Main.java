public class Main{

    public static int transferIndex = 1;

    public static void main(String[] args){

        ISearchAlgorithm searcher = Factory.createSearcher();
        INode result = searcher.search();

        showPath(result);
    }

    public static void show(INode node){

        INodePrinter printer = Factory.createPrinter();


        System.out.println("**************************************");
        System.out.println("Tranfer index: " + transferIndex);
        System.out.println(printer.toString(node));

        transferIndex++;
    }

    public static void showPath(INode node){

        if (node == null) return;
        showPath(node.getMotherNode());
        show(node);

    }
}