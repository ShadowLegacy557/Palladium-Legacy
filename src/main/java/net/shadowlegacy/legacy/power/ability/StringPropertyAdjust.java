package net.shadowlegacy.legacy.power.ability;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.threetag.palladium.power.IPowerHolder;
import net.threetag.palladium.util.icon.ItemIcon;
import net.threetag.palladium.util.property.FloatProperty;
import net.threetag.palladium.util.property.IntegerProperty;
import net.threetag.palladium.util.property.PalladiumProperty;
import net.shadowlegacy.legacy.util.property.PalladiumProperties;

public class StringPropertyAdjust extends Ability {

    public static final PalladiumProperty<String> PROPERTY = new StringProperty("property").configurable("Sets the property to adjust");
    public static final PalladiumProperty<String> VALUE = new StringProperty("value").configurable("Sets the value for the adjusted property");

    public StringPropertyAdjust() {
        this.withProperty(PROPERTY, 20);
        this.withProperty(VALUE, 3F);
        this.withProperty(ICON, new ItemIcon(Items.APPLE));
    }

    @Override
    public void tick(LivingEntity entity, AbilityInstance entry, IPowerHolder holder, boolean enabled) {
        if (enabled && !entity.level().isClientSide) {
            int frequency = entry.getProperty(FREQUENCY);
            if (frequency != 0 && entity.tickCount % frequency == 0) {
                entity.heal(entry.getProperty(AMOUNT));
            }
        }
    }

    @Override
    public String getDocumentationDescription() {
        return "Adjusts a string property.";
    }
}