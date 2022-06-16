package render;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Meshloader implementation to implement loading mesh
 */
public class ObjMeshLoader implements MeshLoader {

    /**
     * This method loads mesh which is read from file(path)
     * @param path file where data is saved
     * @return Mesh that is read from file(path)
     * @throws IOException exception is file could not be opened
     */
    @Override
    public Mesh loadMesh(String path) throws IOException {
        List<Integer> indicesList = new ArrayList<>();
        List<Vertex> vertexList = new ArrayList<>();
        List<String[]> text = Files.lines(Path.of(path)).map(line -> line.split(" ")).collect(Collectors.toList());
        for (var t : text) {
            System.out.println(Arrays.toString(t));
        }
        text.stream().filter(line -> line[0].equals("v"))
                .forEach(line -> vertexList.addAll(List.of(new Vertex(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])))));

        text.stream().filter(line -> line[0].equals("f"))
                .forEach(line -> indicesList.addAll(List.of(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]))));
        int[] indices = new int[indicesList.size()];
        for (int i = 0; i < indicesList.size(); i++) {
            indices[i] = indicesList.get(i);
        }
        Vertex[] vertices = new Vertex[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            vertices[i] = vertexList.get(i);
        }
        return new Mesh(vertices, indices);
    }

}