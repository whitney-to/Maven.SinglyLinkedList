package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {
    public static class Node<T extends Comparable<T>> {
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

    public Node<T> getHead() {
        return head;
    }


    public Node<T> getTail() {
        return tail;
    }

    public void add(T value){
        Node<T> node = new Node<>(value);
        if(this.head==null){
            head = node;
        } else {
            // set tail.next to new node
            tail.next = node;

            // point tail to new node
        }
        tail = node;
    }

    public void addNode(Node<T> node){
        if(this.head==null){
            head = node;
        } else {
            // set tail to new node
            tail.next = node;
        }
        tail = node;
    }

    public Integer size(){
        Integer count  = 0;
        Node<T> temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Node<T> get(Integer index){
        if(index < this.size()){
            Integer count  = 0; // current index
            Node<T> temp = head;
            while(temp!=null){
                if(count.equals(index)){
                    return temp;
                }
                count++;
                temp = temp.next;
            }
        }
        return null;
    }

    public Boolean contains(Node<T> node){
        Node<T> temp = head;
        while(temp!=null){
            if(temp.equals(node)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Integer find(T value){
        Node<T> temp = head;
        Integer index = 0;
        while(temp!=null){
            if(temp.value.equals(value)){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public Integer findNode(Node<T> node) {
        Node<T> temp = head;
        Integer index = 0;
        while (temp != null) {
            if (temp.equals(node)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public SinglyLinkedList<T> copy()  {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        Node<T> temp = head;
        while(temp!=null){
            newList.add(temp.value);
            temp = temp.next;
        }
        return newList;
    }

    public void remove(Integer index){
        if(index < this.size()){
            // remove head
            if(index == 0){
                Node<T> temp = head;
                head = head.next;
                temp.next = null;
            }
            // remove tail
            else if(index == this.size()-1){
                Node<T> temp = head;
                while(!temp.next.equals(tail)){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            // remove node in middle
            else {
                Node<T> temp1 = this.get(index-1);
                Node<T> toBeRemoved = this.get(index);
                temp1.next = toBeRemoved.next;
                toBeRemoved.next = null;
            }
        }
    }

    public void sort(){
        Node<T> curNode;
        Node<T> temp;
        for(int i = 0; i < this.size(); i++){
            curNode = get(i);
            temp = curNode;
            while(temp.next!=null){
                temp = temp.next;
                if(curNode.value.compareTo(temp.value)>0){
                    swap(curNode,temp);
                    temp = curNode;
                    curNode = get(i);
                }
            }
        }
    }

    public void swap(Node<T> node1, Node<T> node2){
//        Node<T> temp = node2;
//        if(node1.equals(head)){
//            head = node2;
//        } else if(node2.equals(tail)){
//            tail = node1;
//        }
//        node1.next = node2.next;
//        temp.next = node1;
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }
}
