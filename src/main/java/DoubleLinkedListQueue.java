import java.util.Comparator;
import java.util.Deque;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue {

    private DequeNode firstNode;
    private DequeNode lastNode;
    private int size;

    public DoubleLinkedListQueue() {
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

        if (node == null) {
            throw new RuntimeException("Can't append a null node");
        } else {
            if (firstNode == null) {
                firstNode = node;
            } else {
                node.setPrevious(lastNode);
                lastNode.setNext(node);
            }
            lastNode = node;
            sizeUp();
        }
    }

    @Override
    public void appendLeft(DequeNode node) {
        if (node == null) {
            throw new RuntimeException("Can't appendLeft a null node");
        } else {
            if (firstNode == null) {
                lastNode = node;
            } else {
                node.setNext(firstNode);
                firstNode.setPrevious(node);
            }
            firstNode = node;
            sizeUp();
        }
    }

    @Override
    public void deleteFirst() {

        if (firstNode == null) {
            throw new RuntimeException("Can't delete from an empty queue");
        } else {
            if (firstNode.isLastNode()) {
                firstNode = null;
                lastNode = null;
            } else {
                firstNode.getNext().setPrevious(null);
                firstNode = firstNode.getNext();
            }

            sizeDown();
        }
    }

    @Override
    public void deleteLast() {
        if (lastNode == null) {
            throw new RuntimeException("Can't delete from an empty queue");
        } else {
            if (lastNode.isFirstNode()) {
                firstNode = null;
                lastNode = null;
            } else {
                lastNode.getPrevious().setNext(null);
                lastNode = lastNode.getPrevious();
            }

            sizeDown();
        }
    }

    @Override
    public DequeNode peekFirst() {
        if (firstNode == null) throw new RuntimeException("Can't peek an empty queue");
        return firstNode;
    }

    @Override
    public DequeNode peekLast() {
        if (lastNode == null) throw new RuntimeException("Can't peek an empty queue");
        return lastNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DequeNode getAt(int position) {
        if (position >= this.size || position < 0) {
            throw new RuntimeException("Position " + position + " out of bounds");
        }

        DequeNode iterationNode = firstNode;
        for (int i = 0; i < position; i++) {
            iterationNode = iterationNode.getNext();
        }

        return iterationNode;
    }

    @Override
    public DequeNode find(Object item) {
        if (item == null) {
            throw new RuntimeException("Cannot find a null item");
        }

        DequeNode findableNode = (DequeNode) item;
        DequeNode iterationNode = firstNode;
        boolean found = false;
        while (iterationNode != null && !found) {
            if (findableNode.getItem() == iterationNode.getItem()) {
                found = true;
            } else {
                iterationNode = iterationNode.getNext();
            }

        }

        if (iterationNode == null) {
            throw new RuntimeException("Item not found");
        }

        return iterationNode;
    }

    @Override
    public void delete(DequeNode node) {
        if (node == null) throw new RuntimeException("Can't delete a null node");
        if (size == 1) {
            firstNode = null;
            lastNode = null;
            size = 0;
        } else {
            if (node.isFirstNode()) {
                node.getNext().setPrevious(null);
                firstNode = node.getNext();
            } else if (node.isLastNode()) {
                node.getPrevious().setNext(null);
                lastNode = node.getPrevious();
            } else {
                node.getNext().setPrevious(node.getPrevious());
                node.getPrevious().setNext(node.getNext());
            }
            node.setNext(null);
            node.setPrevious(null);
            node = null;
            size--;
        }
    }

    @Override
    public void sort(Comparator comparator) {

        if (firstNode == null) {
            throw new RuntimeException("Can't sort an empty List");
        } else if (firstNode != lastNode) {

            DoubleLinkedListQueue dummy = new DoubleLinkedListQueue();

            int initialSize = size;
            for(int i = 0; i<initialSize; i++){
                dummy.append(minimal(comparator));
            }

            firstNode = dummy.peekFirst();
            lastNode = dummy.peekLast();
            size = dummy.size();

        }
    }

    private DequeNode minimal(Comparator comparator) {
        DequeNode solution = firstNode;
        DequeNode compared = solution.getNext();

        while(compared != null){
            if(comparator.compare(solution.getItem(), compared.getItem())>0 ){
                solution = new DequeNode<>(compared.getItem(), null, null);
            }
            compared = compared.getNext();
        }
        delete(find(solution));
        return solution;
    }

}
