package ru.MatrixWorld.zazacaca32.scam.items;

import ic2.core.item.block.ItemBlockIC2;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemMyMachine extends ItemBlockIC2 {
    public ItemMyMachine(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

/**
 * Returns the metadata of the block which this Item (ItemBlock) can place
 */
public int getMetadata(int i)
{
    return i;
}

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack itemstack)
    {
        int meta = itemstack.getItemDamage();

        switch (meta)
        {
            case 0:
                return "ic2.blockMyMacerator0";

            case 1:
                return "ic2.blockMyMacerator1";

            case 2:
                return "ic2.blockMyMacerator2";

            default:
                return null;
        }
    }
}
