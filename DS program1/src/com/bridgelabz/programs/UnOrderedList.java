package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Node{
    protected String data;
    protected Node next;
   
    Node(String str){
        this.data = str;
        next = null;
    }
}
class linkList{
   
    protected Node head;
   
    linkList(){
        head = null;
    }
   
    public void insertData(String data) {
       
        if(head==null) {
            head = new Node(data);
        }
        else {
            Node temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }
    public void printNode() {
       
        if(head==null) {
            System.out.println("Linklist is empty :");
            System.exit(0);
        }else {
            Node temp = head;
            while(temp!=null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    }
    public  FileWriter writeListNode(FileWriter br) throws IOException {
       
        if(head==null) {
            System.out.println("Linklist is empty :");
            System.exit(0);
        }else {
            Node temp = head;
            while(temp!=null) {
                br.write(temp.data+" ");
                temp = temp.next;
            }
        }
        return br;
    }
    public void removeWord(String word) {
        if(head.data.toLowerCase().equals(word.toLowerCase())) {
            head = head.next;
        }
        else {
            Node temp = head.next;
            Node prev = null;
            while(!(temp.data.toLowerCase().equals(word.toLowerCase()))) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp =null;
           
        }   
    }
    public void addWord(String word) {
        Node temp = head;
        while(temp.next!=null) {
            temp=temp.next;
        }
         temp.next = new Node(word);
    }   
    public int search(String word) {
        int i=0;
        Node temp = head;
            while(temp!=null) {
                if(temp.data.toLowerCase().equals(word.toLowerCase())){
                    i++;
                }   
                temp = temp.next;
            }
        return i;   
    }
}   
/**
 * @author To read the line from the file and split it space wise.
 *  add each word in the generic linklist then take user input to search a word if it's present then remove otherwise add,
 *  and fianal result write in file. 
 *
 */
public class UnOrderedList{
   
    public static void main(String args[]) throws IOException {
        Scanner sc =new Scanner(System.in);
        File file =null;
        BufferedReader br =null;
        linkList add = new linkList();
    try {   
         file =new File("/home/bridgeit/Documents/File.txt");
         br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine())!=null) {
       
        String[] str = line.split("\\s");
            for(int i=0;i<str.length;i++){
                add.insertData(str[i]);
            }
        }
    }catch(Exception e) {
        e.printStackTrace();
    }finally {
        br.close();
    }
   
        add.printNode();
        System.out.println("");
        System.out.println("Enter a word to be search :");
        String word = sc.nextLine();
        int i = add.search(word);
        if(i==0) {
            System.out.println("Word is not present in a list So we add in the list:");
            add.addWord(word);
            //System.out.println("After adding List :");
            //add.printNode();
        }else {
            System.out.println(i+" Times Word is present in a list And we delete it.");
            add.removeWord(word);
        }
        FileWriter fr =null;
        FileWriter fr1 =null;
    try {
        File writeFile = new File("/home/bridgeit/Documents/File.txt");
        fr = new FileWriter(writeFile);
         fr1 = add.writeListNode(fr);
         System.out.println("updated list successfully added in file :");
         
    }catch(Exception e) {
        e.printStackTrace();
    }finally {
        fr.close();
        fr1.close();
    }
       
    }
}

