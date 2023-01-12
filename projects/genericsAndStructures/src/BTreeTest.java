import entities.ChemElement;
import enums.Traversal;
import structures.GenericBinTree;

public class BTreeTest {
    public static void main(String[] args) {
        GenericBinTree<String> stringsTree = new GenericBinTree<>(Traversal.INORDER);
        GenericBinTree<ChemElement> elementsTree = new GenericBinTree<>(Traversal.INORDER);

        elementsTree.insert(new ChemElement());
        elementsTree.insert(new ChemElement());
        elementsTree.insert(new ChemElement());
        elementsTree.insert(new ChemElement());
        elementsTree.insert(new ChemElement());
        elementsTree.insert(new ChemElement());

        System.out.println(elementsTree);

    }
}