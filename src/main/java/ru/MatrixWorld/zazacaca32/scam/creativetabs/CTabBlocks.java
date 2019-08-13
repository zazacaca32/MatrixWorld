package ru.MatrixWorld.zazacaca32.scam.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CTabBlocks extends CreativeTabs {
    public CTabBlocks(String tabBlocksName) {
        super(tabBlocksName);
    }

    @Override
    public Item getTabIconItem() {
        return Items.diamond;
    }
}
