public class DoubleLinkedListQueue<T> implements DoubleEndedQueue{

    private DequeNode firstNode;
    private DequeNode lastNode;

    public DoubleLinkedListQueue(){
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void append(DequeNode node) {

        if(node == null){
            throw new RuntimeException("Can't append a null node");
        }else{
            if(firstNode == null){
                firstNode = node;
            }else{
                lastNode.setNext(node);
                node.setPrevious(lastNode);
            }
            lastNode = node;
        }

    }

    @Override
    public void appendLeft(DequeNode node) {
        if(node == null){
            throw new RuntimeException("Can't appendLeft a null node");
        }else{
            if(firstNode == null){
                lastNode = node;
            }else{
                firstNode.setPrevious(node);
                node.setNext(firstNode);
            }
            firstNode = node;
        }
    }

    @Override
    public void deleteFirst() {

    }

    @Override
    public void deleteLast() {

    }

    @Override
    public DequeNode peekFirst() {
        return null;
    }

    @Override
    public DequeNode peekLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
