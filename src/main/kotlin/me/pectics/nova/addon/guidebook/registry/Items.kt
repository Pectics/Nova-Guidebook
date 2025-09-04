package me.pectics.nova.addon.guidebook.registry

import me.pectics.nova.addon.guidebook.Guidebook.registerItem
import me.pectics.nova.addon.guidebook.item.GuideBehavior
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage

@Init(stage = InitStage.PRE_PACK)
object Items {

    val GUIDE = registerItem("guide", GuideBehavior, localizedName = "item.guidebook.guide")

}