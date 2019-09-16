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

public class CaseGui extends CustomGui {

    float rollMove = 0;
    private boolean end = true;
    private long currentTime = System.currentTimeMillis();
    private long lastTime = currentTime;
    private int randStop = 0;
    private float slow = 9.38F + new Random().nextFloat() * (9.42F - 9.38F);
    private int lal = 0;

    public CaseGui(String texture) {
        addTex("motd", texture);
    }
    @Override
    public void drawScreen(int x, int y, float ticks) {
        super.drawScreen(x, y, ticks);
        drawDefaultBackground();

        int guiX = width / 2 - 255 / 2;
        int guiY = height / 2 - 226 / 2;

        drawScaledString("ESC - \u0417\u0430\u043A\u0440\u044B\u0442\u044C", width / 2, 2, 1.6F, TextPosition.CENTER);

        mc.renderEngine.bindTexture(new ResourceLocation(Constants.ModID.toLowerCase(), "textures/gui/CaseTexture.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, 256, 255);
       // playSound("rolling");
        //bindTexture("motd");
       // drawCompleteImage(guiX + 8,guiY + 8,239,210);

        drawScaledString(Constants.itemsCanDrop, guiX + 12, guiY + 83, 0.85F, CustomGui.TextPosition.LEFT); //==============

        List<ItemStack> items = new ArrayList<>();
        items.add(Ic2Items.nuke);
        items.add(new ItemStack(Blocks.grass));
        items.add(Ic2Items.carbonMesh);
        items.add(new ItemStack(Blocks.ice));
        items.add(Ic2Items.iridiumDrill);
        items.add(new ItemStack(Items.experience_bottle));
        items.add(Ic2Items.advancedAlloy);

        currentTime = System.currentTimeMillis();
        int num, num2;
        for (int i = 0; i < items.size(); i++) {
             num = (int) (guiX + rollMove + 25.0F + 40.0F * i);
             num2 = (int)(guiX + rollMove + 25.0F - 40.0F * i);
            ItemStack is = items.get(i);
//            if (num2 < 100){
//                continue;
//            }

            if (num > 320){
                 drawItem((int)(guiX + rollMove + 25.0F - 40.0F * lal), guiY + 26, is);
                lal++;
                 continue;
             }

            drawItem((int)(guiX + rollMove + 25.0F + 40.0F * i), guiY + 26, is);
            lal = 0;
        }
        if (currentTime > lastTime+200) {
            playSound("rolling");
            lastTime = currentTime;
        }

            rollMove++;
            if (rollMove > 205) rollMove = 0;

            end = false;

       // draw3DGuiItem(item, 100, 100, 40F);
        RenderHelper.disableStandardItemLighting();
        for (int i = 0; i < 7; i++) {
            GL11.glPushMatrix();
            GL11.glTranslated(guiX + 7 + 36 * i, guiY + 93, 1);
            GL11.glScaled(2, 2, 1);
            itemRender.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), items.get(i), 0, 0);
            GL11.glScaled(1, 1, 1);
            GL11.glPopMatrix();

        }

        for (int i = 0; i < 7; i++) {
            if (isHover(guiX + 10+ 36 * i, guiY + 94, 26, 30)) {
                renderToolTip(items.get(i), guiX + 10+ 36 * i, guiY + 93);
//                GL11.glDisable(GL11.GL_TEXTURE_2D);
//
//                GL11.glColor3f(1, 0, 0);
//                GL11.glBegin(GL11.GL_QUADS);
//                GL11.glVertex2d(126, 108);
//                GL11.glVertex2f(126, 138);
//                GL11.glVertex2f(152, 138);
//                GL11.glVertex2f(152, 108);
//                GL11.glEnd();
//
//                GL11.glColor3f(1, 1, 1);
//                GL11.glEnable(GL11.GL_TEXTURE_2D);

            }
        }

    }

    @Override
    public void initGui() {

    }
}
