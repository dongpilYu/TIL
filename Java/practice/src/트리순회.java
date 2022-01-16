import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리순회 {
    public static void main(String[] args) throws IOException {

        CompleteBinaryTree cbt = new CompleteBinaryTree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();


        for(char ch : input){

            Node node = new Node(ch);
            cbt.insertNode(node);
        }

        cbt.postOrder(cbt.getRoot());

    }
}


class Node { //트리의 노드 정보를 저장할 클래스 구조체
    private char data; //노드 값
    private Node left; //왼쪽 자식 노드 참조 값
    private Node right; //오른쪽 자식 노드 참조 값

    Node(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public char getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class CompleteBinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insertNode(Node newNode) {

        if (root == null) {
            root = newNode;
        } else {
            searchAndInsert(newNode, root);
        }

    }

    private Boolean searchAndInsert(Node newNode, Node next){

        Queue<Node> queue = new LinkedList<>();
        queue.add(next);

        while(!queue.isEmpty()){

            Node node = queue.poll();

            if(node.getLeft() == null){
                node.setLeft(newNode);
                break;
            }else{
                if(node.getRight() == null) {
                    node.setRight(newNode);
                    break;
                }
            }
            // left, right 모두 널이 아님

            queue.add(node.getLeft());
            queue.add(node.getRight());

        }

        return true;
    }

    //전위순회 Preorder : Root -> Left -> Right
    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.getData() + " ");
            if(node.getLeft() != null) preOrder(node.getLeft());
            if(node.getRight() != null) preOrder(node.getRight());
        }
    }

    //중위 순회 Inorder : Left -> Root -> Right
    public void inOrder(Node node) {
        if(node != null) {
            if(node.getLeft() != null) inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            if(node.getRight() != null) inOrder(node.getRight());
        }
    }

    //후위순회 Postorder : Left -> Right -> Root
    public void postOrder(Node node) {
        if(node != null) {
            if(node.getLeft() != null) postOrder(node.getLeft());
            if(node.getRight() != null) postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

}