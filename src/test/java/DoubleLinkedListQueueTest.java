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
 * @author Agustín Romero Ladrón de Guevara
 *
 *
 *
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
 *  14. deleteLastOnlyElementResultsInAnEmptyQueue: delete last on a 1-element queue results in an empty queue
 * 15. peekFirstInAnEmptyQueueRaisesException: peek first on an empty queue should raise an exception
 * 16. peekLastInAnEmptyQueueRaisesException: peek last on an empty queue should raise an exception
 * 17. peekFirstWorkAsExpected: peek first should work as intended
 * 18. peekLastWorkAsExpected: peek last should work as intended
 * 19. getAtOf1InEmptyListRaisesException: get from an empty queue raises an exception
 * 20. getAtOfNeg1InQueueRaisesException: get a negative index raises an exception
 * 21. getAtOf2In2SizedListRaisesException: get an index bigger than queue size -1 raises exception
 * 22. getAtOf1In2SizedListReturnNodeTwo |
 * 23. getAtOf0In2SizedListReturnNodeOne | getAt returns the element at given index
 * 24. findNodeOneWhenContainedInQueue: find the node an item is at
 * 25. findNodeThreeWhenNotContainedInQueueRaiseException: trying to find an item that is not in the queue raises an exception
 * 26. findNodeThreeWhenNullRaiseException: trying to find a null item raises an exception
 * 27. deleteWorksForFirstElementDeletion   |
 * 28. deleteWorksForLastElementDeletion    | delete works as expected
 * 29. deleteWorksForMiddleElementDeletion  |
 * 30. deleteForMissingElementRaisesException: deteting an element thas is not in de queue raises an exception
 * 31. sortWorksAsExpected: sort reorders the elements in the queue in the order given by the comparator
 * 32. sortOfAnEmptyQueueRaisesAnException: sorting an empty queue raises an exception
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

    @Test
    public void getAtOf1InEmptyListRaisesException(){
        queue = null;
        assertThrows(RuntimeException.class, ()-> queue.getAt(1));
    }

    @Test
    public void getAtOfNeg1InQueueRaisesException(){
        assertThrows(RuntimeException.class, ()-> queue.getAt(-1));
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
    public void deleteWorksForFirstElementDeletion(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(3), null, null);

        queue.append(nodeOne);
        queue.append(nodeTwo);
        queue.append(nodeThree);

        queue.delete(nodeOne);

        var expectedFirstNode = nodeTwo;
        var actualFirstNode = queue.peekFirst();
        var expectedSize = 2;
        var actualSize = queue.size();

        assertEquals(expectedSize, actualSize);
        assertEquals(expectedFirstNode, actualFirstNode);
    }

    @Test
    public void deleteWorksForLastElementDeletion(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(3), null, null);

        queue.append(nodeOne);
        queue.append(nodeTwo);
        queue.append(nodeThree);

        queue.delete(nodeThree);

        var expectedLastNode = nodeTwo;
        var actualLastNode = queue.peekLast();
        var expectedSize = 2;
        var actualSize = queue.size();

        assertEquals(expectedSize, actualSize);
        assertEquals(expectedLastNode, actualLastNode);
    }

    @Test
    public void deleteWorksForMiddleElementDeletion(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(3), null, null);

        queue.append(nodeOne);
        queue.append(nodeTwo);
        queue.append(nodeThree);

        queue.delete(nodeTwo);

        var expectedSize = 2;
        var actualSize = queue.size();

        assertEquals(expectedSize, actualSize);
        assertThrows(RuntimeException.class, ()-> queue.find(nodeTwo));
    }

    @Test
    public void deleteForMissingElementRaisesException(){
        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(3), null, null);

        queue.append(nodeOne);
        queue.append(nodeThree);
        assertThrows(RuntimeException.class, ()-> queue.delete(nodeTwo));
    }

    @Test
    public void sortWorksAsExpected(){
        int[] expectedValue = {1,2,3};

        DequeNode nodeOne = new DequeNode<Integer>(Integer.valueOf(1), null, null);
        DequeNode nodeTwo = new DequeNode<Integer>(Integer.valueOf(2), null, null);
        DequeNode nodeThree = new DequeNode<Integer>(Integer.valueOf(3), null, null);

        queue.append(nodeTwo);
        queue.append(nodeOne);
        queue.append(nodeThree);

        queue.sort(Comparator.naturalOrder());

        int[] actualValue = {(int)queue.getAt(0).getItem(), (int)queue.getAt(1).getItem(),(int)queue.getAt(2).getItem()};

        assertEquals(expectedValue[0], actualValue[0]);
        assertEquals(expectedValue[1], actualValue[1]);
        assertEquals(expectedValue[2], actualValue[2]);
    }

    @Test
    public void sortOfAnEmptyQueueRaisesAnException(){
        assertThrows(RuntimeException.class, () -> queue.sort(Comparator.naturalOrder()));
    }
}
