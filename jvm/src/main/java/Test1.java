import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Byte[]> list=new  LinkedList();

        System.out.println(Object.class.getClassLoader());
        for(int i=0;i<10;i++){
            list.add(new Byte[1024*1024*1]);
            System.gc();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
