public class presentationMain {

    public static void main(String[] args) throws InterruptedException {
        Engine engine = new Engine();
        engine.start();
        int i = 100000;
        Thread.sleep(500);
        while (i>0){
            System.out.println(1/engine.getTime().getDeltaTime()*1000000000);
            i--;
        }
        System.out.println("end");

    }


}
