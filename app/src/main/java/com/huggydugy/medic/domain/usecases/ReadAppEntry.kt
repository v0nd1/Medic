package com.huggydugy.medic.domain.usecases

import com.huggydugy.medic.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {

    operator fun invoke(): Flow<Boolean>{
        return localUserManger.readAppEntry()
    }

}