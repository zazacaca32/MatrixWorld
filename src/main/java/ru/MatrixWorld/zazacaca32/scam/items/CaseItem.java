package ru.MatrixWorld.zazacaca32.scam.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.MatrixWorld.zazacaca32.scam.lib.Constants;

public class CaseItem extends Item {

    long inl = 0L;

    public CaseItem(CreativeTabs creativeTab, String UnlocalizedName) {
        setUnlocalizedName(Constants.ModID + "_" + UnlocalizedName);
        setCreativeTab(creativeTab);
        setTextureName(Constants.ModID + ":" + UnlocalizedName);
        GameRegistry.registerItem(this, UnlocalizedName);
    }

//    @Override
//    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
//    {
//        return item.set;
//    }
    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (stack.getItemDamage() >= 2) return false;
        if (world.isRemote) return false;
        if (this.inl > System.currentTimeMillis()) return false;
        this.inl = (System.currentTimeMillis() + 200L);
        stack.stackSize -= 1;
        return true;
    }
}

