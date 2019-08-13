package ru.MatrixWorld.zazacaca32.scam.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.recipe.Recipes;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.block.invslot.InvSlotProcessableGeneric;
import ic2.core.block.machine.container.ContainerStandardMachine;
import ic2.core.block.machine.gui.GuiMacerator;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import ic2.core.upgrade.UpgradableProperty;
import java.util.EnumSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ru.MatrixWorld.zazacaca32.scam.gui.GuiMyMacerator;

public class TileEntityMyMacerator extends TileEntityStandardMachine {

    public static String name = "tileEntityMyMacerator";

    public static List<Entry<ItemStack, ItemStack>> recipes = new Vector();

    public TileEntityMyMacerator()
    {
        super(12, 100, 1);

        this.inputSlot = new InvSlotProcessableGeneric(this, "input", 0, 1, Recipes.macerator);
    }

    public static void init()
    {
        Recipes.macerator = new BasicMachineRecipeManager();
//        Recipes.macerator.addRecipe();
    }

    public String getInventoryName()
    {
        return "Macerator1";
    }

    @SideOnly(Side.CLIENT)
    public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin)
    {
        return new GuiMyMacerator(new ContainerStandardMachine(entityPlayer, this));
    }

    public String getStartSoundFile()
    {
        return "Machines/MaceratorOp.ogg";
    }

    public String getInterruptSoundFile()
    {
        return "Machines/InterruptOne.ogg";
    }

    public float getWrenchDropRate()
    {
        return 0.85F;
    }

    public Set<UpgradableProperty> getUpgradableProperties()
    {
        return EnumSet.of(UpgradableProperty.Processing, UpgradableProperty.Transformer, UpgradableProperty.EnergyStorage, UpgradableProperty.ItemConsuming, UpgradableProperty.ItemProducing);
    }
}
