package com.LDTS22_23.FB_WG.model.menu;

import com.LDTS22_23.FB_WG.model.Position;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderMenuBuilder extends MenuBuilder {
    private final List<String> lines = new ArrayList<>();
    public LoaderMenuBuilder() throws IOException {
        URL resource = LoaderMenuBuilder.class.getResource("/Menus/Menu.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        for (String line; (line = br.readLine()) != null;)
            lines.add(line);
    }
    public List<Position> createRed() {
        List<Position> Red = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'F') Red.add(new Position(x, y));
        }
        return Red;
    }
    public List<Position> createBlue() {
        List<Position> Blue = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'W') Blue.add(new Position(x, y));
        }
        return Blue;
    }
    public List<Position> createBorder() {
        List<Position> Border = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') Border.add(new Position(x, y));
        }
        return Border;
    }
}
