public class Vector3f {

    public float x,y,z;

    public Vector3f(float x1, float y1,float z1){
        this.x=x1;
        this.y=y1;
        this.z=z1;
    }

    public float length(){
        return (float) Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z);
    }

    public float dot(Vector3f a){
        return a.x*this.x+a.y*this.y+a.z*this.z;
    }

    public  Vector3f cross(Vector3f a){
        return new Vector3f(this.y*a.z-this.z*a.y,this.z*a.x-this.x*a.z,this.x*a.y-this.y*a.x);
    }

    public Vector3f normalize(){
        float l  = this.length();
        if (l==0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return new Vector3f(this.x/l,this.y/l,this.z/l);
    }

    public Vector3f rotate(float angle){
        float cos = (float) Math.cos(angle),sin= (float) Math.sin(angle);
        float x1 = (cos*this.x-sin*this.y), y1 = (sin*x+cos*this.y),z1 = this.z;
        x1 = x1*cos+z1*sin;
        z1 = z1*cos-sin*x1;
        y1 = y1*cos-z1*sin;
        z1 = y1*sin+z1*cos;
        return new Vector3f(x1,z1,z1);
    }

    public  Vector3f add(Vector3f a){ return  new Vector3f(this.x+a.x,this.y+a.y,this.z+a.z); }

    public  Vector3f sub(Vector3f a){ return new Vector3f(this.x-a.x,this.y-a.y,this.z-a.z); }

    public  Vector3f mult(Vector3f a){ return  new Vector3f(this.x*a.x,this.y*a.y,this.z*a.z); }

    public  Vector3f div(Vector3f a){
        if(a.x!=0 && a.y!=0 && a.z!=0  ){
            return new Vector3f(this.x/a.x,this.y/a.y,this.z/a.z);
        }
        throw new IllegalArgumentException("Argument 'divisor' is 0");
    }
}
