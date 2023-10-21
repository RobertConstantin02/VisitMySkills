package com.example.usecase.character

import androidx.paging.PagingData
import com.example.domain_model.character.CharacterBo
import com.example.usecase.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface IGetAllCharactersUseCase: PagingUseCase<Unit, PagingData<CharacterBo>>

//interface IGetAllCharactersUseCase{
//    operator fun invoke(): Flow<PagingData<CharacterBo>>
//}