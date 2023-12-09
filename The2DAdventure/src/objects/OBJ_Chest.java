package objects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Chest extends SuperObject{
    public OBJ_Chest() {
        name = "Chest";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Objects/094_Chest_1.png")));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
