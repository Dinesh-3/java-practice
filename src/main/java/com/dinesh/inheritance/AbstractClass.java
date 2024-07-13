package com.dinesh.inheritance;

import java.util.Scanner;

abstract class Book{
    String title;
    abstract void setTitle(String s);
    String getTitle(){
        return title;
    }

    public String getClassName() {
        return getClass().getName();
    }

}

//Write MyBook class here
class MyBook extends Book{
    @Override
    void setTitle(String s){
        super.title = s;
    }
}

public class AbstractClass {
    public static void main(String []args){
        //Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
        System.out.print("Enter Title: ");
//        Scanner sc=new Scanner(System.in);
//        String title=sc.nextLine();
//        sc.close();

        MyBook new_novel=new MyBook();
        new_novel.setTitle("DInesh");
        System.out.println("The title is: "+new_novel.getTitle());
        System.out.println("new_novel = " + new_novel);
        System.out.println("new_novel.getClassName() = " + new_novel.getClassName());
    }
}
