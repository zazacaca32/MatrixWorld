package ru.MatrixWorld.zazacaca32.scam.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.block.BlockMultiID;
import ic2.core.block.machine.tileentity.*;
import ic2.core.init.InternalName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.apache.commons.lang3.mutable.MutableObject;
import ru.MatrixWorld.zazacaca32.scam.init.Ic2Items;
import ru.MatrixWorld.zazacaca32.scam.items.ItemMyMachine;
import ru.MatrixWorld.zazacaca32.scam.tile.TileEntityMyMacerator;

import java.util.*;

public class MyMachine extends BlockMultiID  {

    public MyMachine(InternalName internalName) {
        super(internalName, Material.iron, ItemMyMachine.class);
        this.setHardness(2.0F);
        this.setStepSound(Block.soundTypeMetal);
        Ic2Items.zaza1 = new ItemStack(this, 1, 0);
        Ic2Items.zaza = new ItemStack(this, 2, 0);
    }

    public String getTextureFolder()
    {
        return "machine";
    }

    public int damageDropped(int meta)
    {
        switch (meta)
        {
            case 0:
                return Ic2Items.zaza.getItemDamage();

            case 1:
                return Ic2Items.zaza.getItemDamage();

            case 2:
                return Ic2Items.zaza.getItemDamage();

            default:
                return Ic2Items.zaza.getItemDamage();
        }
    }


    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        world.getBlockMetadata(i, j, k);
    }

        // Дальше копипаст из класса индастриала
        @SideOnly(Side.CLIENT)
        public EnumRarity getRarity(ItemStack stack)
        {
            return stack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.common;
        }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        TileEntity te = par1World.getTileEntity(par2, par3, par4);
        return te instanceof TileEntityTeleporter ? (((TileEntityTeleporter)te).targetSet ? 15 : 0) : 0;
    }

    @Override
    public Class<? extends TileEntity> getTeClass(int meta, MutableObject<Class<?>[]> mutableObject, MutableObject<Object[]> mutableObject1) {
        if (meta == 1) return TileEntityMyMacerator.class;
        return null;
    }
}