import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static int transferIndex = 1;

    public static void main(String[] args){

        ISearchAlgorithm searcher = Factory.createSearcher();
        INode result = searcher.search();

        try {

            File file = new File("beauty.txt");
            System.out.println(file.getAbsolutePath());

            FileWriter writer = new FileWriter(file);

            writer.write("the beautiful program regarding nature and river\n\n");

            writer.write(showPath(result));

            writer.close();

            System.out.println("the mission done");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String show(INode node){


        String s = "";

        s += "**************************************\n";
        s += "Transfer index: " + transferIndex + "\n";
        s +=node.toString() + "\n";

        transferIndex++;

        return s;
    }

    public static String showPath(INode node){

        String s = "";
        if (node == null) return "";

        s += showPath(node.getMotherNode());
        s += show(node);

        return s;

    }
}