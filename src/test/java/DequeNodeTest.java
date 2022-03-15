import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest<T> {
    private DequeNode dequeNode;
    T item;
    DequeNode<T> next;
    DequeNode<T> previous;

    @Test
    public void shouldSetItemEqualNewItem(){
        DequeNode<Integer> node = new DequeNode<>(4, null, null);
        node.setItem(7);
        assertEquals(7, node.getItem());
    }
}
