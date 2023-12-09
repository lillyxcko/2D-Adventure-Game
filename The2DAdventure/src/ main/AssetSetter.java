package main;

import objects.OBJ_Chest;
import objects.OBJ_Door;
import objects.OBJ_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 14 * gp.tileSize;
        gp.obj[0].worldY = 9 * gp.tileSize;

        gp.obj[3] = new OBJ_Key();
        gp.obj[3].worldX = 16 * gp.tileSize;
        gp.obj[3].worldY = 19 * gp.tileSize;

        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 26 * gp.tileSize;
        gp.obj[4].worldY = 10 * gp.tileSize;

        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 16 * gp.tileSize;
        gp.obj[5].worldY = 29 * gp.tileSize;

        gp.obj[1] = new OBJ_Door();
        gp.obj[1].worldX = 24 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;

        gp.obj[6] = new OBJ_Key();
        gp.obj[6].worldX = 43 * gp.tileSize;
        gp.obj[6].worldY = 30 * gp.tileSize;

        gp.obj[2] = new OBJ_Chest();
        gp.obj[2].worldX = 54 * gp.tileSize;
        gp.obj[2].worldY = 30 * gp.tileSize;

        gp.obj[7] = new OBJ_Door();
        gp.obj[7].worldX = 54 * gp.tileSize;
        gp.obj[7].worldY = 28 * gp.tileSize;


    }

}
