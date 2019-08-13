package ru.MatrixWorld.zazacaca32.scam.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.GuiIC2;
import ic2.core.block.machine.container.ContainerStandardMachine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import ru.MatrixWorld.zazacaca32.scam.tile.TileEntityMyMacerator;

import static codechicken.lib.gui.GuiDraw.fontRenderer;

@SideOnly(Side.CLIENT)
public class GuiMyMacerator extends GuiIC2
{
    public ContainerStandardMachine container;
    public String name;
    public String inv;
    private static final ResourceLocation background = new ResourceLocation("ic2", "textures/gui/GUIMacerator.png");

    public GuiMyMacerator(ContainerStandardMachine container)
    {
        super(container);
        this.container = container;
        this.name = StatCollector.translateToLocal("ic2.blockMacerator");
        this.inv = StatCollector.translateToLocal("container.inventory");
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRenderer.drawString(this.name, (super.xSize - fontRenderer.getStringWidth(this.name)) / 2, 6, 4210752);
        fontRenderer.drawString(this.inv, 8, super.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        super.mc.getTextureManager().bindTexture(background);
        int j = (super.width - super.xSize) / 2;
        int k = (super.height - super.ySize) / 2;
        this.drawTexturedModalRect(j, k, 0, 0, super.xSize, super.ySize);
        int chargeLevel = (int)(14.0F * ((TileEntityMyMacerator)this.container.base).getChargeLevel());
        int progress = (int)(24.0F * ((TileEntityMyMacerator)this.container.base).getProgress());

        if (chargeLevel > 0)
        {
            this.drawTexturedModalRect(j + 56, k + 36 + 14 - chargeLevel, 176, 14 - chargeLevel, 14, chargeLevel);
        }

        if (progress > 0)
        {
            this.drawTexturedModalRect(j + 79, k + 34, 176, 14, progress + 1, 16);
        }
    }

    @Override
    public String getName() {
        return StatCollector.translateToLocal("ic2.Macerator.gui.name"); // Текст в гуи(название)
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return background;
    }
}
