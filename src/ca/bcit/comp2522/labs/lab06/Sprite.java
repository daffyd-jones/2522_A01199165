package ca.bcit.comp2522.labs.lab06;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.Serializable;
import java.util.Arrays;

public class Sprite implements Serializable {
  private int x, y;
  private int health;
  private transient float gravity;
  private String[] weapons;
  private byte[] pixelData;


  public Sprite(final int x, final int y, final int health,
                float gravity, final String[] weapons,
                final BufferedImage img) {
    this.x = x;
    this.y = y;
    this.health = health;
    this.gravity = gravity;
    this.weapons = weapons;
    this.pixelData = ((DataBufferByte)
        img.getRaster().getDataBuffer()).getData();
  }

  @Override
  public String toString() {
    return "Sprite{"
        + "x=" + x
        + ", y=" + y
        + ", health=" + health
        + ", gravity=" + gravity
        + ", weapons=" + Arrays.toString(weapons)
        + '}';
  }
}
