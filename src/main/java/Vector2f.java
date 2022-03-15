//import  java.util.*;
public class Vector2f {
    public float x,y;

    public Vector2f(float x1, float y1){
        this.x=x1;
        this.y=y1;
    }

    public float length(){
        return (float) Math.sqrt(this.x*this.x+this.y*this.y);
    }

    public float dot(Vector2f a){
         return a.x*this.x+a.y*this.y;
    }

//    public  Vector2f cross(Vector2f a){ return null; }
//    You can't do a cross product with vectors in 2D space

    public Vector2f normalize(){
        float l  = this.length();
        if (l==0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return new Vector2f(this.x/l,this.y/l);
    }

    public Vector2f rotate(float angle){
        float cos = (float) Math.cos(angle),sin= (float) Math.sin(angle);
        return new Vector2f((cos*x-sin*y),(sin*x+cos*y));
    }

    public  Vector2f add(Vector2f a){ return  new Vector2f(this.x+a.x,this.y+a.y); }

    public  Vector2f sub(Vector2f a){ return new Vector2f(this.x-a.x,this.y-a.y); }

    public  Vector2f mult(Vector2f a){ return  new Vector2f(this.x*a.x,this.y*a.y); }

    public  Vector2f div(Vector2f a){
        if(a.x!=0 && a.y!=0){
            return new Vector2f(this.x/a.x,this.y/a.y);
        }
        throw new IllegalArgumentException("Argument 'divisor' is 0");
    }
}