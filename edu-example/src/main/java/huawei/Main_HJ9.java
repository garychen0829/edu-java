package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_HJ9 {

    public static void main(String[] args) {
        LinkListStack linkListStack = new LinkListStack();
        Scanner in = new Scanner(System.in);
        Long num = in.nextLong();
//        System.out.println(num);

        while (num.intValue() != 0) {
            long lastNum = num % 10;
            //System.out.println(lastNum);
            linkListStack.push(lastNum);
            num = num / 10;
        }

        LinkedList ls = linkListStack.ll;
        long result = 0;
        for (int i = 0; i < ls.size(); i++) {
//            System.out.println((long)ls.get(i) * (long)Math.pow(10,i));
            result += (long)ls.get(i) * (long)Math.pow(10,i);
        }
        System.out.println(result);
    }

    static class LinkListStack<T> {
        private LinkedList<T> ll = new LinkedList<>();
        public void push(T t){
            if (ll.contains(t)) {
                return;
            }
            ll.addFirst(t);
        }
        public T pop() {
            return ll.removeFirst();
        }
        public T peek() {
            T t = null;
            if (ll.isEmpty() == false) {
                t = ll.getFirst();
            }
            return t;
        }

        public boolean isEmpty(){
            return ll.isEmpty();
        }
    }
}
