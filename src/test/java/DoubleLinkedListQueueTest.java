import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void sizeOfAnEmptyQueueIs0(){
        int expectedValue = 0;
        int actualValue = queue.size();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sizeThreeElementQueueIs3(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(nodeOne);
        queue.append(nodeTwo);
        queue.append(nodeThree);

        int expectedValue = 3;
        int actualValue = queue.size();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void deleteFirstFromAnEmptyQueueRaiseAnException(){
        assertThrows(RuntimeException.class, () -> queue.deleteFirst());
    }

    @Test
    public void deleteFirstWorksAsExpected(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode expectedValue = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(nodeOne);
        queue.append(expectedValue);
        queue.append(nodeThree);

        queue.deleteFirst();

        assert(expectedValue.isFirstNode());
    }

    @Test
    public void deleteFirstOnlyElementResultsInAnEmptyQueue(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(nodeOne);

        queue.deleteFirst();

        assert(queue.size() == 0);
    }

    @Test
    public void deleteLastFromAnEmptyQueueRaiseAnException(){
        assertThrows(RuntimeException.class, () -> queue.deleteLast());
    }

    @Test
    public void deleteLastWorksAsExpected(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode expectedValue = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(nodeOne);
        queue.append(expectedValue);
        queue.append(nodeThree);

        queue.deleteLast();

        assert(expectedValue.isLastNode());
    }

    @Test
    public void deleteLastOnlyElementResultsInAnEmptyQueue(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(nodeOne);

        queue.deleteLast();

        assert(queue.size() == 0);
    }

    @Test
    public void peekFirstInAnEmptyQueueRaisesException(){
        assertThrows(RuntimeException.class, () -> queue.peekFirst());
    }

    @Test
    public void peekLastInAnEmptyQueueRaisesException(){
        assertThrows(RuntimeException.class, () -> queue.peekLast());
    }

    @Test
    public void peekFirstWorkAsExpected(){
        DequeNode expectedValue = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(expectedValue);
        queue.append(nodeTwo);

        DequeNode actualValue = queue.peekFirst();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void peekLastWorkAsExpected(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode expectedValue = new DequeNode<Integer>(Integer.valueOf(1), null, null);

        queue.append(nodeOne);
        queue.append(expectedValue);

        DequeNode actualValue = queue.peekLast();

        assertEquals(expectedValue, actualValue);
    }
}
