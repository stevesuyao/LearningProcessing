import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class exercise_15_12 extends PApplet {

// Learning Processing
// Daniel Shiffman
// http://www.learningprocessing.com

// Image variable
PImage img;

public void setup() {
  size(200, 200);
  // Load the file from the data folder
  img = loadImage("sunflower.jpg");  
  smooth();
}

public void draw() {
  background(255);
  // Call loadPixels before we deal with pixels
  loadPixels();  
  // Loop through all pixels, skip every 10 pixels along the y-axis
  for (int y = 0; y < img.height; y+=10 ) {
    // skip every 5 pixels along the x-axis
    for (int x = 0; x < img.width+5; x+=5) {
      // Calculate the 1D location from a 2D grid
      int loc = x + y*img.width;
      // Color according to the image
      stroke(img.pixels[loc]);
      fill(img.pixels[loc]);
      // Draw a triangle pointing up or pointing down
      if (x %10 == 0) triangle(x-5,y,x,y+10,x+5,y);
      else triangle(x-5,y+10,x,y,x+5,y+10);
    }
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "exercise_15_12" });
  }
}
