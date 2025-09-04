package me.pectics.nova.addon.guidebook.item

import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.ItemStack
import xyz.xenondevs.nova.world.item.behavior.ItemBehavior
import xyz.xenondevs.nova.world.player.WrappedPlayerInteractEvent
import xyz.xenondevs.nova.world.player.swingMainHandEventless

object GuideBehavior : ItemBehavior {

    override fun handleInteract(
        player: Player,
        itemStack: ItemStack,
        action: Action,
        wrappedEvent: WrappedPlayerInteractEvent
    ) {
        if (action.isRightClick && player.hasPermission("nova.command.items")) {
            player.swingMainHandEventless()
            player.performCommand("nova items")
        }
        return super.handleInteract(player, itemStack, action, wrappedEvent)
    }

    override fun modifyClientSideStack(player: Player?, server: ItemStack, client: ItemStack): ItemStack {
        val meta = client.itemMeta.clone()
        meta.setEnchantmentGlintOverride(true)
        meta.setMaxStackSize(1)
        meta.setRarity(ItemRarity.RARE)
        client.itemMeta = meta
        return client
    }

}