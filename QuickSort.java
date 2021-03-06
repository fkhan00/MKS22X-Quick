import java.util.Random;
public class QuickSort{
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
  public sttic int quickSelect(int[] ary, int k){
    int start = 0;
    int end = ary.length - 1;
    int popped = 0;
    while(true){
      popped = partition(ary, start, end);
      if(popped < k){
        start = popped;}
      else if(popped > k){
        end = popped;}
      else{
        return popped;}}
    return popped;
  }
    public static String toString(int[] ary){
      String output = "";
      for(int i = 0; i < ary.length; i++){
        output += ary[i] + " ";}
      return output;
    }}
