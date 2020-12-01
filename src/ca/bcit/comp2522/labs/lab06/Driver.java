package ca.bcit.comp2522.labs.lab06;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;



public class Driver {
  /**
   * main.
   * @param args not used
   */
  public static void main(final String[] args) throws IOException {
    String s1 = "Sword";
    String s2 = "Spear";
    String s3 = "Knife";
    String[] stArr = new String[4];
    stArr[0] = s1;
    stArr[1] = s2;
    stArr[2] = s3;
    byte[] pixelData;
    BufferedImage img = null;

    try {
      img = ImageIO.read(new File("Ainn.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Sprite sprite = new Sprite(2, 5, 100, 1, stArr, img);
    try {
      FileOutputStream fileOut = new FileOutputStream("sprite.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(sprite);
      out.close();
      System.out.println("Sprite was serialized to: sprite.ser");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    Sprite sprite2 = null;
    try {
      FileInputStream fileIn = new FileInputStream("sprite.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      sprite2 = (Sprite) in.readObject();
      in.close();
      fileIn.close();
      System.out.println("Reading file from ser");
    } catch (ClassNotFoundException e) {
      System.out.println("Sprite class not found");
      e.printStackTrace();
    }

    System.out.println(sprite2.toString());
    System.out.println("\n");

    Resources res = new Resources("Water Temple", 4, 4, 3, 78, 20);

    DataOutputStream out = null;
    Date date = new Date();
    String outfile = date + ".dat";
    outfile = outfile.replaceAll("\\s+", "").replaceAll(":", "");

    try {
      out = new DataOutputStream(new
          BufferedOutputStream(new FileOutputStream(outfile)));
      out.writeUTF(res.getLevelName());
      out.writeInt(res.getLevelNo());
      out.writeInt(res.getX());
      out.writeInt(res.getY());
      out.writeInt(res.getHealth());
      out.writeInt(res.getLevelEnemies());
    } finally {
      out.close();
    }

    DataInputStream in = null;
    String levelName = null;
    int levelNo = 0;
    int x = 0;
    int y = 0;
    int health = 0;
    int levelEnemies = 0;

    try {
      in = new DataInputStream(new
          BufferedInputStream(new FileInputStream(outfile)));

      try {
        while (true) {
          levelName = in.readUTF();
          levelNo = in.readInt();
          x = in.readInt();
          y = in.readInt();
          health = in.readInt();
          levelEnemies = in.readInt();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } finally {
      in.close();
    }
    Resources res2 = new Resources(levelName, levelNo, x, y, health,
        levelEnemies);
    System.out.print(res2.toString());












  } }