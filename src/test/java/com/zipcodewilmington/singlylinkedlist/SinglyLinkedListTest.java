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

    @Test
    public void testAddValue(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 5;

        // When
        list.add(5);

        // Then
        Assert.assertEquals(expected,list.getHead().value);
        Assert.assertEquals(expected,list.getTail().value);
    }

    @Test
    public void testAddValue2(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedHead = 5;
        Integer expectedTail = 3;

        // When
        list.add(5);
        list.add(2);
        list.add(3);

        // Then
        Assert.assertEquals(expectedHead,list.getHead().value);
        Assert.assertEquals(expectedTail,list.getTail().value);
    }

    @Test
    public void testAddNode(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedHead = 5;
        Integer expectedTail = 3;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertEquals(expectedHead,list.getHead().value);
        Assert.assertEquals(expectedTail,list.getTail().value);
    }

    @Test
    public void testSize(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedHead = 3;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertEquals(expectedHead,list.size());
    }

    @Test
    public void testGet(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertNull(list.get(3));
    }

    @Test
    public void testGet2(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(10);
        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(node);
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertEquals(node,list.get(1));
    }

    @Test
    public void testGet3(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(10);
        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));
        list.addNode(node);

        // Then
        Assert.assertEquals(node,list.get(3));
    }

    @Test
    public void testContainsTrue(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(10);

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));
        list.addNode(node);

        // Then
        Assert.assertTrue(list.contains(node));
    }

    @Test
    public void testContainsFalse(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(10);

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));
        //list.addNode(node);

        // Then
        Assert.assertFalse(list.contains(node));
    }

    @Test
    public void testFindValue(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Integer expected = 2;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertEquals(expected,list.find(3));
    }

    @Test
    public void testFindValue2(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Integer expected = -1;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertEquals(expected,list.find(10));
    }

    @Test
    public void testFindNode(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(10);
        Integer expected = 2;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(node);
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertEquals(expected,list.findNode(node));
    }

    @Test
    public void testFindNode2(){
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(10);
        Integer expected = -1;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        //list.addNode(node);
        list.addNode(new SinglyLinkedList.Node<>(3));

        // Then
        Assert.assertEquals(expected,list.findNode(node));
    }

    @Test
    public void copy() {
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Integer expected = 5;
        Integer expectedNewList =4;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(3));

        SinglyLinkedList<Integer> newList = list.copy();
        newList.getHead().value = 4;


        // Then
        Assert.assertEquals(expected,list.getHead().value);
        Assert.assertEquals(expectedNewList,newList.getHead().value);
    }

    @Test
    public void testRemoveHead() {
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> expected = new SinglyLinkedList.Node<>(2);
        Integer expectedSize = 4;

        // When
        list.addNode(new SinglyLinkedList.Node<>(1));
        list.addNode(expected);
        list.addNode(new SinglyLinkedList.Node<>(3));
        list.addNode(new SinglyLinkedList.Node<>(4));
        list.addNode(new SinglyLinkedList.Node<>(5));

        list.remove(0);

        // Then
        Assert.assertEquals(expectedSize,list.size());
        Assert.assertEquals(expected,list.getHead());
    }

    @Test
    public void testRemoveTail() {
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> expected = new SinglyLinkedList.Node<>(2);
        Integer expectedSize = 4;

        // When
        list.addNode(new SinglyLinkedList.Node<>(1));
        list.addNode(new SinglyLinkedList.Node<>(3));
        list.addNode(new SinglyLinkedList.Node<>(4));
        list.addNode(expected);
        list.addNode(new SinglyLinkedList.Node<>(5));

        list.remove(4);

        // Then
        Assert.assertEquals(expectedSize,list.size());
        Assert.assertEquals(expected,list.getTail());
    }

    @Test
    public void testRemoveMiddleOfList() {
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(2);
        Integer expectedSize = 4;

        // When
        list.addNode(new SinglyLinkedList.Node<>(1));
        list.addNode(node);
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(3));
        list.addNode(new SinglyLinkedList.Node<>(4));

        list.remove(2);

        // Then
        Assert.assertEquals(expectedSize,list.size());

        SinglyLinkedList.Node<Integer> temp = list.getHead();
        for(int i = 0; i < list.size(); i++){
            Integer expected = i+1;
            Assert.assertEquals(expected,temp.value);
            temp=temp.next;
        }
    }

    @Test
    public void testSort() {
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList.Node<Integer> node = new SinglyLinkedList.Node<>(2);
        Integer expectedSize = 5;

        // When
        list.addNode(new SinglyLinkedList.Node<>(3));
        list.addNode(new SinglyLinkedList.Node<>(4));
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(1));
        list.addNode(new SinglyLinkedList.Node<>(2));

        list.sort();

        // Then
        Assert.assertEquals(expectedSize,list.size());

        SinglyLinkedList.Node<Integer> temp = list.getHead();
        for(int i = 0; i < list.size(); i++){
            Integer expected = i+1;
            Assert.assertEquals(expected,temp.value);
            temp=temp.next;
        }
    }


    @Test
    public void testReverse() {
        // Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Integer expectedSize = 5;

        // When
        list.addNode(new SinglyLinkedList.Node<>(5));
        list.addNode(new SinglyLinkedList.Node<>(4));
        list.addNode(new SinglyLinkedList.Node<>(3));
        list.addNode(new SinglyLinkedList.Node<>(2));
        list.addNode(new SinglyLinkedList.Node<>(1));

        list.reverse();

        // Then
        Assert.assertEquals(expectedSize,list.size());

        SinglyLinkedList.Node<Integer> temp = list.getHead();
        for(int i = 0; i < list.size(); i++){
            Integer expected = i+1;
            Assert.assertEquals(expected,temp.value);
            temp=temp.next;
        }
    }
}
