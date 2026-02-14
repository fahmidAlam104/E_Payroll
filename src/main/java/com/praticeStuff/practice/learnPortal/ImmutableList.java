package com.praticeStuff.practice.learnPortal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ImmutableList {
    private final ImmutableListNode head;
    public ImmutableList(List<Integer> list) {
        if(list==null){
            throw new IllegalArgumentException("Input cant be null");
        }
        ImmutableListNode next = null;
        Collections.reverse(list);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            ImmutableListNode tmp = new ImmutableListNode(next, it.next());
            next = tmp;
        }
        head=next;
    }
    public ImmutableListNode getCurr(){
        return head;
    }
    public void print(){
        ImmutableListNode curr=head;
        while(curr!=null){
            curr.printValue();
            curr=curr.getNextNode();
        }
    }
}
