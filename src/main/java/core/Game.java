package core;

import java.io.IOException;

public interface Game {

    void init() throws IOException;

    void update();

    void render();

}