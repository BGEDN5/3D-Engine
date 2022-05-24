package maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestQuaternion {
    Quaternion quaternion;

    @BeforeEach
    void init(){
        this.quaternion = new Quaternion(1F, 2F, -2F, 0F);
    }

    @Test
    void testLength1(){

        assertEquals(3F, this.quaternion.getLength());
    }

    @Test
    void testLength2(){
        this.quaternion = new Quaternion(3F, 0F, 0F, 4F);
        assertEquals(5F, this.quaternion.getLength());
    }

    @Test
    void testNormalize1(){
        this.quaternion = new Quaternion(3F, 0F, 0F, 4F);
        this.quaternion.normalize();
        float[] exp = {0.6F, 0.0F, 0.0F, 0.8F};
        float[] act = {this.quaternion.getA(), this.quaternion.getB(), this.quaternion.getC(), this.quaternion.getD()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testNormalize2(){
        this.quaternion = new Quaternion(1F, 2F, -2F, 0F);
        this.quaternion.normalize();
        float[] exp = {(float)(1./3.), (float)(2./3.), (float)(-2./3.), (float)(0./3.)};
        float[] act = {this.quaternion.getA(), this.quaternion.getB(), this.quaternion.getC(), this.quaternion.getD()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testMultiply1(){
        Quaternion a  = new Quaternion(1F, 2F, 3F, 4F);
        Quaternion b  = new Quaternion(5F, 6F, 7F, 8F);
        this.quaternion = a.mult(b);
        float[] exp = {(float)-60, (float)-354, (float)2451, (float)-17644};
        float[] act = {this.quaternion.getA(), this.quaternion.getB(), this.quaternion.getC(), this.quaternion.getD()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testMultiply2(){
        Quaternion a  = new Quaternion(1F, 0F, 3F, -4F);
        Quaternion b  = new Quaternion(-2F, 11F, 0F, 8F);
        this.quaternion = a.mult(b);
        float[] exp = {(float)30, (float)354, (float)-2882, (float)31950};
        float[] act = {this.quaternion.getA(), this.quaternion.getB(), this.quaternion.getC(), this.quaternion.getD()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

    @Test
    void testMultiply3() {
        Quaternion a = new Quaternion(1F, 0F, 3F, 0F);
        Quaternion b = new Quaternion(0F, 6F, 0F, 8F);
        this.quaternion = a.mult(b);
        float[] exp = {(float) 0, (float) 24, (float) -192, (float) 1152};
        float[] act = {this.quaternion.getA(), this.quaternion.getB(), this.quaternion.getC(), this.quaternion.getD()};
        assertTrue(java.util.Arrays.equals(exp, act));
    }

}

