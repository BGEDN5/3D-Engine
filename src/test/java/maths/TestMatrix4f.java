package maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMatrix4f {
    Matrix4f matrix;

    @BeforeEach
    void init(){
        this.matrix = new Matrix4f(new float[][] {{1F, 2F, 3F, 4F},
                                                    {5F, 6F, 7F, 8F},
                                                    {9F, 10F, 11F, 12F},
                                                    {13F, 14F, 15F, 16F}});
    }

    @Test
    void testGetCellValue1(){
        assertEquals(1F, this.matrix.getCellValue(0, 0));
    }

    @Test
    void testGetCellValue2(){
        assertEquals(12F, this.matrix.getCellValue(2, 3));
    }

    @Test
    void testGetCellValue3(){
        assertEquals(16F, this.matrix.getCellValue(3, 3));
    }

    @Test
    void testGetCellValue4(){
        assertEquals(10F, this.matrix.getCellValue(2, 1));
    }

    @Test
    void testSetCell1(){
        this.matrix.setSeparateCell(1, 3, 2.5F);
        assertEquals(2.5F, this.matrix.getCellValue(1, 3));
    }

    @Test
    void testSetCell2(){
        this.matrix.setSeparateCell(3, 1, 1.7F);
        assertEquals(1.7F, this.matrix.getCellValue(3, 1));
    }

    @Test
    void testSetCell3(){
        this.matrix.setSeparateCell(0, 2, -12.5F);
        assertEquals(-12.5F, this.matrix.getCellValue(0, 2));
    }

    @Test
    void testIdentity(){
        float[][] exp = {{1F, 0F, 0F, 0F},
                            {0F, 1F, 0F, 0F},
                            {0F, 0F, 1F, 0F},
                            {0F, 0F, 0F, 1F}};
        Matrix4f act = this.matrix.identity();
        boolean check = true;
        for(int i = 0; i < act.MATRIX_LEN; i++){
            for(int j = 0; j < act.MATRIX_LEN; j++){
                if(exp[i][j] != act.getCellValue(i, j)){
                    check = false;
                    break;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void testMultiply1(){
        Matrix4f a = new Matrix4f(new float[][] {{1F, 2F, 3F, 4F},
                                        {5F, 6F, 7F, 8F},
                                        {9F, 10F, 11F, 12F},
                                        {13F, 14F, 15F, 16F}});
        Matrix4f b = new Matrix4f(new float[][] {{0F, 2F, 0F, 4F},
                                        {0F, 6F, 0F, 8F},
                                        {0F, 10F, 0F, 12F},
                                        {0F, 14F, 0F, 16F}});
        Matrix4f act = a.multiply(b);
        float[][] exp = {{0F, 100F, 0F, 120F},
                            {0F, 228F, 0F, 280F},
                            {0F, 356F, 0F, 440F},
                            {0F, 484F, 0F, 600F}};
        boolean check = true;
        for(int i = 0; i < act.MATRIX_LEN; i++){
            for(int j = 0; j < act.MATRIX_LEN; j++){
                if(exp[i][j] != act.getCellValue(i, j)){
                    check = false;
                    break;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void testMultiply2(){
        Matrix4f a = new Matrix4f(new float[][] {{-1F, 2F, 3F, 4F},
                                                    {5F, -6F, 7F, 8F},
                                                    {9F, 10F, -11F, 12F},
                                                    {13F, 14F, 15F, -16F}});
        Matrix4f b = new Matrix4f(new float[][] {{0F, 2F, 0F, 4F},
                                                    {0F, 6F, 0F, 8F},
                                                    {0F, 10F, 0F, 12F},
                                                    {0F, 14F, 0F, 16F}});
        Matrix4f act = a.multiply(b);
        float[][] exp = {{0F, 96F, 0F, 112F},
                            {0F, 156F, 0F, 184F},
                            {0F, 136F, 0F, 176F},
                            {0F, 36F, 0F, 88F}};
        boolean check = true;
        for(int i = 0; i < act.MATRIX_LEN; i++){
            for(int j = 0; j < act.MATRIX_LEN; j++){
                if(exp[i][j] != act.getCellValue(i, j)){
                    check = false;
                    break;
                }
            }
        }
        assertTrue(check);
    }

}

