
import java.util.ArrayList;
import java.util.Scanner;

    public class Main {
        private static ArrayList<Integer> treeArr= new ArrayList<>();


public static Integer[] findMaxLev(ArrayList<Integer> tree){
Integer[] max=new Integer[2];
    int levTrack, levSum, maxLev, currInd, maxSum;
    maxSum=levTrack= levSum=maxLev=currInd =0;

    while(currInd<tree.size()){
        for(int i=0;i<Math.pow(2,levTrack) && currInd<tree.size();i++){

                levSum += treeArr.get(currInd);
                currInd++;

        }
        if(levSum>maxSum){

            maxSum=levSum;
            maxLev=levTrack;
        }
        levSum=0;
        levTrack++;

    }
    max[0]=maxLev+1;
    max[1]=maxSum;
return max;
}
        public static void main(String[] args) {
            Scanner scanner= new Scanner(System.in);
            String zones= scanner.nextLine();
            Scanner zonesScan= new Scanner(zones);
            while(zonesScan.hasNextInt()){
                treeArr.add(zonesScan.nextInt());
            }

Integer[] max=findMaxLev(treeArr);
System.out.print(max[1]);


        }
    }


