package tgobmdev.pessoaapi.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import tgobmdev.pessoaapi.api.zipcode.response.AddressInfo
import tgobmdev.pessoaapi.entity.AddressEntity
import tgobmdev.pessoaapi.request.AddressRequest

@Mapper(componentModel = "spring")
fun interface AddressMapper {

    @Mappings(
        Mapping(source = "addressInfo.result.street", target = "street"),
        Mapping(source = "addressRequest.zipcode", target = "zipcode"),
        Mapping(source = "addressRequest.streetNumber", target = "streetNumber"),
        Mapping(source = "addressInfo.result.city", target = "city"),
        Mapping(source = "addressInfo.result.state", target = "state"),
        Mapping(source = "addressInfo.result.stateShortname", target = "stateShortname"),
        Mapping(target = "personEntities", ignore = true)
    )
    fun toEntity(addressInfo: AddressInfo, addressRequest: AddressRequest): AddressEntity
}