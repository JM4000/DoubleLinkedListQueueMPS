import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test cases for DoubleLinkedListQueue
 *
 * @author Juan Marcos Benítez Navone Colomer
 */

/*
* Tests:
* 1. appendOfNullListHasSameNodeAsFirstAndLast: append on an empty list should be first and last
* 2. appendLeftOfNullListHasSameNodeAsFirstAndLast: append left on an empty list should be first and last
* 3. appendInsertsAtTheEndOfList: append should insert at the end of the list
* 4. appendLeftInsertsAtTheStartOfList: append left should insert at the start of the list
* 5. appendANullObjectRaiseAnException: append of a null should raise an exception
* 6. appendLeftANullObjectRaiseAnException: append left of a null should raise an exception
* 7. sizeOfAnEmptyQueueIs0: size of an empty queue should be 0
* 8. sizeThreeElementQueueIs3: size of a 3-elements queue should be 3
* 9. deleteFirstFromAnEmptyQueueRaiseAnException: delete first on an empty queue should raise an exception
* 10. deleteFirstWorksAsExpected: delete first should work as intended
* 11. deleteFirstOnlyElementResultsInAnEmptyQueue: delete first on a 1-element queue results in an empty queue
* 12. deleteLastFromAnEmptyQueueRaiseAnException: delete last on an empty queue should raise an exception
* 13. deleteLastWorksAsExpected: delete last should work as intended
* 14. deleteLastOnlyElementResultsInAnEmptyQueue: delete last on a 1-element queue results in an empty queue
* 15. peekFirstInAnEmptyQueueRaisesException: peek first on an empty queue should raise an exception
* 16. peekLastInAnEmptyQueueRaisesException: peek last on an empty queue should raise an exception
* 17. peekFirstWorkAsExpected: peek first should work as intended
* 18. peekLastWorkAsExpected: peek last should work as intended
* */

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
    @Test
    public void getAtOf1InEmptyListRaisesException(){
        queue = null;
        assertThrows(RuntimeException.class, ()-> queue.getAt(1));
    }

    // Queue starts in index 0
    @Test
    public void getAtOf2In2SizedListRaisesException(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.append(nodeOne);
        nodeOne.setItem(Integer.valueOf(2));
        queue.append(nodeOne);

        assertThrows(RuntimeException.class, ()-> queue.getAt(2));
    }

    // Queue starts in index 0
    @Test
    public void getAtOf1In2SizedListReturnNodeTwo(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.append(nodeOne);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        queue.append(nodeTwo);

        assertEquals(nodeTwo.getItem(), queue.getAt(1).getItem());
    }

    // Queue starts in index 0
    @Test
    public void getAtOf0In2SizedListReturnNodeOne(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.append(nodeOne);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        queue.append(nodeTwo);

        assertEquals(nodeOne.getItem(), queue.getAt(0).getItem());
    }

    @Test
    public void findNodeOneWhenContainedInQueue(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.append(nodeOne);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        queue.append(nodeTwo);

        assertEquals(nodeOne.getItem(), queue.find(nodeOne).getItem());
    }

    @Test
    public void findNodeThreeWhenNotContainedInQueueRaiseException(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.append(nodeOne);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        queue.append(nodeTwo);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(3), null, null);

        assertThrows(RuntimeException.class, ()-> queue.find(nodeThree));
    }

    @Test
    public void findNodeThreeWhenNullRaiseException(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        queue.append(nodeOne);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        queue.append(nodeTwo);
        DequeNode nodeThree = null;

        assertThrows(RuntimeException.class, ()-> queue.find(nodeThree));
    }

    @Test
    public void isSortedWorkAsExpected(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(3), null, null);

        queue.append(nodeOne);
        queue.append(nodeTwo);
        queue.append(nodeThree);

        boolean expextedValue = true;
        boolean actualValue = isSorted((DoubleLinkedListQueue<?>) queue);
    }

    private boolean isSorted(DoubleLinkedListQueue<?> list){
        Comparator<Integer> comparator = Comparator.naturalOrder();
        return list.isSorted(comparator);
    }
}
