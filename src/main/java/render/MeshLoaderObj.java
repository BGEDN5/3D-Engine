package render;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class MeshLoaderObj implements MeshLoader {

    @Override
    public Mesh loadMesh(String path) throws IOException {
        Vertex[] vertices = new Vertex[0];
        List<Integer> list = new ArrayList<>();
        Stream<String[]> stream = Files.lines(Path.of(path)).map(line -> line.split(" "));
        vertices = stream.filter(line -> line[0].equals("v"))
                .map(line -> new Vertex(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])))
                .toList().toArray(vertices);
        stream.filter(line -> line[0].equals("f"))
                .forEach(line -> list.addAll(List.of(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]))));
        int[] indices = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            indices[i] = list.get(i);
        }
        return new Mesh(vertices, indices);
    }

}