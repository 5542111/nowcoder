import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        sortAlgorithm sortAlgorithm=new sortAlgorithm();
        int [] arr={7,41,2,34,4,6,100};
        System.out.println(Arrays.toString(arr));
        sortAlgorithm.fastSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
