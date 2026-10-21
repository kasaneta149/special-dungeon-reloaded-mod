package net.kasaneta.specialdungeonreloaded.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModFluids;

public class Rbl1Item extends BucketItem {
	public Rbl1Item() {
		super(SpecialDungeonReloadedModFluids.RBL_1.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}