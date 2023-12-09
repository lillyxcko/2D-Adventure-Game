package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;


    public TileManager(GamePanel gp) {

        this.gp = gp;
        tile = new Tile[100000];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        try{
            getTileImage();
        } catch (Exception e){
            System.out.println("getPlayerImage() is not working");
        }
        loadMap("Maps/maze01.txt");
    }

    public void getTileImage(){
        try{
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/000_Grass_Flat.png")));
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/001_Grass_Noise.png")));
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/002_Grass_Noise.png")));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/003_Grass_Noise.png")));
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/004_Grass_Noise.png")));
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/005_Grass_Noise.png")));
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/006_Grass_Leafy.png")));
            tile[16].collision = true;
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/007_Grass_Leafy.png")));
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/008_Grass_Leafy.png")));
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/009_Grass_Leafy.png")));
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/010_Grass_Leafy.png")));
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/011_Grass_Flower.png")));
            tile[21].collision = true;
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/012_Grass_Flower.png")));
            tile[22].collision = true;
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/013_Grass_Dirt_Flat.png")));
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/014_Grass_Dirt_Flat.png")));
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/015_Grass_Dirt_Flat.png")));
            tile[26] = new Tile();
            tile[26].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/016_Grass_Dirt_Flat.png")));
            tile[27] = new Tile();
            tile[27].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/017_Grass_Dirt_Flat.png")));
            tile[28] = new Tile();
            tile[28].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/018_Grass_Dirt_Flat.png")));
            tile[29] = new Tile();
            tile[29].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/019_Grass_Dirt_Flat.png")));
            tile[30] = new Tile();
            tile[30].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/020_Grass_Dirt_Flat.png")));
            tile[31] = new Tile();
            tile[31].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/021_Grass_Dirt_Flat.png")));
            tile[32] = new Tile();
            tile[32].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/022_Grass_Dirt_Flat.png")));
            tile[33] = new Tile();
            tile[33].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/023_Grass_Dirt_Flat.png")));
            tile[34] = new Tile();
            tile[34].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/024_Grass_Dirt_Flat.png")));
            tile[35] = new Tile();
            tile[35].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/025_Grass_Dirt_Flat.png")));
            tile[36] = new Tile();
            tile[36].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/026_Grass_Dirt_Flat.png")));
            tile[37] = new Tile();
            tile[37].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/027_Grass_Dirt_Texture.png")));
            tile[38] = new Tile();
            tile[38].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/028_Grass_Dirt_Texture.png")));
            tile[39] = new Tile();
            tile[39].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/029_Grass_Dirt_Texture.png")));
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/030_Grass_Dirt_Texture.png")));
            tile[41] = new Tile();
            tile[41].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/031_Grass_Dirt_Texture.png")));
            tile[42] = new Tile();
            tile[42].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/032_Grass_Dirt_Texture.png")));
            tile[43] = new Tile();
            tile[43].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/033_Grass_Dirt_Texture.png")));
            tile[44] = new Tile();
            tile[44].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/034_Grass_Dirt_Texture.png")));
            tile[45] = new Tile();
            tile[45].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/035_Grass_Dirt_Texture.png")));
            tile[46] = new Tile();
            tile[46].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/036_Grass_Dirt_Texture.png")));
            tile[47] = new Tile();
            tile[47].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/037_Grass_Dirt_Texture.png")));
            tile[48] = new Tile();
            tile[48].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/038_Grass_Dirt_Texture.png")));
            tile[49] = new Tile();
            tile[49].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/039_Grass_Dirt_Texture.png")));
            tile[50] = new Tile();
            tile[50].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/040_Grass_Dirt_Texture.png")));
            tile[51] = new Tile();
            tile[51].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/041_Dirt_Texture.png")));
            tile[52] = new Tile();
            tile[52].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/042_Dirt_Flat.png")));
            tile[53] = new Tile();
            tile[53].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/043_Dirt_Flat.png")));
            tile[54] = new Tile();
            tile[54].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/044_Dirt_Flat.png")));
            tile[80] = new Tile();
            tile[80].image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tiles/070_Tree_2.png")));
            tile[80].collision = true;



        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String[] numbers = line.split("-");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e){
            System.out.println("loadMap() is not working");
        }
    }
    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //to improve efficiency for larger maps

//            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
//                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
//                worldY  + gp.tileSize > gp.player.worldX - gp.player.screenX &&
//                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
//
//                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
//            }

            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
