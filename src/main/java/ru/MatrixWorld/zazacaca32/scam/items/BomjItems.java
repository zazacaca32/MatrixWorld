package ru.MatrixWorld.zazacaca32.scam.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.MatrixWorld.zazacaca32.scam.lib.Constants;

public class BomjItems extends Item {

    public BomjItems(CreativeTabs creativeTab, String UnlocalizedName) {
        setUnlocalizedName(Constants.ModID + "_" + UnlocalizedName);
        setCreativeTab(creativeTab);
        setTextureName(Constants.ModID + ":" + UnlocalizedName);
        GameRegistry.registerItem(this, UnlocalizedName);
    }
}
