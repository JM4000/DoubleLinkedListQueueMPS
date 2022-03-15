import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test cases for DoubleLinkedListQueue
 *
 * @author Juan Marcos Benítez Navone Colomer
 */


public class DoubleLinkedListQueueTest {

    private DoubleEndedQueue queue;

    @BeforeEach
    public void init(){
        queue = new DoubleLinkedListQueue();
    }
    @AfterEach
    public void after() {
        queue = null;
    }

    @Test
    public void appendOfNullListHasSameNodeAsFirstAndLast(){

        DequeNode node = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.append(node);

        assert(node.isFirstNode());
        assert(node.isLastNode());
    }

    @Test
    public void appendLeftOfNullListHasSameNodeAsFirstAndLast(){

        DequeNode node = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.appendLeft(node);

        assert(node.isFirstNode());
        assert(node.isLastNode());
    }

    @Test
    public void appendInsertsAtTheEndOfList(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(nodeOne);
        queue.append(nodeTwo);

        assert(nodeOne.isFirstNode());
        assert(!nodeOne.isLastNode());
        assert(nodeTwo.isLastNode());
        assert(!nodeTwo.isFirstNode());
    }

    @Test
    public void appendLeftInsertsAtTheStartOfList(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.appendLeft(nodeOne);
        queue.appendLeft(nodeTwo);

        assert(nodeOne.isLastNode());
        assert(!nodeOne.isFirstNode());
        assert(nodeTwo.isFirstNode());
        assert(!nodeTwo.isLastNode());
    }

    @Test
    public void appendANullObjectRaiseAnException(){
        DequeNode node = null;
        assertThrows(RuntimeException.class, () -> queue.append(node));
    }

    @Test
    public void appendLeftANullObjectRaiseAnException(){
        DequeNode node = null;
        assertThrows(RuntimeException.class, () -> queue.appendLeft(node));
    }

}
