import java.util.*;
public class Quick{
    public static int partition(int[] ary, int start, int end){
      if(start == end){
        return start;}
      Random randgen = new Random();
      //int keeper = (Math.abs(randgen.nextInt()) % (end - start)) + start;
      int index =  median(ary[start], ary[end], ary[(end +  start) / 2]);
      if(index == ary[start]){
        index = start;}
      else if (index == ary[end]){
        index = end;}
      else{
        index = (end + start) / 2;}
      int hold = ary[start];
      ary[start] = ary[index];
      ary[index] = hold;
      index = start;
      for(int i = start + 1; i <= end; i++){
        if(ary[i] < ary[index]) {
          hold = ary[i];
          ary[i] = ary[index];
          ary[index] = hold;
          index = i;}
      else if(ary[i] == ary[index]){
        if(Math.abs(randgen.nextInt() % 2) == 0){
          while(ary[end] >= ary[index]){
            if(end == index){
              return index;}
            end --;}
          hold = ary[end];
          ary[end] = ary[i];
          ary[i] = hold;

          hold = ary[index];
          ary[index] = ary[i];
          ary[i] = hold;
          index = i;}
        else{
          hold = ary[i];
          ary[i] = ary[index];
          ary[index] = hold;
          index = i;}}
      else{
          while(ary[end] >= ary[index]){
            if(end == index){
              return index;}
            end --;}
          hold = ary[end];
          ary[end] = ary[i];
          ary[i] = hold;

          hold = ary[index];
          ary[index] = ary[i];
          ary[i] = hold;
          index =i;
        }}
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
      quicksortH(ary, 0, ary.length - 1);}

    public static void quicksortH(int[] ary, int start, int end){
      if(end > start){
        int popped = partition(ary, start, end);
        quicksortH(ary, start, popped - 1);
        quicksortH(ary, popped + 1, end);}}

    public static String toString(int[] ary){
      String output = "";
      for(int i = 0; i < ary.length; i++){
        output += ary[i] + " ";}
      return output;}}
