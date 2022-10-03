package example;

import java.util.List;

public class Test {


    private boolean checkOverLap(List<Range> list) {

        int[] flags = new int[12];

        for(Range range:list){
            int right=range.getRight();
            if(right==0||right>11){
                right=11;
            }
            //fill flag array
            for(int index=range.getLeft();index<=range.getRight();index++){
                if(flags[index]==1){//this is marked, overlapped
                    return true;
                }else{
                    flags[index]=1;
                }
            }
        }


        return false;
    }


    public static void main(String[] args) {
        Test test = new Test();
        List<Range> ranges = List.of(new Range(4, 4),
                new Range(5,10),
                new Range(1,2));
        System.out.println(test.checkOverLap(ranges));
    }
}


class Range {
    public Range(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    int left;
    int right;
}