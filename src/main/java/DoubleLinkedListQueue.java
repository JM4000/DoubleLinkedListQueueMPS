public class DoubleLinkedListQueue<T> implements DoubleEndedQueue{

    private DequeNode firstNode;
    private DequeNode lastNode;
    private int size;

    public DoubleLinkedListQueue(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private void sizeUp() {
        this.size++;
    }

    private void sizeDown() {
        this.size--;
    }
    @Override
    public void append(DequeNode node) {

        if(node == null){
            throw new RuntimeException("Can't append a null node");
        }else{
            if(firstNode == null){
                firstNode = node;
            }else{
                node.setPrevious(lastNode);
                lastNode.setNext(node);
            }
            lastNode = node;
            sizeUp();
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
                node.setNext(firstNode);
                firstNode.setPrevious(node);
            }
            firstNode = node;
            sizeUp();
        }
    }

    @Override
    public void deleteFirst() {

        if(firstNode == null) {
            throw new RuntimeException("Can't delete from an empty queue");
        }else{
            if(firstNode.isLastNode()){
                firstNode = null;
                lastNode = null;
            }else{
                firstNode.getNext().setPrevious(null);
                firstNode = firstNode.getNext();
            }

            sizeDown();
        }
    }

    @Override
    public void deleteLast() {
        if(lastNode == null) {
            throw new RuntimeException("Can't delete from an empty queue");
        }else{
            if(lastNode.isFirstNode()){
                firstNode = null;
                lastNode = null;
            }else{
                lastNode.getPrevious().setNext(null);
                lastNode = lastNode.getPrevious();
            }

            sizeDown();
        }
    }

    @Override
    public DequeNode peekFirst() {
        if(firstNode == null) throw new RuntimeException("Can't peek an empty queue");
        return firstNode;
    }

    @Override
    public DequeNode peekLast() {
        if(lastNode == null) throw new RuntimeException("Can't peek an empty queue");
        return lastNode;
    }

    @Override
    public int size() {
        return size;
    }
}
