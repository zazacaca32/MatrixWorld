package ru.MatrixWorld.zazacaca32.scam.init;


import net.minecraft.item.Item;
import ru.MatrixWorld.zazacaca32.scam.MatrixWorld;
import ru.MatrixWorld.zazacaca32.scam.items.BomjItems;
import ru.MatrixWorld.zazacaca32.scam.items.CaseItem;

public final class ModItems {

    public static Item ruble1Item;
    public static Item ruble2Item;
    public static Item ruble5Item;
    public static Item ruble10Item;
    public static Item ruble50Item;
    public static Item ruble100Item;
    public static Item ruble200Item;
    public static Item ruble500Item;
    public static Item ruble1000Item;
    public static Item ruble2000Item;
    public static Item ruble5000Item;
    public static Item caseItem;

    public static void init() {
        ruble1Item = new BomjItems(MatrixWorld.tab, "1ruble");
        ruble2Item = new BomjItems(MatrixWorld.tab, "2ruble");
        ruble5Item = new BomjItems(MatrixWorld.tab, "5ruble");
        ruble10Item = new BomjItems(MatrixWorld.tab, "10ruble");
        ruble50Item = new BomjItems(MatrixWorld.tab, "50ruble");
        ruble100Item = new BomjItems(MatrixWorld.tab, "100ruble");
        ruble200Item = new BomjItems(MatrixWorld.tab, "200ruble");
        ruble500Item = new BomjItems(MatrixWorld.tab, "500ruble");
        ruble1000Item = new BomjItems(MatrixWorld.tab, "1000ruble");
        ruble2000Item = new BomjItems(MatrixWorld.tab, "2000ruble");
        ruble5000Item = new BomjItems(MatrixWorld.tab, "5000ruble");
        caseItem = new CaseItem(MatrixWorld.tab, "case");
    }
}
