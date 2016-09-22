/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author nokid4249
 */
public class Boo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your phrase");
        String input = in.nextLine();
        BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", Font.PLAIN, 16));
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(input, 6, 24);
        ImageIO.write(image, "png", new File("text.png"));

        for (int y = 0; y < 32; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 144; x++) {
                sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            System.out.println(sb);
        }

    }
}
