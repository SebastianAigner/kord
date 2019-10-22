package com.gitlab.kordlib.core.builder.channel

import com.gitlab.kordlib.common.entity.ChannelType
import com.gitlab.kordlib.core.builder.AuditRequestBuilder
import com.gitlab.kordlib.core.builder.KordDsl
import com.gitlab.kordlib.core.entity.PermissionOverwrite
import com.gitlab.kordlib.core.entity.Snowflake
import com.gitlab.kordlib.rest.json.request.GuildCreateChannelRequest

@KordDsl
class VoiceChannelCreateBuilder : AuditRequestBuilder<GuildCreateChannelRequest> {
    override var reason: String? = null
    lateinit var name: String
    var bitrate: Int? = null
    var userLimit: Int? = null
    var parentId: Snowflake? = null
    var position: Int? = null
    val permissionOverwrites: MutableList<PermissionOverwrite> = mutableListOf()

    override fun toRequest(): GuildCreateChannelRequest = GuildCreateChannelRequest(
            name = name,
            bitrate = bitrate,
            userLimit = userLimit,
            parentId = parentId?.value,
            position = position,
            permissionOverwrite = permissionOverwrites.map { it.toOverwrite() },
            type = ChannelType.GuildVoice
    )
}