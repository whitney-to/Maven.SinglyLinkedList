package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    class Node<T>{
        Node<T> next;
        T value;
        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }

    Node<T> head;
    Node<T> tail;

    public SinglyLinkedList(){
        head = null;
        tail = null;
    }

    public void add(Node<T> node){
        if(this.head==null){
            head = node;
        } else {
            Node<T> temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}
