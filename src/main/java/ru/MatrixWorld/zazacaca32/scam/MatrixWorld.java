package ru.MatrixWorld.zazacaca32.scam;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ic2.core.init.InternalName;
import net.minecraft.creativetab.CreativeTabs;
import ru.MatrixWorld.zazacaca32.scam.block.MyMachine;
import ru.MatrixWorld.zazacaca32.scam.creativetabs.CTabBlocks;
import ru.MatrixWorld.zazacaca32.scam.init.ModItems;
import ru.MatrixWorld.zazacaca32.scam.init.NetworkHandler;
import ru.MatrixWorld.zazacaca32.scam.lib.Constants;
import ru.MatrixWorld.zazacaca32.scam.proxy.CommonProxy;

@Mod(modid = Constants.ModID, name = Constants.ModName, version = Constants.Version, dependencies = "required-after:IC2;")
public class MatrixWorld {
    @Mod.Instance(Constants.ModID)
    public static MatrixWorld instance;

    @SidedProxy(clientSide = Constants.CLIENT_PROXY, serverSide = Constants.COMMON_PROXY)
    public static CommonProxy proxy;

    public static CreativeTabs tab = new CTabBlocks(Constants.tabName);

    @Mod.EventHandler // blocks, items, worldgen
    public void preInit(FMLPreInitializationEvent event){
        new MyMachine(InternalName.blockMachine);
        ModItems.init();
        NetworkHandler.init();
        proxy.preInit();
//        GameRegistry.registerWorldGenerator(new TestWorldGen(), 10); // higher number, lower in the priority list
    }

    @Mod.EventHandler // events, tile entities
    public void init(FMLInitializationEvent event){
        proxy.init();
//        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }

    @Mod.EventHandler // addons to other mods
    public void postInit(FMLPostInitializationEvent event){
        //
    }
}