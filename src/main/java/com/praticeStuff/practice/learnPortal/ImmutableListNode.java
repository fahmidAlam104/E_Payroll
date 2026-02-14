package com.praticeStuff.practice.learnPortal;

public class ImmutableListNode {
    private final ImmutableListNode nextNode;
    private final Integer data;
    public ImmutableListNode(ImmutableListNode next, Integer data){
        nextNode=next;
        this.data=data;
    }
    public void printValue(){
        System.out.println(data);
    }
    public Integer getData(){
        return data;
    }
    public ImmutableListNode getNextNode(){
        return nextNode;
    }
}
