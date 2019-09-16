package ru.MatrixWorld.zazacaca32.scam.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.MatrixWorld.zazacaca32.scam.gui.CaseGui;
import ru.MatrixWorld.zazacaca32.scam.gui.CaseGuiCircle;
import ru.MatrixWorld.zazacaca32.scam.lib.Constants;

public class CaseItem extends Item {

    long inl = 0L;

    public CaseItem(CreativeTabs creativeTab, String UnlocalizedName) {
        setUnlocalizedName(Constants.ModID + "_" + UnlocalizedName);
        setCreativeTab(creativeTab);
        setTextureName(Constants.ModID + ":" + UnlocalizedName);
        GameRegistry.registerItem(this, UnlocalizedName);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if (!world.isRemote) {return item;}
        if (player.isSneaking())
//        Minecraft.getMinecraft().displayGuiScreen(new CaseGuiLib());
            Minecraft.getMinecraft().displayGuiScreen(new CaseGuiCircle("https://sun9-8.userapi.com/c858436/v858436968/3f1be/Idenpl9Ox2I.jpg"));
//            Minecraft.getMinecraft().displayGuiScreen(new GuiCaseWon(new ItemStack(Blocks.diamond_block,1), 1));
        else
        Minecraft.getMinecraft().displayGuiScreen(new CaseGui("https://sun9-8.userapi.com/c858436/v858436968/3f1be/Idenpl9Ox2I.jpg"));
        return item;
    }
//    @Override
//    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
//    {
//        if (stack.getItemDamage() >= 2) return false;
//        if (world.isRemote) return false;
//        if (this.inl > System.currentTimeMillis()) return false;
//        this.inl = (System.currentTimeMillis() + 200L);
//        stack.stackSize -= 1;
//        return true;
//    }
}

