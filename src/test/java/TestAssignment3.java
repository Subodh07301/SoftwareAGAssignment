import com.main.assignment3.SolutionForAssignement3;

public class TestAssignment3 {
    public static  void main(String args[]){
        SolutionForAssignement3 slExample=new SolutionForAssignement3();
        Thread t1;
        for(int i=0,j=10;i<10;i++,j++){
            t1=new TestThread(slExample,j);
            t1.start();
        }
    }
}

class TestThread extends Thread{
    private SolutionForAssignement3 solExample;
    private final int value;

    TestThread(final SolutionForAssignement3 slExample,final int value){
        solExample=slExample;
        this.value=value;
    }

    @Override
    public void run(){
        solExample.event(value);
        System.out.println(solExample.minimum());
        System.out.println(solExample.maximum());
        System.out.println(solExample.mean());
        System.out.println(solExample.variance());
        System.out.println();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
