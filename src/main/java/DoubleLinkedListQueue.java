import java.util.Comparator;

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

    @Override
    public DequeNode getAt(int position) {
        if (position >= this.size){
            throw new RuntimeException("Position of getAt out of bounds");
        }

        DequeNode iterationNode = firstNode;
        for (int i = 0; i < position; i++){
            iterationNode = iterationNode.getNext();
        }

        return iterationNode;
    }

    @Override
    public DequeNode find(Object item) {
        if (item == null){
            throw new RuntimeException("Cannot find a null item");
        }

        DequeNode findableNode = (DequeNode) item;
        DequeNode iterationNode = firstNode;
        boolean found = false;
        while(iterationNode != null && !found){
            if (findableNode.getItem() == iterationNode.getItem()){
                found = true;
            } else {
                iterationNode = iterationNode.getNext();
            }

        }

        if (iterationNode == null){
            throw new RuntimeException("Item not found");
        }

        return iterationNode;
    }

    @Override
    public void delete(DequeNode node) {

    }

    @Override
    public void sort(Comparator comparator) {

        if(firstNode == null){
            throw new RuntimeException("Can't sort an empty List");
        }else if(firstNode != lastNode) {
            boolean isSorted = isSorted(comparator);
            int n = size;
            for (int i = 0; i < n-1; i++)
            {
                int min_idx = i;
                for (int j = i+1; j < n; j++){
                    if (comparator.compare(getAt(j).getItem(), getAt(min_idx).getItem())<0) {
                        min_idx = j;
                    }
                    change(getAt(i),getAt(min_idx));
                }
            }
        }
    }

    private void change(DequeNode original, DequeNode changed) {
        DequeNode temp = changed;

        changed.setNext(original.getNext());
        changed.setPrevious(original.getPrevious());

        original.setNext(temp.getNext());
        original.setPrevious(temp.getPrevious());
    }

    public boolean isSorted(Comparator comparator) {

        boolean sol = true;
        var nodeOne = this.firstNode;
        var nodeTwo = nodeOne.getNext();

        while (sol && nodeTwo != null){
            if(comparator.compare(nodeOne.getItem(),nodeTwo.getItem())>0){
                sol = false;
            }
            nodeOne = nodeTwo;
            nodeTwo = nodeTwo.getNext();
        }

        return sol;
    }
}
