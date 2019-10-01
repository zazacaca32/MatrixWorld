package ru.MatrixWorld.zazacaca32.scam.gui;


import cpw.mods.fml.common.FMLLog;
import ic2.core.Ic2Items;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ru.MatrixWorld.zazacaca32.scam.lib.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaseGuiCircle extends CustomGui {

    float rollMove = 0;
    private boolean end = true;
    private long currentTime = System.currentTimeMillis();
    private long lastTime = currentTime;
    private int oval = 70;
    private float slow = 9.38F + new Random().nextFloat() * (9.42F - 9.38F);
    private float plavnost = 0;
    private  float j = 0;
    private  float debug = 0;
    float minus_plavnost  = 0.01f;


    public CaseGuiCircle(String texture) {
        addTex("motd", texture);
    }
    @Override
    public void drawScreen(int x, int y, float ticks) {
        super.drawScreen(x, y, ticks);
        drawDefaultBackground();
        List<ItemStack> items = new ArrayList<>();
        items.add(Ic2Items.nuke);
        items.add(new ItemStack(Blocks.grass));
        items.add(Ic2Items.carbonMesh);
        items.add(new ItemStack(Blocks.ice));
        items.add(Ic2Items.iridiumDrill);
        items.add(new ItemStack(Items.experience_bottle));
        items.add(Ic2Items.advancedAlloy);
        items.add(Ic2Items.scrapBox);
        items.add(Ic2Items.hazmatHelmet);


        int guiX = width / 2 - 255 / 2;
        int guiY = height / 2 - 226 / 2;

        drawScaledString("ESC - \u0417\u0430\u043A\u0440\u044B\u0442\u044C", width / 2, 2, 1.6F, TextPosition.CENTER);

        mc.renderEngine.bindTexture(new ResourceLocation(Constants.ModID.toLowerCase(), "textures/gui/CaseTexture.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, 256, 255);

        for (int i = 0; i < items.size(); i++) {
//            float f = (float) ( (float)i / items.size() * Math.PI);  // Рассчитываем угол каждой картинки в радианах
//            int x1 = (int) (guiX + 120 + 75 * Math.sin(f+j));
//            int y1 = (int) (guiY + 120 + 75 * Math.cos(f+j));
            float f = (float) (Math.PI * 2/items.size() * i);
            FMLLog.getLogger().info(f+"  "+(f+j)+" "+j);
            int x1 = (int) (width / 2 + Math.cos(f+j) * 70);
            int y1 = (int) (height/2 + Math.sin(f+j) * 70);
            RenderHelper.disableStandardItemLighting();
            itemRender.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), items.get(i), x1, y1);
        }
        if (end) {
//            if (j <= 0)
                j -= plavnost;

            plavnost -= minus_plavnost;
            minus_plavnost += 0.0005f;
            if (plavnost <= 0) {
                plavnost = .6f;
                minus_plavnost = 0f;
                end = false;
            }
//            if (j < -700)
//                j = 0;
        }
//        if (plavnost > 0.25f) {
//        }

//            oval--;
//            if (oval < 50) oval = 70;
        RenderHelper.disableStandardItemLighting();
        drawScaledString(String.valueOf(j), width / 2, height/2, 1.6F, TextPosition.CENTER);
        drawScaledString(String.valueOf(plavnost), width / 2, height/2 + 15, 1.1F, TextPosition.CENTER);
        drawScaledString(String.valueOf(minus_plavnost), width / 2, height/2 + 25, 1.1F, TextPosition.CENTER);


                        GL11.glDisable(GL11.GL_TEXTURE_2D);

                GL11.glColor3f(1, 0, 0);
                GL11.glBegin(GL11.GL_LINES);
                GL11.glVertex2d(width/2, guiY);
                GL11.glVertex2f(width/2, height-guiY);
                GL11.glEnd();

                GL11.glColor3f(1, 1, 1);
                GL11.glEnable(GL11.GL_TEXTURE_2D);


                        GL11.glDisable(GL11.GL_TEXTURE_2D);

                GL11.glColor3f(1, 0, 0);
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex2d(126, 108);
                GL11.glVertex2f(126, 138);
                GL11.glVertex2f(152, 138);
                GL11.glVertex2f(152, 108);
                GL11.glEnd();

                GL11.glColor3f(1, 1, 1);
                GL11.glEnable(GL11.GL_TEXTURE_2D);

        if (isClicked(126, 108, 26, 30)){
            end = true;
        }

    }

    @Override
    public void initGui() {
    }

}
