package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void testConstructor(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Assert.assertNull(list.getHead());
        Assert.assertNull(list.getTail());
    }

}
