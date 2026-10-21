package net.kasaneta.specialdungeonreloaded.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModFluids;

public class LiquibonesItem extends BucketItem {
	public LiquibonesItem() {
		super(SpecialDungeonReloadedModFluids.LIQUIBONES.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}