package me.pectics.nova.addon.guidebook.item

import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.ItemStack
import xyz.xenondevs.nova.world.item.behavior.ItemBehavior
import xyz.xenondevs.nova.world.player.WrappedPlayerInteractEvent

object GuideBehavior : ItemBehavior {

    override fun handleInteract(
        player: Player,
        itemStack: ItemStack,
        action: Action,
        wrappedEvent: WrappedPlayerInteractEvent
    ) {
        if (action.isRightClick && player.hasPermission("nova.command.items"))
            player.performCommand("nova items")
        return super.handleInteract(player, itemStack, action, wrappedEvent)
    }

    override fun modifyClientSideStack(player: Player?, server: ItemStack, client: ItemStack): ItemStack {
        client.itemMeta.setEnchantmentGlintOverride(true)
        client.itemMeta.setMaxStackSize(1)
        client.itemMeta.setRarity(ItemRarity.RARE)
        return client
    }

}