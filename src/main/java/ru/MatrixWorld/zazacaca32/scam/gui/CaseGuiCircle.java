package ru.MatrixWorld.zazacaca32.scam.gui;


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
    private int randStop = 0;
    private float slow = 9.38F + new Random().nextFloat() * (9.42F - 9.38F);
    private int lal = 0;
    private  float j = 0;


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
            float f = (float) ( (float)i / items.size() * Math.PI);  // Рассчитываем угол каждой картинки в радианах
            int x1 = (int) (guiX + 120 + 75 * Math.sin(f+j));
            int y1 = (int) (guiY + 120 + 75 * Math.cos(f+j));
            itemRender.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), items.get(i), x1, y1);
        }
//        if (j <= 0 & j >= -27)
//            j -= .1f;
//        else if (j < -27 & j >= -50)
//            j -= .05f;
//        else if (j < -50)
            j = 0;

        RenderHelper.disableStandardItemLighting();
        drawScaledString(String.valueOf(j), width / 2, height/2, 1.6F, TextPosition.CENTER);
    }

    @Override
    public void initGui() {

    }
}
