package render;

import java.io.IOException;

/**
 * Interface to be implemented by ObjMeshLoader
 */
public interface MeshLoader {
    Mesh loadMesh(String path) throws IOException;
}
