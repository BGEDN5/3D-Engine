//package demo;
//
//import render.Mesh;
//import render.Shader;
//import utils.TimeUtility;
//
//import static java.lang.Math.abs;
//import static java.lang.Math.sin;
//import static java.lang.System.load;
//
//public class TestGame() {
//
//        Shader shader = new Shader();
//        Mesh mesh = new Mesh();
//
//
//        float tmp = 0;
//        float uniformValue = 1.0F;
//        public void update() {
//
//            this.shader.addVertexShader(load("vertex.vs"));
//            this.shader.addFragmentShader(load("fragment.fs"));
//
//            TimeUtility Time = new TimeUtility();
//            tmp += Time.getDeltaTime();
//            uniformValue = (float) abs(sin(tmp));
//        }
//
//        public void render() {
//            this.shader.bind();
//            this.shader.setUniformf("floatUniform", uniformValue);
//            this.mesh.draw();
//        }
//
//
//
//
//
//
//
//}