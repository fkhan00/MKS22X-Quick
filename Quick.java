import java.util.*;
public class Quick {
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
    quicksort(ary, 0, ary.length - 1);}
  // dutch flag partitioning
	public static void quicksort(int[] ary, int lo, int hi) {
		if (lo >= hi){
			return;}
    // set pivot to median
		int pivot = ary[ (hi + lo) / 2];
    // track lo and hi indices
		int i = lo;
    int j = hi;
    // instead of sorting by moving in one direction
    // why not do in both directions at the same time
		while (i <= j) {
      //keep on going until you find something that doesn't belong
			while (ary[i] < pivot) {i++;}
			while (ary[j] > pivot) {j--;}
      // we now have two indices, i and j, that both belong in the other group, swap
			if (i <= j) {
				int temp = ary[i];
				ary[i] = ary[j];
				ary[j] = temp;
        // move past element
				i++;
				j--;}}
    // since you moved everything less than pivot to left and all greater than pivot to right
    // all equal values are in between
    // no need to put those into the quicksort lo, hi interval as they with the pivot are already sorted
    //sort from min to boundary of equals and less than
		if (lo < j){
			quicksort(ary, lo, j);}
    // sort from boundary of equals and greater to max
		if (hi > i){
			quicksort(ary, i, hi);}
	}
  // tried implementing inseriton sort but its coefficient is too high for my quicksort
  private static void insertionSort(int[] ary, int lo, int hi)
         {
           int c = 0;
           int place = 0;
           for(int i = lo; i <= hi; i++)
           {
             place = ary[i];
             c = i - 1;
             while(c >= 0 && place <= ary[c])
             {
               ary[c + 1] = ary[c];
               c--;
             }
             ary[c + 1] = place;
           }
       }
}
