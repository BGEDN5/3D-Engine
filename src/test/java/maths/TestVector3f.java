package maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestVector3f {
    Vector3f vector;

    @BeforeEach
    void init(){
        this.vector = new Vector3f();
    }

    @Test
    void testLength1(){
        this.vector.set(1F, 2F, 2F);
        assertEquals(3F, this.vector.length());
    }

    @Test
    void testLength2(){
        this.vector.set(-1F, 2F, -2F);
        assertEquals(3F, this.vector.length());
    }

    @Test
    void testDot1(){
        this.vector.set(1F, 2F, 3F);
        assertEquals(32F, this.vector.dot(new Vector3f(4F, 5F, 6F)));
    }

    @Test
    void testDot2(){
        this.vector.set(-1F, -2F, 3F);
        assertEquals(12F, this.vector.dot(new Vector3f(-4F, 5F, 6F)));
    }

    @Test
    void testNormalize1(){
        this.vector.set(1F, 2F, 2F);
        this.vector.normalize();
        float[] exp = {(float)(1./3.), (float)(2./3.), (float)(2./3.)};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testNormalize2(){
        this.vector.set(-1F, 2F, -2F);
        this.vector.normalize();
        float[] exp = {(float)(-1./3.), (float)(2./3.), (float)(-2./3.)};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    public void testNormalizeExc() {
        this.vector.set(0F, 0F, 0F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.normalize();
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testRotate1(){
        this.vector.set(3F, 4F, 5F);
        this.vector.rotate((float)Math.PI * 2);
        float[] exp = {3F, 5F, 5F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        float error = (act[0] - exp[0])*(act[0] - exp[0]) + (act[1] - exp[1])*(act[1] - exp[1]) + (act[2] - exp[2])*(act[2] - exp[2]);
        assertTrue(error < 0.001F);
    }

    @Test
    void testRotate2(){
        this.vector.set(6F, 8F, 10F);
        this.vector.rotate((float)Math.PI*5);
        float[] exp = {6F, 10F, 10F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        System.out.println(act[0] + " " + act[1] + " " + act[2]);
        float error = (act[0] - exp[0])*(act[0] - exp[0]) + (act[1] - exp[1])*(act[1] - exp[1]) + (act[2] - exp[2])*(act[2] - exp[2]);
        assertTrue(error < 0.001F);
    }

    @Test
    void testAdd1(){
        this.vector.set(3F, 4F, 5F);
        this.vector.add(new Vector3f(5F, 6F, 7F));
        float[] exp = {8F, 10F, 12F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testAdd2(){
        this.vector.set(6F, 8F, 10F);
        this.vector.add(new Vector3f(15F, 26F, 37F));
        float[] exp = {21F, 34F, 47F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testSub1(){
        this.vector.set(3F, 4F, 5F);
        this.vector.sub(new Vector3f(5F, 6F, 7F));
        float[] exp = {-2F, -2F, -2F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testSub2(){
        this.vector.set(6F, 8F, 10F);
        this.vector.sub(new Vector3f(5F, 6F, 7F));
        float[] exp = {1F, 2F, 3F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }


    @Test
    void testMult1(){
        this.vector.set(3F, 4F, 5F);
        this.vector.mult(new Vector3f(5F, 6F, 7F));
        float[] exp = {15F, 24F, 35F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testMult2(){
        this.vector.set(-2F, 4F, -6F);
        this.vector.mult(new Vector3f(5F, 6F, -7F));
        float[] exp = {-10F, 24F, 42};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testDiv1(){
        this.vector.set(3F, 4F, 5F);
        this.vector.div(new Vector3f(1F, 8F, 10F));
        float[] exp = {3F, 0.5F, 0.5F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testDiv2(){
        this.vector.set(-3F, 4F, -10F);
        this.vector.div(new Vector3f(1F, 8F, 5F));
        float[] exp = {-3F, 0.5F, -2F};
        float[] act = {this.vector.getX(), vector.getY(), vector.getZ()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testDivExc1(){
        this.vector.set(3F, 4F, 5F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector3f(0F, 8F, 11F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDivExc2(){
        this.vector.set(3F, 4F, 5F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector3f(7F, 0F, 11F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDivExc3(){
        this.vector.set(3F, 4F, 5F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector3f(11F, 8F, 0F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDivExc4(){
        this.vector.set(3F, 4F, 5F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector3f(0F, 8F, 0F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDivExc5(){
        this.vector.set(3F, 0F, 5F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector3f(11F, 0F, 0F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testGetX(){
        this.vector.set(3F, 4F, 5F);
        assertEquals(3F, this.vector.getX());
    }

    @Test
    void testGetY(){
        this.vector.set(3F, 4F, 5F);
        assertEquals(4F, this.vector.getY());
    }

    @Test
    void testGetZ(){
        this.vector.set(3F, 4F, 5F);
        assertEquals(5F, this.vector.getZ());
    }

}
