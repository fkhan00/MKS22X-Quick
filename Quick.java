import java.util.Random;
public class Quick{
    public static int partition(int[] ary, int start, int end){
      if(start == end){
        return start;}
      Random randgen = new Random();
      int index = median(Math.abs(randgen.nextInt()) % (end - start) + start, Math.abs(randgen.nextInt()) % (end - start) + start, Math.abs(randgen.nextInt()) % (end - start) + start);
      // randomly chosen element to be pivot
      int hold = ary[start];
      ary[start] = ary[index];
      ary[index] = hold;
      index = start;
      //swap pivot with start index
      // go through sublist
      for(int i = start + 1; i <= end; i++){
        //if element is less than pivot
        // swap it with pivot and update index
        if(ary[i] < ary[index] || (ary[i] == ary[index] && Math.abs(randgen.nextInt() % 2) == 1)){
          hold = ary[i];
          ary[i] = ary[index];
          ary[index] = hold;
          index = i;}
        else{
        //if element is greater than pivot
        // move from back of list until you reach element smaller than pivot
        // swap that element with the element greater than pivot and then pivot with the smaller element
        // once point equals index, the array has been sorted and now return index
          while(ary[end] >= ary[index]){
            if(end <= index + 1){
              return index;}
            end --;}
          hold = ary[end];
          ary[end] = ary[i];
          ary[i] = hold;
          i--;}}
  return index;}
    public static int median(int x, int y, int z){
    if(x >= y && y >= z){
      return y;}
    if(x <= y && z >= x){
      return x;}
    return z;}

  public static int quickselect(int[] ary, int k){
    int start = 0;
    int end = ary.length - 1;
    int popped = 0;
    while(true){
      popped = partition(ary, start, end);
        if(popped < k){
        start = popped + 1;}
      else if(popped > k){
      end = popped - 1;}
      else{
        return ary[popped];}}}

    public static void quicksort(int[] ary){
      quicksortH(ary, 0, ary.length - 1, 0);}
    public static void quicksortH(int[] ary, int start, int end, int popped){
      if(end > start){
        popped = partition(ary, start, end);
        quicksortH(ary, start, popped - 1, popped);
        quicksortH(ary, popped + 1, end, popped);}}

    public static String toString(int[] ary){
      String output = "";
      for(int i = 0; i < ary.length; i++){
        output += ary[i] + " ";}
      return output;
}
  public static int partitionDutch(int[] ary, int lo, int hi){
    Random randgen = new Random();
    if(hi == lo){
      return lo;}
    int index = Math.abs(randgen.nextInt()) % (hi - lo ) + lo;
    index = median(index, lo, hi);
    int hold = ary[lo];
    ary[lo] = ary[index];
    ary[index] = hold;
    index = lo;
    int li = lo;
    int point = hi;
    for(int i = lo + 1; i <= hi; i++){
      while(ary[index] == ary[i]){
        i ++;
        index ++;}
      if(ary[index] > ary[i]){
        hold = ary[lo];
        ary[lo] = ary[i];
        ary[i] = hold;
        lo ++;}
      else{
        while(ary[point] > ary[index]){
          if(point <= index + 1){
            return index;}
          point --;}
        hold = ary[point];
        ary[point] = ary[i];
        ary[i] = hold;
        i--;}}
    return index;}




}
