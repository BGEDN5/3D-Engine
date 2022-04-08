public class presentationMain {

    public static void main(String[] args){
        Engine engine = new Engine();
        engine.start();
        int i = 1000;
        while (i>0){
            System.out.println(1/engine.getTime().calculateDeltaTime());
            i--;
        }

    }


}
