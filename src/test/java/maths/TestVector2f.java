package maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestVector2f {
    Vector2f vector;

    @BeforeEach
    void init(){
        this.vector = new Vector2f();
    }

    @Test
    void testLength1(){
        this.vector.set(3F, 4F);
        assertEquals(5, this.vector.length());
    }

    @Test
    void testLength2(){
        this.vector.set(6F, 8F);
        assertEquals(10, this.vector.length());
    }

    @Test
    void testDot1(){
        this.vector.set(3F, 4F);
        assertEquals(39F, this.vector.dot(new Vector2f(5F, 6F)));
    }

    @Test
    void testDot2(){
        this.vector.set(6F, 8F);
        assertEquals(78F, this.vector.dot(new Vector2f(5F, 6F)));
    }

    @Test
    void testNormalize1(){
        this.vector.set(3F, 4F);
        this.vector.normalize();
        float[] exp = {0.6F, 0.8F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testNormalize2(){
        this.vector.set(6F, 8F);
        this.vector.normalize();
        float[] exp = {0.6F, 0.8F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    public void testNormalizeExc() {
        this.vector.set(0F, 0F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.normalize();
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testRotate1(){
        this.vector.set(3, 4);
        this.vector.rotate((float)Math.PI * 2);
        float[] exp = {3F, 4F};
        float[] act = {this.vector.getX(), vector.getY()};
        float error = (act[0] - exp[0])*(act[0] - exp[0]) + (act[1] - exp[1])*(act[1] - exp[1]);
        assertTrue(error < 0.001F);
    }

    @Test
    void testRotate2(){
        this.vector.set(6, 8);
        this.vector.rotate((float)Math.PI);
        float[] exp = {-6F, -8F};
        float[] act = {this.vector.getX(), vector.getY()};
        float error = (act[0] - exp[0])*(act[0] - exp[0]) + (act[1] - exp[1])*(act[1] - exp[1]);
        assertTrue(error < 0.001F);
    }

    @Test
    void testAdd1(){
        this.vector.set(3F, 4F);
        this.vector.add(new Vector2f(5F, 6F));
        float[] exp = {8F, 10F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testAdd2(){
        this.vector.set(6F, 8F);
        this.vector.add(new Vector2f(15F, 26F));
        float[] exp = {21F, 34F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testSub1(){
        this.vector.set(3F, 4F);
        this.vector.sub(new Vector2f(5F, 6F));
        float[] exp = {-2F, -2F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testSub2(){
        this.vector.set(6F, 8F);
        this.vector.sub(new Vector2f(5F, 6F));
        float[] exp = {1F, 2F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }


    @Test
    void testMult1(){
        this.vector.set(3F, 4F);
        this.vector.mult(new Vector2f(5F, 6F));
        float[] exp = {15F, 24F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testMult2(){
        this.vector.set(-2F, 4F);
        this.vector.mult(new Vector2f(5F, 6F));
        float[] exp = {-10F, 24F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testDiv1(){
        this.vector.set(3F, 4F);
        this.vector.div(new Vector2f(1F, 8F));
        float[] exp = {3F, 0.5F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testDiv2(){
        this.vector.set(-3F, 4F);
        this.vector.div(new Vector2f(1F, 8F));
        float[] exp = {-3F, 0.5F};
        float[] act = {this.vector.getX(), vector.getY()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testDivExc1(){
        this.vector.set(3F, 4F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector2f(0F, 8F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDivExc2(){
        this.vector.set(3F, 4F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector2f(1F, 0F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDivExc3(){
        this.vector.set(3F, 4F);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vector.div(new Vector2f(0F, 0F));
        });

        String expectedMessage = "Argument 'divisor' is 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testGetX(){
        this.vector.set(3F, 4F);
        assertEquals(3F, this.vector.getX());
    }

    @Test
    void testGetY(){
        this.vector.set(3F, 4F);
        assertEquals(4F, this.vector.getY());
    }


}
