package render;

import java.io.IOException;

public interface MeshLoader {
    Mesh loadMesh(String path) throws IOException;
}
