import java.util.Random;
public class sort{
  public int partition(int[] ary, int start, int end){
    Random randgen = new Random();
    int index = randgen.nextInt() % ary.length;
    int hold = ary[start];
    ary[start] = ary[index];
    ary[index] = hold;
    index = start;
    int point = end - 1;
    for(int i = start; i < end; i++){
      if(ary[i] <= ary[index]){
        hold = ary[i];
        ary[i] = ary[index];
        ary[index] = hold;
        index ++;}
      else{
        while(ary[point] > ary[index]){
          point --;}
        if(point == index){
          return index;}
        hold = ary[point];
        ary[point] = ary[i];
        ary[i] = hold;
        hold = ary[i];
        ary[i] = ary[index];
        ary[index] = hold;
        index ++;}}
    return index;}
}
