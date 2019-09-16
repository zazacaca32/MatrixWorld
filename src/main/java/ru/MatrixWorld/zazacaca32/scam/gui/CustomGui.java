package ru.MatrixWorld.zazacaca32.scam.gui;

import com.google.common.collect.Maps;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class CustomGui extends GuiScreen {

//    ModelItemCase modelItemCase = new ModelItemCase();
    float delta = 0;
    final double tc = 60D;
    long lastTime = System.nanoTime();
    private int MX = 0;
    private int MY = 0;

    protected void drawScaledString(String text, float x, float y, float scale, TextPosition textPosition) {

        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0.0F);
        GL11.glScalef(scale, scale, 0.0F);

        if (textPosition == TextPosition.CENTER) {
            drawCenteredString(mc.fontRenderer, text, 0, 0, 0xFFFFFF);
        } else if (textPosition == TextPosition.LEFT) {
            drawString(mc.fontRenderer, text, 0, 0, 0xFFFFFF);
        } else if (textPosition == TextPosition.RIGHT) {
            drawString(mc.fontRenderer, text, -fontRendererObj.getStringWidth(text), 0, 0xFFFFFF);
        }
        GL11.glPopMatrix();
    }

    enum TextPosition {
        LEFT, CENTER, RIGHT
    }

    /**
     * Метод для отрисовки изображения с ЛЮБЫМ размером текстуры;
     * posX, posY - позиция width, height - размер
     */
    protected void drawCompleteImage(int posX, int posY, int width, int height) {
        GL11.glPushMatrix();

        GL11.glTranslatef(posX, posY, 0.0F);
        GL11.glBegin(7);

        GL11.glTexCoord2f(0.0F, 0.0F);
        GL11.glVertex3f(0.0F, 0.0F, 0.0F);
        GL11.glTexCoord2f(0.0F, 1.0F);
        GL11.glVertex3f(0.0F, height, 0.0F);
        GL11.glTexCoord2f(1.0F, 1.0F);
        GL11.glVertex3f(width, height, 0.0F);
        GL11.glTexCoord2f(1.0F, 0.0F);
        GL11.glVertex3f(width, 0.0F, 0.0F);
        GL11.glEnd();

        GL11.glPopMatrix();
    }

    public boolean isHover(int xx, int yy, int xx1, int yy1) {
        int mouseX = MX;
        int mouseY = MY;
        if (mouseX >= xx && mouseX < xx1+xx && mouseY >= yy && mouseY < yy1+yy) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isClicked(int xx, int yy, int xx1, int yy1) {
        int mouseX = MX;
        int mouseY = MY;
        if (mouseX >= xx && mouseX < xx1+xx && mouseY >= yy && mouseY < yy1+yy && isClicked) {
            return true;
        } else {
            return false;
        }
    }

    protected void drawItem(int x, int y, ItemStack is) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, 1);
        GL11.glScalef(1.1f, 1.1f, 1);
        itemRender.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), is,  0, 0);
        GL11.glScalef(1f, 1f, 1);
        GL11.glPopMatrix();
    }

    protected boolean isClicked = false;
    class Timing extends Thread {

        private int timer;

        public Timing(int timer) {
            this.timer = timer;
        }

        public void run() {
            try {
                Thread.sleep(timer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isClicked = false;
            stop();
        }
    }

    @Override
    protected void mouseClicked(int x, int y, int b) {
        super.mouseClicked(x, y, b);

        isClicked = true;
        Timing timing = new Timing(100); timing.start();
    }

    @Override
    public void drawScreen(int x, int y, float ticks) {
        MX = x;
        MY = y;
        double ns = 1000000000 / tc;
        long now = System.nanoTime();
        delta = (float) ((now - lastTime) / ns);
        lastTime = now;
    }

    protected void draw3DGuiItem(ItemStack itemStack, float x, float y, float scale) {
        ItemStack is = itemStack.copy();
        is.stackSize = 1;
        itemStack.setItemDamage(itemStack.getItemDamage());
        EntityItem entityItem = new EntityItem(mc.theWorld, 0D, 0D, 0D, is);
        entityItem.hoverStart = 0;
        GL11.glPushMatrix();


        RenderHelper.enableGUIStandardItemLighting();
        GL11.glTranslatef(x,y,14);
        GL11.glRotatef(-11, 1, 0, 0);
        GL11.glRotatef(160, 0, 1, 0);
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glScalef(scale,scale,scale);


//        RenderManager.instance.func_147939_a(entityItem, 0, 0, 0, 0.2F, 0.2F, false);
        RenderManager.instance.renderEntityWithPosYaw(entityItem, 0, 0, 0, 0.2F, 0.2F);

        RenderHelper.disableStandardItemLighting();
//        GL11.glPopMatrix();
//
//        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor3f(1, 0, 0);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(-10, 0, 0);
        GL11.glVertex3d(10, 0, 0);
        GL11.glEnd();

        GL11.glColor3f(0, 1, 0);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(0, -10, 0);
        GL11.glVertex3d(0, 10, 0);
        GL11.glEnd();

        GL11.glColor3f(0, 0, 1);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(0, 0, -10);
        GL11.glVertex3d(0, 0, 10);
        GL11.glEnd();

        GL11.glColor3f(1, 1, 1);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }

    public static void drawDebug() {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor3f(1, 0, 0);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(-10, 0, 0);
        GL11.glVertex3d(10, 0, 0);
        GL11.glEnd();

        GL11.glColor3f(0, 1, 0);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(0, -10, 0);
        GL11.glVertex3d(0, 10, 0);
        GL11.glEnd();

        GL11.glColor3f(0, 0, 1);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(0, 0, -10);
        GL11.glVertex3d(0, 0, 10);
        GL11.glEnd();

        GL11.glColor3f(1, 1, 1);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    protected void playSound(String name) {
        mc.thePlayer.playSound("teccs:" + name, 1.0F, 1.0F);
    }

    private static Map<String, DynamicTexture> images = Maps.newHashMap();

    public static void bindTexture(String name){
        if (images.get(name) != null)
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, images.get(name).getGlTextureId());
    }

    public void addTex(String name, String image){
        try {
            images.put(name, new DynamicTexture(ImageIO.read(new URL(image))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
