public class Vertex {

   private Vector3f pos;

   public Vertex(){
       pos = new Vector3f(0F, 0F, 0F);
   }

   public Vertex(float x1, float y1, float z1){
        pos = new Vector3f(x1, y1, z1);
   }

   public static int SIZE(){
       return 3;
   }

   public void set(Vector3f x){
       this.pos = x;
   }

   public Vector3f get(){
       return this.pos;
   }

}