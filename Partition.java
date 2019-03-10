import java.util.Random;
public class Partition{
  public static int partition(int[] ary, int start, int end){
    Random randgen = new Random();
    int index = Math.abs(randgen.nextInt()) % (end - start);
    // randomly chosen element to be pivot
    int hold = ary[start];
    ary[start] = ary[index];
    ary[index] = hold;
    index = start;
    //swap pivot with start index
    int point = end;
    // go through sublist
    for(int i = start + 1; i < end; i++){
      System.out.println(toString(ary));
      //if element is less than pivot
      // swap it with pivot and update index
      if(ary[i] <= ary[index]){
        hold = ary[i];
        ary[i] = ary[index];
        ary[index] = hold;
        index ++;}
      else{
      //if element is greater than pivot
      // move from back of list until you reach element smaller than pivot
      // swap that element with the element greater than pivot and then pivot with the smaller element
      // once point equals index, the array has been sorted and now return index
        while(ary[point] > ary[index]){
          if(point == index + 1){
            return index;}
          point --;}
        hold = ary[point];
        ary[point] = ary[i];
        ary[i] = hold;
        i--;}}
    return index;}
    public static String toString(int[] ary){
      String output = "";
      for(int i = 0; i < ary.length; i++){
        output += ary[i] + " ";}
      return output;
    }
      public static void main(String[] args) {
        int[] data1 = {2, 8, 7, 5, 9, 12, 3};
        System.out.println(partition(data1, 0, data1.length - 1));
        System.out.println(toString(data1));
  }}
