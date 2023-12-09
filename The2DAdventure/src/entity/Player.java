package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2 -(gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 25;

        setDefaultValues();
        getPlayerImage();


    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 8;
        worldY = gp.tileSize * 7;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try{
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/up1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/up2.png")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/up3.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/down1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/down2.png")));
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/down3.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/left2.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/left3.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/right1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/right2.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/right3.png")));

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if(keyH.upPressed){
                direction = "up";

            }
            else if(keyH.downPressed){
                direction = "down";
            }
            else if(keyH.leftPressed){
                direction = "left";
            }
            else if(keyH.rightPressed){
                direction = "right";
            }
            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //IF COLLISION IS FALSE, PLAYER MOVE
            if (!collisionOn){
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }

            spriteCounter++;
            if(spriteCounter > 11){
                if(spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum == 2){
                    spriteNum = 3;
                } else if (spriteNum == 3){
                    spriteNum = 4;
                }
                else if (spriteNum == 4){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            spriteNum = 1;
        }

    }
    public void pickUpObject(int i){
        if(i != 999){

            String objectName = gp.obj[i].name;

            switch(objectName){
                case"Key" -> {
                    gp.playSE(2);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got a key!");
                }
                case"Door" -> {
                    if(hasKey > 0){
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You unlocked a door!");
                    }
                    else{
                        gp.playSE(1);
                        gp.ui.showMessage("It's locked.");
                    }

                }
                case"Chest" -> {
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(2);
                }
            }
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up3;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up1;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down3;
                }
                if (spriteNum == 2) {
                    image = down1;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left3;
                }
                if (spriteNum == 3) {
                    image = left1;
                }
                if (spriteNum == 4) {
                    image = left2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right1;
                }
                if (spriteNum == 4) {
                    image = right3;
                }
            }
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
