import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* Tests:
* 1. shouldSetItemEqualNewItem: when the Item of a Node is Set, it should replace it
* 2. shouldSetNextEqualNewNext: when the Next of a Node is Set, it should replace it
* 3. shouldSetPreviousEqualNewPrevious: when the Previous of a Node is Set, it should replace it
* 4. shouldFirstOfFirstReturnNull: if a Node is First it should be First
* 5. shouldLastOfLastReturnNull: if a Node is Last it should be Last
* 6. shouldTerminalReturnTerminalFalse: if a Node is Terminal it should be Terminal
* */

public class DequeNodeTest {

    @Test
    public void shouldSetItemEqualNewItem(){
        DequeNode<Integer> node = new DequeNode<>(4, null, null);
        node.setItem(7);
        assertEquals(7, node.getItem());
    }

    @Test
    public void shouldSetNextEqualNewNext(){
        DequeNode<Integer> first = new DequeNode<>(4, null, null);
        DequeNode<Integer> last = new DequeNode<>(4, null, first);
        first.setNext(last);
        assertEquals(last, first.getNext());
    }

    @Test
    public void shouldSetPreviousEqualNewPrevious(){
        DequeNode<Integer> last = new DequeNode<>(4, null, null);
        DequeNode<Integer> first = new DequeNode<>(4, last, null);
        last.setPrevious(first);
        assertEquals(first, last.getPrevious());
    }

    @Test
    public void shouldFirstOfFirstReturnNull(){
        DequeNode<Integer> first = new DequeNode<>(1, null, null);
        boolean result = first.isFirstNode();
        assertTrue(result);
    }

    @Test
    public void shouldLastOfLastReturnNull(){
        DequeNode<Integer> last = new DequeNode<>(1, null, null);
        boolean result = last.isLastNode();
        assertTrue(result);
    }

    @Test
    public void shouldTerminalReturnTerminalFalse(){
        DequeNode<Integer> terminal = new DequeNode<>(1, null, null);
        boolean result = terminal.isNotATerminalNode();
        assertFalse(result);
    }
}
